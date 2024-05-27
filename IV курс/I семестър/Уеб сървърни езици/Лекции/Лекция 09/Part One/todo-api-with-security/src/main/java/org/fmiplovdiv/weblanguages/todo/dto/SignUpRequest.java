package org.fmiplovdiv.weblanguages.todo.dto;

public class SignUpRequest {
	private String username;
	private String password;

	public SignUpRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public SignUpRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
