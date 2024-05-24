package org.fmiplovdiv.weblanguages.todo.controllers;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.requests.TeamMemberRequest;
import org.fmiplovdiv.weblanguages.todo.dto.responses.TeamMemberResponse;
import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.fmiplovdiv.weblanguages.todo.service.TeamMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team-members")
public class TeamMemberController {

	private final TeamMemberService service;

	public TeamMemberController(TeamMemberService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public TeamMember createTeamMember(TeamMember toCreate) {
		return service.createTeamMember(toCreate);
	}
	
	@GetMapping("/{id}")
	public TeamMember getTeamMemberById(@PathVariable Long id) {
		return service.getTeamMemberById(id);
	}
	
	@GetMapping
	public List<TeamMember> getAllTeamMembers() {
		return service.getAllTeamMembers();
	}
}
