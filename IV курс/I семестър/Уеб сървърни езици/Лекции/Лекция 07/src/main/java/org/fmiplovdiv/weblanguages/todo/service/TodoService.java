package org.fmiplovdiv.weblanguages.todo.service;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private final TodoRepository repository;

	public TodoService(TodoRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Todo> getAllTodos() {
		return repository.findAll();
	}
	
	public Todo createTodo(Todo toCreate) {
		if (toCreate.getTask() == null || toCreate.getDescription() == null) {
			return null;
		}
		toCreate = repository.save(toCreate);
		return toCreate;
	}
	
	public Todo getTodoById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Todo getTodoByTask(String task) {
		return repository.findByTask(task);
	}
}
