package org.fmiplovdiv.weblanguages.todo.service;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRequest;
import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberResponse;
import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TodoResponse;
import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.model.TodoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TeamMemberService {

	private final TeamMemberRepository teamMemberRepository;
	private final TodoRepository todoRepository;

	public TeamMemberService(TeamMemberRepository teamMemberRepository, TodoRepository todoRepository) {
		super();
		this.teamMemberRepository = teamMemberRepository;
		this.todoRepository = todoRepository;
	}

	@Transactional
	public TeamMemberResponse createTeamMember(TeamMemberRequest toCreate) {

		if (toCreate.getName() == null) {
			return null;
		}

		TeamMember toSave = new TeamMember();
		toSave.setName(toCreate.getName());

		toSave = teamMemberRepository.save(toSave);

		return new TeamMemberResponse(toSave.getId(), toSave.getName());
	}

	public List<TeamMemberResponse> getAllTeamMembers() {
		List<TeamMember> toReturn = teamMemberRepository.findAll();

		if (toReturn.size() == 0) {
			return null;
		}

		return toReturn.stream().map(t -> new TeamMemberResponse(t.getId(), t.getName())).toList();
	}

	public TeamMemberResponse getTeamMemberById(Long id) {
		TeamMember toReturn = teamMemberRepository.findById(id).orElse(null);

		if (toReturn == null) {
			return null;
		}

		return new TeamMemberResponse(toReturn.getId(), toReturn.getName());
	}

	@Transactional
	public TodoResponse getCurrentTodo(Long id) {
		TeamMember teamMember = teamMemberRepository.findById(id).orElse(null);

		if (teamMember == null) {
			return null;
		}

		Todo currentTodo = todoRepository.findAllByTeamMemberAndTodoStatus(teamMember, TodoStatus.IN_PROGRESS).get(0);

		return new TodoResponse(currentTodo.getId(), currentTodo.getTask(), currentTodo.getDescription(),
				currentTodo.getTodoStatus().ordinal(), currentTodo.getTeamMember().getId());
	}

	@Transactional
	public List<TodoResponse> getAllTodosByTeamMemberAndTodoStatus(Long id, TodoStatus todoStatus) {
		TeamMember teamMember = teamMemberRepository.findById(id).orElse(null);

		if (teamMember == null) {
			return null;
		}

		List<Todo> todos = todoRepository.findAllByTeamMemberAndTodoStatus(teamMember, todoStatus);

		return todos.stream().map(t -> new TodoResponse(t.getId(), t.getTask(), t.getDescription(),
				t.getTodoStatus().ordinal(), t.getTeamMember().getId())).toList();
	}
}
