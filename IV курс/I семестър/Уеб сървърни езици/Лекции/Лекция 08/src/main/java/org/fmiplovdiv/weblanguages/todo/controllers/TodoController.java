package org.fmiplovdiv.weblanguages.todo.controllers;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.requests.TodoRequest;
import org.fmiplovdiv.weblanguages.todo.dto.responses.TodoResponse;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	private TodoService service;
	
	@GetMapping("/todos")
	public List<TodoResponse> getTodos() {
		return service.getAllTodos();
	}
	
	@PostMapping("/todos")
	public TodoResponse createTodo(TodoRequest toCreate) {
		return service.createTodo(toCreate);
	}
	
	@GetMapping("/todos/{id}")
	public TodoResponse getTodoById(@PathVariable Long id) {
		return service.getTodoById(id);
	}
	
}
