package org.fmiplovdiv.weblanguages.todo.controllers;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	private TodoRepository repository;
	
	@GetMapping("/todos")
	public List<Todo> getTodos() {
		return repository.findAll();
	}
}
