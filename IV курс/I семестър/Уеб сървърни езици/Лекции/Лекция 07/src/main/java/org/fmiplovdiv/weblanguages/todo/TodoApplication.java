package org.fmiplovdiv.weblanguages.todo;

import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.misc.Application;
import org.fmiplovdiv.weblanguages.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {
	
	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

//	@Bean
//	public TodoService todoService() {
//		return new TodoService(todoRepository);
//	}
	
	@Bean
	@ConfigurationProperties(prefix = "todo.application")
	public Application application() {
		return new Application();
	}
}
