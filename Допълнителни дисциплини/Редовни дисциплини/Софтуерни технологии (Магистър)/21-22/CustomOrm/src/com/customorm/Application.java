package com.customorm;

import com.customorm.database.DatabaseMigration;
import com.customorm.tools.CustomEntityScanner;

public class Application {
	
	public static void main(String[] args) {
		DatabaseMigration.migrate();
	}
}
