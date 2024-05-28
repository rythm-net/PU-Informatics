package org.fmiplovdiv.weblanguages.todo.dto;

public class TodoRequest {

	private Long id;
	private String task;
	private String description;
	private Long teamMember;

	public TodoRequest(Long id, String task, String description, Long teamMember) {
		super();
		this.id = id;
		this.task = task;
		this.description = description;
		this.teamMember = teamMember;
	}

	public TodoRequest() {
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

	public Long getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(Long teamMember) {
		this.teamMember = teamMember;
	}

}
