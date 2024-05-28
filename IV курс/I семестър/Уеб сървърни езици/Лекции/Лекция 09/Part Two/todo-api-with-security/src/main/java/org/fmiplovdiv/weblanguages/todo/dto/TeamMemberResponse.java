package org.fmiplovdiv.weblanguages.todo.dto;

public class TeamMemberResponse {

	private Long id;
	private String name;

	public TeamMemberResponse(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public TeamMemberResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
