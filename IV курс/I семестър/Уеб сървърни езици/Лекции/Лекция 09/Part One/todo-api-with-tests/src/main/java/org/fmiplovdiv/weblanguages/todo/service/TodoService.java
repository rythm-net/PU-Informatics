package org.fmiplovdiv.weblanguages.todo.service;

import java.util.List;
import java.util.Optional;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TodoRequest;
import org.fmiplovdiv.weblanguages.todo.dto.TodoResponse;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.model.TodoStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TodoService {

	private final TodoRepository todoRepository;
	private final TeamMemberRepository teamMemberRepository;

	public TodoService(TodoRepository todoRepository, TeamMemberRepository teamMemberRepository) {
		super();
		this.todoRepository = todoRepository;
		this.teamMemberRepository = teamMemberRepository;
	}

	@Transactional
	public TodoResponse updateTodo(TodoRequest toUpdate) {
		if (!teamMemberRepository.existsById(toUpdate.getTeamMember())) {
			return null;
		}

		Optional<Todo> optional = todoRepository.findById(toUpdate.getId());
		if (optional.isEmpty()) {
			return null;
		}

		Todo t = optional.get();

		if (t.getTodoStatus() == TodoStatus.DONE) {
			return null;
		}

		if (!toUpdate.getTask().isEmpty()) {
			t.setTask(toUpdate.getTask());
		}

		if (!toUpdate.getDescription().isEmpty()) {
			t.setDescription(toUpdate.getDescription());
		}

		if (t.getTeamMember().getId() != toUpdate.getId()) {
			t.setTeamMember(teamMemberRepository.findById(toUpdate.getId()).get());
		}

		t = todoRepository.save(t);
		return new TodoResponse(t.getId(), t.getTask(), t.getDescription(), t.getTodoStatus().ordinal(),
				t.getTeamMember().getId());
	}

	@Transactional
	public TodoResponse createTodo(TodoRequest toCreate) {

		if (!teamMemberRepository.existsById(toCreate.getTeamMember())) {
			return null;
		}

		if (toCreate.getTask() == null || toCreate.getDescription() == null) {
			return null;
		}

		Todo toSave = new Todo();
		toSave.setTask(toCreate.getTask());
		toSave.setDescription(toCreate.getDescription());
		toSave.setTeamMember(teamMemberRepository.findById(toCreate.getTeamMember()).get());

		int inProgress = todoRepository.countByTeamMemberAndTodoStatus(toSave.getTeamMember(), TodoStatus.IN_PROGRESS);

		if (inProgress == 0) {
			toSave.setTodoStatus(TodoStatus.IN_PROGRESS);
		} else {
			toSave.setTodoStatus(TodoStatus.NOT_STARTED);
		}

		toSave = todoRepository.save(toSave);
		
		return new TodoResponse(toSave.getId(), toSave.getTask(), toSave.getDescription(),
				toSave.getTodoStatus().ordinal(), toSave.getTeamMember().getId());
	}

	public List<TodoResponse> getAllTodos() {
		List<Todo> toReturn = todoRepository.findAll();

		if (toReturn.size() == 0) {
			return null;
		}

		return toReturn.stream().map(t -> new TodoResponse(t.getId(), t.getTask(), t.getDescription(),
				t.getTodoStatus().ordinal(), t.getTeamMember().getId())).toList();
	}

	public TodoResponse getTodoById(Long id) {
		Todo toReturn = todoRepository.findById(id).orElse(null);

		if (toReturn == null) {
			return null;
		}

		return new TodoResponse(toReturn.getId(), toReturn.getTask(), toReturn.getDescription(),
				toReturn.getTodoStatus().ordinal(), toReturn.getTeamMember().getId());
	}

	@Transactional
	public TodoResponse done(TodoRequest toMark) {
		Todo todo = todoRepository.findById(toMark.getId()).orElse(null);

		if (todo == null) {
			return null;
		}

		if (todo.getTeamMember().getId() != toMark.getTeamMember()) {
			return null;
		}

		if (todo.getTodoStatus() == TodoStatus.IN_PROGRESS) {
			todo.setTodoStatus(TodoStatus.DONE);
			todo = todoRepository.save(todo);

			List<Todo> teamMemberTodos = todoRepository.findAllByTeamMemberAndTodoStatus(todo.getTeamMember(),
					TodoStatus.NOT_STARTED);

			if (teamMemberTodos.size() == 0) {
				return null;
			}

			long nextTodo = Long.MAX_VALUE;

			for (Todo t : teamMemberTodos) {
				if (t.getId() < nextTodo) {
					nextTodo = t.getId();
				}
			}

			todo = todoRepository.findById(nextTodo).get();

			todo.setTodoStatus(TodoStatus.IN_PROGRESS);

			todo = todoRepository.save(todo);

			return new TodoResponse(todo.getId(), todo.getTask(), todo.getDescription(), todo.getTodoStatus().ordinal(),
					todo.getTeamMember().getId());
		} else {
			return null;
		}

	}

}
