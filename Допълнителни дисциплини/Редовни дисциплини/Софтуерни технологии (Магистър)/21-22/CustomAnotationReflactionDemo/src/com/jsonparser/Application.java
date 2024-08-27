package com.jsonparser;
import java.lang.reflect.Field;
import java.util.HashMap;

import com.jsonparser.model.User;
import com.jsonparser.parser.JsonParser;

public class Application {
	
	public static void main(String[] args) {
	
		User user 			= new User();
		user.firstName 			= "Mihail";
		user.lastName 			= "Petrov";
		user.age 			= 30;
		user.mail 			= "mail@mail.bg";
		user.setId(1);
		
		String jsonString 	= JsonParser.parse(user);
		System.out.print(jsonString);
	}
}
