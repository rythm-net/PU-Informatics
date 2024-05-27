package org.fmiplovdiv.weblanguages.todo.dto;

public class JwtAuthenticationResponse {
	private String token;

	public JwtAuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public JwtAuthenticationResponse() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
