package org.fmiplovdiv.weblanguages.todo.dto;

public class SignInRequest {
	private String username;
	private String password;

	public SignInRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public SignInRequest() {
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
