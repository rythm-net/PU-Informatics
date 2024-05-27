package org.fmiplovdiv.weblanguages.todo.dto;

public class TodoResponse {

	private Long id;
	private String task;
	private String description;
	private Integer todoStatus;
	private Long teamMember;

	public TodoResponse(Long id, String task, String description, Integer todoStatus, Long teamMember) {
		super();
		this.id = id;
		this.task = task;
		this.description = description;
		this.todoStatus = todoStatus;
		this.teamMember = teamMember;
	}

	public TodoResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(Integer todoStatus) {
		this.todoStatus = todoStatus;
	}

	public Long getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(Long teamMember) {
		this.teamMember = teamMember;
	}

}
