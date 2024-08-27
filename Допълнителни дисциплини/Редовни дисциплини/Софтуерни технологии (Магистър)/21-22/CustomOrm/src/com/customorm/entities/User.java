package com.customorm.entities;

import com.customorm.enums.DatabaseType;
import com.customorm.labels.CustomEntity;
import com.customorm.labels.CustomEntityColumn;

@CustomEntity()
public class User {

	@CustomEntityColumn(type = DatabaseType.INT)
	private int id;
	
	@CustomEntityColumn(type = DatabaseType.VARCHAR)
	private String username;
	
	@CustomEntityColumn(type = DatabaseType.VARCHAR)
	private String password;
	
	@CustomEntityColumn(type = DatabaseType.VARCHAR)
	private String email;
}
