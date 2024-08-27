package com.customorm.database;

import java.util.ArrayList;
import java.util.HashMap;

import com.customorm.enums.DatabaseType;
import com.customorm.labels.CustomEntity;
import com.customorm.labels.CustomEntityColumn;
import com.customorm.tools.CustomEntityScanner;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class DatabaseMigration {

	public static void migrate() {
	
		ArrayList<Class> entityCollection =  CustomEntityScanner.scannPackage("com.customorm.entities");
		
		for(Class entityElement : entityCollection) {
			
			String tableName =  entityElement.getSimpleName();
			
			if(entityElement.isAnnotationPresent(CustomEntity.class)) {
				var tableMap = createTable(entityElement);
				Database.getInstance()
					.createTable(tableName, tableMap)
					.exec();
			}
		}
		
		System.out.println("Success migration");
	}
	
	private static HashMap<String, String> createTable(Class entity) {
		
		
		// get all field names
		Field[] entityFieldCollection =  entity.getDeclaredFields();
		
		
		HashMap<String, String> tableMap = new HashMap();
		
		for(Field entitiField : entityFieldCollection) {
			
			if(entitiField.isAnnotationPresent(CustomEntityColumn.class)) {
				
				CustomEntityColumn customEntityColumn = entitiField.getDeclaredAnnotation(CustomEntityColumn.class);
				
				String columnName = customEntityColumn.colum();
				
				String entityTitle 	= columnName.equals("") 
										? entitiField.getName() 
										: columnName;
				
				
				String entityType = getDatabaseType(customEntityColumn.type());
				tableMap.put(entityTitle, entityType);
			}
		}
		
		return tableMap;
	}
	
	private static String getDatabaseType(DatabaseType type) {
		
		if(type == DatabaseType.INT) {
			return "INT";
		}
		
		if(type == DatabaseType.VARCHAR) {
			return "VARCHAR(256)";
		}
		
		return " ";
	}
	
}
