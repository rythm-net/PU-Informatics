package com.customorm.entities;

import com.customorm.enums.DatabaseType;
import com.customorm.labels.CustomEntity;
import com.customorm.labels.CustomEntityColumn;

@CustomEntity
public class Product {

	@CustomEntityColumn(type = DatabaseType.INT)
	private int id;
	
	@CustomEntityColumn(type = DatabaseType.VARCHAR)
	private String title;
}
