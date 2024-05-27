package org.fmiplovdiv.weblanguages.todo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.fmiplovdiv.weblanguages.todo.dto.TeamMemberRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TodoRepository;
import org.fmiplovdiv.weblanguages.todo.dto.TodoRequest;
import org.fmiplovdiv.weblanguages.todo.dto.TodoResponse;
import org.fmiplovdiv.weblanguages.todo.model.TeamMember;
import org.fmiplovdiv.weblanguages.todo.model.Todo;
import org.fmiplovdiv.weblanguages.todo.model.TodoStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTests {
	
	@Mock
	TodoRepository todoRepository;
	
	@Mock
	TeamMemberRepository teamMemberRepository;
	
	@InjectMocks
	TodoService todoService;
	
	@Captor
	ArgumentCaptor<Todo> todoCaptor;

	@Test
	void createTodoTeamMemberDoesNotExistTest() {
		TodoRequest request = new TodoRequest(null, "test task", "test description", 1L);
		
		// test when teammember does not exist
		when(teamMemberRepository.existsById(1L)).thenReturn(false);
		TodoResponse response = todoService.createTodo(request);
		assertThat(response).isNull();
	}

	@Test
	void createTodoTaskDescriptionNullTest() {
		TodoRequest request = new TodoRequest(null, null, "test description", 1L);

		when(teamMemberRepository.existsById(anyLong())).thenReturn(true);
		// test task null
		TodoResponse response = todoService.createTodo(request);
		assertThat(response).isNull();

		// test description
		request.setTask("test task");
		request.setDescription(null);
		response = todoService.createTodo(request);
		assertThat(response).isNull();
	
	}
	
	@Test
	void createTodoTest() {
		TodoRequest request = new TodoRequest(null, "test task", "test description", 1L);

		when(teamMemberRepository.existsById(anyLong())).thenReturn(true);
		when(todoRepository.countByTeamMemberAndTodoStatus(any(), eq(TodoStatus.IN_PROGRESS))).thenReturn(1);
		TeamMember teamMember = new TeamMember();
		teamMember.setId(1L);
		teamMember.setName("Maria");
		when(teamMemberRepository.findById(1L)).thenReturn(Optional.of(teamMember));
		
		Todo savedTodo = new Todo();
		savedTodo.setId(1L);
		savedTodo.setTask(request.getTask());
		savedTodo.setDescription(request.getDescription());
		savedTodo.setTeamMember(teamMember);
		savedTodo.setTodoStatus(TodoStatus.NOT_STARTED);
		
		when(todoRepository.save(any())).thenReturn(savedTodo);

		TodoResponse response = todoService.createTodo(request);
		
		verify(todoRepository, times(1)).save(any());
		assertThat(response.getTask()).isEqualTo("test task");
		
		verify(todoRepository).save(todoCaptor.capture());
		Todo capturedTodo = todoCaptor.getValue();

		Todo expectedTodo = new Todo();
		expectedTodo.setId(null);
		expectedTodo.setTask(request.getTask());
		expectedTodo.setDescription(request.getDescription());
		expectedTodo.setTeamMember(teamMember);
		expectedTodo.setTodoStatus(TodoStatus.NOT_STARTED);
		
		assertThat(capturedTodo).usingRecursiveComparison().isEqualTo(expectedTodo);
	}
}
