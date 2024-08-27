package com.jsonparser.parser;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;

import com.jsonparser.anotation.JsonField;

public class JsonParser {
	
	public static String parse(Object parsableObject) {
		
		try {
			Class userBlueprint 		= parsableObject.getClass();
			Class jsonFieldAnotation 	= Class.forName("com.jsonparser.anotation.JsonField");
			
			// All fields
			Field[] fieldCollection =  userBlueprint.getDeclaredFields();
			
			HashMap<String, String> jsonPlaceholder = new HashMap<String, String>();
			
			for(Field fieldReference : fieldCollection ) {
				
				// is annotation available
				if(fieldReference.isAnnotationPresent(jsonFieldAnotation)) {

					JsonField jsonFieldAnotationRef = (JsonField) fieldReference.getDeclaredAnnotation(jsonFieldAnotation);
					String jsonFieldValue 			= jsonFieldAnotationRef.value();
					String fieldName 				= jsonFieldValue.equals("") 
														? fieldReference.getName()
														: jsonFieldValue;
					
					// > unlock private fields
					fieldReference.setAccessible(true);
					
					// > process field information
					if(fieldReference.canAccess(parsableObject)) {
						jsonPlaceholder.put(fieldName, 
								fieldReference.get(parsableObject).toString()
						);					
					}					
				}
			}
			
			return buildJsonOutput(jsonPlaceholder);
			
		} catch (IllegalArgumentException 	| 
			 	 IllegalAccessException 	| 
			 	 ClassNotFoundException e	) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{}";
		}
	}
	
	private static String buildJsonOutput(HashMap<String, String> jsonPlaceholder) {
		
		Set<String> keyCollection = jsonPlaceholder.keySet();
		StringBuilder jsonBuilder = new StringBuilder();
		
		// { "key" : "value"}
		jsonBuilder.append("{");
		for(String keyElement : keyCollection) {
			String value = jsonPlaceholder.get(keyElement);
			jsonBuilder.append("\"" + keyElement + " \" : " + " \" " + value + "\" ,");
		}
		
		jsonBuilder.append("}");
		return jsonBuilder.toString();
	}
}
