package org.fmiplovdiv.weblanguages.todo.dto;

public class TeamMemberRequest {
	
	private String name;

	public TeamMemberRequest(String name) {
		super();
		this.name = name;
	}

	public TeamMemberRequest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
