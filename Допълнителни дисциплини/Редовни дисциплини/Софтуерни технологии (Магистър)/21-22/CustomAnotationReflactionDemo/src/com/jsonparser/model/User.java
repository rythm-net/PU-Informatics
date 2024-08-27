package com.jsonparser.model;

import com.jsonparser.anotation.JsonField;

public class User {
	
	@JsonField("_id")
	private int id;
	
	@JsonField("first_name")
	public String firstName; // first_name
	
	@JsonField()
	public String lastName; // last_name
	public int age;
	public String mail;
	
	public void setId(int id) {
		this.id = id;
	}
	
}
