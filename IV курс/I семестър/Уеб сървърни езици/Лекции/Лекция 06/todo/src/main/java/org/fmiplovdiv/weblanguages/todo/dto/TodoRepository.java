package org.fmiplovdiv.weblanguages.todo.dto;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findAll();
}
