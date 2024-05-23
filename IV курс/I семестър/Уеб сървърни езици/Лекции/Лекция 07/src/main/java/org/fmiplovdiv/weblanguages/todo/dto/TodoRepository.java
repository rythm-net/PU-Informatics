package org.fmiplovdiv.weblanguages.todo.dto;

import java.util.List;
import java.util.Optional;

import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findAll();
	Todo findByTask(String task);
}
