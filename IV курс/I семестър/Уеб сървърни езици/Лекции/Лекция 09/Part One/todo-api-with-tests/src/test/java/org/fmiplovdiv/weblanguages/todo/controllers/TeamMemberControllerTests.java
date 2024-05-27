package org.fmiplovdiv.weblanguages.todo.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRequest;
import org.fmiplovdiv.weblanguages.todo.model.TodoStatus;
import org.fmiplovdiv.weblanguages.todo.service.TeamMemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TeamMemberControllerTests {
	
	@Mock
	TeamMemberService teamMemberService;

	@InjectMocks
	TeamMemberController teamMemberController;

	@Test
	void createTeamMemberTest() {
		TeamMemberRequest request = new TeamMemberRequest("John");
		teamMemberController.createTeamMember(request);
		
		verify(teamMemberService, times(1)).createTeamMember(request);
	}
	
	@Test
	void getAllDoneTodosForTeamMemberTest() {
		teamMemberController.getAllDoneTodosForTeamMember(1L);
		verify(teamMemberService, times(1)).getAllTodosByTeamMemberAndTodoStatus(1L, TodoStatus.DONE);
	}
}
