package org.fmiplovdiv.weblanguages.todo.service;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.dto.requests.TodoRequest;
import org.fmiplovdiv.weblanguages.todo.dto.responses.TodoResponse;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.model.TodoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private final TodoRepository todoRepository;
	private final TeamMemberRepository teamMemberRepository;

	public TodoService(
			TodoRepository todoRepository, 
			TeamMemberRepository teamMemberRepository) {
		super();
		this.todoRepository = todoRepository;
		this.teamMemberRepository = teamMemberRepository;
	}

	public List<TodoResponse> getAllTodos() {
		List<Todo> toReturn = todoRepository.findAll();
		
		if (toReturn.size() == 0) {
			return null;
		}
		
		return toReturn.stream()
				.map(t -> new TodoResponse(
						t.getId(), 
						t.getTask(), 
						t.getDescription(), 
						t.getTodoStatus().ordinal(), 
						t.getTeamMember().getId())
						)
				.toList();
	}
	
	public TodoResponse createTodo(TodoRequest toCreate) {
		if (!teamMemberRepository.existsById(toCreate.teamMember())) {
			 return null;
		}
		
		if (toCreate.task() == null || toCreate.description() == null) {
			return null;
		}
		
		Todo toSave = new Todo();
		toSave.setTask(toCreate.task());
		toSave.setDescription(toCreate.description());
		toSave.setTeamMember(teamMemberRepository.findById(toCreate.teamMember()).get());
		
		int inProgress = todoRepository
				.countByTeamMemberAndTodoStatus(
						toSave.getTeamMember(), 
						TodoStatus.IN_PROGRESS
						);
		
		if (inProgress == 0) {
			toSave.setTodoStatus(TodoStatus.IN_PROGRESS);
		} else {
			toSave.setTodoStatus(TodoStatus.NOT_STARTED);
		}
		
		toSave = todoRepository.save(toSave);
		
		return new TodoResponse(
				toSave.getId(), 
				toSave.getTask(), 
				toSave.getDescription(), 
				toSave.getTodoStatus().ordinal(), 
				toSave.getTeamMember().getId()
				);
	}
	
	public TodoResponse getTodoById(Long id) {
		Todo toReturn = todoRepository.findById(id).orElse(null);
		
		if (toReturn == null) {
			return null;
		}
		
		return new TodoResponse(
				toReturn.getId(), 
				toReturn.getTask(), 
				toReturn.getDescription(), 
				toReturn.getTodoStatus().ordinal(), 
				toReturn.getTeamMember().getId()
				);
	}

}
