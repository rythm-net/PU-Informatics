package org.fmiplovdiv.weblanguages.todo.controllers;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRequest;
import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberResponse;
import org.fmiplovdiv.weblanguages.todo.dto.TodoResponse;
import org.fmiplovdiv.weblanguages.todo.model.TodoStatus;
import org.fmiplovdiv.weblanguages.todo.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team-members")
public class TeamMemberController {

	@Autowired
	private TeamMemberService service;

	@PostMapping
	public TeamMemberResponse createTeamMember(@RequestBody TeamMemberRequest toCreate) {
		return service.createTeamMember(toCreate);
	}

	@GetMapping("/{id}")
	public TeamMemberResponse getTeamMemberById(@PathVariable Long id) {
		return service.getTeamMemberById(id);
	}

	@GetMapping("/{id}/remaining")
	public List<TodoResponse> getAllRemainingTodosForTeamMember(@PathVariable Long id) {
		return service.getAllTodosByTeamMemberAndTodoStatus(id, TodoStatus.NOT_STARTED);
	}

	@GetMapping("/{id}/done")
	public List<TodoResponse> getAllDoneTodosForTeamMember(@PathVariable Long id) {
		return service.getAllTodosByTeamMemberAndTodoStatus(id, TodoStatus.DONE);
	}

	@GetMapping("/{id}/current")
	public TodoResponse getCurrentTodo(@PathVariable Long id) {
		return service.getCurrentTodo(id);
	}

	@GetMapping
	public List<TeamMemberResponse> getAllTeamMembers() {
		return service.getAllTeamMembers();
	}
}
