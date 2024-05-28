package org.fmiplovdiv.weblanguages.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRequest;
import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberResponse;
import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class TodoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	TeamMemberRepository repo;

	private void createTeamMember(String name) {
		TeamMember teamMember = new TeamMember();
		teamMember.setName(name);
		repo.save(teamMember);
	}

	@Test
	void teamMemberApiTest() throws Exception {
		final ObjectMapper objMapper = new ObjectMapper();

		createTeamMember("Bob");
		createTeamMember("Mary Smith");

		MvcResult result = mockMvc.perform(get("/team-members").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$[0].name", is("Bob"))).andReturn();

		// json of the result
		String strJson = result.getResponse().getContentAsString();
		List<TeamMemberResponse> teamMembers = objMapper.readValue(strJson,
				new TypeReference<List<TeamMemberResponse>>() {
				});
		assertThat(teamMembers).hasSize(2);
		assertThat(teamMembers.get(0).getName()).isEqualTo("Bob");
		assertThat(teamMembers.get(1).getName()).contains("Mary");

		// make a post and check if the new team member have been added to the database
		// using repo.findById
		TeamMemberRequest request = new TeamMemberRequest("John Smith");
		result = mockMvc
				.perform(post("/team-members").contentType(MediaType.APPLICATION_JSON)
						.content(objMapper.writeValueAsString(request)))
				.andExpectAll(status().is2xxSuccessful(), jsonPath("$.name", is("John Smith"))).andReturn();
		String stringResult = result.getResponse().getContentAsString();
		TeamMemberResponse response = objMapper.readValue(stringResult, TeamMemberResponse.class);

		Optional<TeamMember> john = repo.findById(response.getId());
		assertThat(john).isNotEmpty().satisfies(s -> assertThat(s.get().getName()).isEqualTo("John Smith"));
	}
}
