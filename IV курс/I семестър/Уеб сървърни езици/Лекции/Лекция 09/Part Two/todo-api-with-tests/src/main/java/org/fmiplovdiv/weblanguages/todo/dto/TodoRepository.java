package org.fmiplovdiv.weblanguages.todo.dto;

import java.util.List;

import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.model.TodoStatus;

public interface TodoRepository extends BaseRepository<Todo, Long> {
	
	Integer countByTeamMemberAndTodoStatus(TeamMember id, TodoStatus todoStatus);
	List<Todo> findAllByTeamMemberAndTodoStatus(TeamMember id, TodoStatus todoStatus);
	
}
