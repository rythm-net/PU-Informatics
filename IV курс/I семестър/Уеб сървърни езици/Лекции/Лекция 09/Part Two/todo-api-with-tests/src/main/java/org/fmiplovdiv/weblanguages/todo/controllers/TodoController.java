package org.fmiplovdiv.weblanguages.todo.controllers;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TodoRequest;
import org.fmiplovdiv.weblanguages.todo.dto.TodoResponse;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService service;
	
	@PostMapping
	public TodoResponse createTodo(@RequestBody TodoRequest toCreate) {
		return service.createTodo(toCreate);
	}

	@PutMapping
	public TodoResponse updateTodo(@RequestBody TodoRequest toUpdate) {
		return service.updateTodo(toUpdate);
	}
	
	@PostMapping("/markAsDone")
	public TodoResponse markAsDone(TodoRequest toMark) {
		return service.done(toMark);
	}
	
	@GetMapping("/{id}")
	public TodoResponse getTodoById(@PathVariable Long id) {
		return service.getTodoById(id);
	}
	
	@GetMapping
	public List<TodoResponse> getTodos() {
		return service.getAllTodos();
	}
	
}
