package org.fmiplovdiv.weblanguages.todo.controllers;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.misc.Application;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@Autowired
	private TodoService service;
	
	@Autowired
	private Application application;
	
	@Value("${todo.api.apiVersion}")
	private String apiVersion;
	
	@GetMapping("/v1/api")
	public Application getV1ApiInfo() {
		return application;
	}
	
	@GetMapping("/v2/api")
	public String getV2ApiInfo() {
		return apiVersion;
	}
	
//	@GetMapping("/todos")
//	public List<Todo> getTodos() {
//		return service.getAllTodos();
//	}
	
	@PostMapping("/todos")
	public Todo createTodo(Todo toCreate) {
		return service.createTodo(toCreate);
	}
	
	@GetMapping("/todos/{id}")
	public Todo getTodoById(@PathVariable Long id) {
		return service.getTodoById(id);
	}
	
	@GetMapping("/todos")
	public Todo getTodoByTask(@RequestParam String task) {
		return service.getTodoByTask(task);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
