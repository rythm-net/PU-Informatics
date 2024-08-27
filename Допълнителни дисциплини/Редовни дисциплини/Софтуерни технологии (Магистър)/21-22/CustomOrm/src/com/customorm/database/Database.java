package com.customorm.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Database {
	
	private Connection dbConnection;
	private static Database dbInstance;
	
	private QueryBuilderType queryBuilderType;
	
	// 
	private String query; 
	private ArrayList<String> updateSetQuery = new ArrayList();
	private ArrayList<String> whereQuery 	 = new ArrayList();
	
	private Database() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbConnection 		= "jdbc:mysql://localhost:3306/uni_pu_master_qb";
			Properties dbCredentials 	= new Properties();
			dbCredentials.put("user"	, "root");
			dbCredentials.put("password", "");
			
			this.dbConnection = (Connection) DriverManager.getConnection(
				dbConnection, dbCredentials
			);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Database getInstance() {
		
		if(dbInstance == null) {
			dbInstance = new Database();
		}
		
		return dbInstance;
	}
		
	// v3
	public Database insert(String table) {
		
		this.queryBuilderType 	= QueryBuilderType.INSERT;
		this.query 				= "INSERT INTO " + table + " ";
		return this;
	}
	
	public Database into(String ...intoCollection) {
		
		String intoQueryBuilder = "";
		for(String column : intoCollection) {
			intoQueryBuilder += (column + ","); 
		}
		String columSet  =  intoQueryBuilder.substring(0, intoQueryBuilder.length() - 1);
		this.query 		+= " (" + columSet  + ") ";
		
		return this;
	}
	
	public Database values(Object ...valueCollection) {
	
		String valueQueryBuilder = "";
		for(Object value: valueCollection) {
			valueQueryBuilder += ( this.transformFromJavaValueToDatabaseValue(value) + ",");
		}
		
		String valueSet = valueQueryBuilder.substring(0, valueQueryBuilder.length() - 1);
		this.query += " VALUES(" + valueSet + ") ";
		
		return this;
	}
			
	public Database update(String table) {

		this.queryBuilderType 	= QueryBuilderType.UPDATE;
		this.query = "UPDATE " + table + " SET ";
		return this;
	}
	
	public Database set(String column, Object value) {
		
		String dbValue = this.transformFromJavaValueToDatabaseValue(value);
		this.updateSetQuery.add(column + " = " + dbValue);
		
		return this;
	}
		
	public Database where(String key, Object value) {
		return this.buildWhereOperation("WHERE", key, "=", value);
	}
	
	public Database where(String key, String operator,  Object value) {
		return this.buildWhereOperation("WHERE", key, operator, value);
	}
	
	public Database orWhere(String key, Object value) {
		return this.buildWhereOperation("OR", key, "=", value);
	}
	
	public Database orWhere(String key, String operator, Object value) {
		return this.buildWhereOperation("OR", key, operator, value);
	}
	
	public Database andWhere(String key, Object value) {
		return this.buildWhereOperation("OR", key, "=", value);
	}
	
	public Database andWhere(String key, String operator, Object value) {
		return this.buildWhereOperation("OR", key, operator, value);
	}
	
	public Database delete(String table) {

		this.queryBuilderType 	= QueryBuilderType.DELETE;
		this.query 				= "DELETE FROM " + table;
		return this;
	}

	public Database select(String table) {

		this.queryBuilderType = QueryBuilderType.SELECT;
		this.query = "SELECT * FROM " + table + " ";
		
		return this;
	}	
	
	public Database select(String table, String ...column) {

		this.queryBuilderType = QueryBuilderType.SELECT;
		this.query = "SELECT " + String.join(",", column) + " FROM " + table + " ";
		
		return this;
	}
	
	
	public Database createTable(String table, HashMap<String, String> columns) {
		
		this.queryBuilderType = QueryBuilderType.CREATE;
		StringBuilder builder = new StringBuilder();
		builder.append("CREATE TABLE " + table + " ( ");
		
		Set<String> columnKeyCollection =   columns.keySet();
		for(String columnKey : columnKeyCollection ) {
			String value = columns.get(columnKey);
			builder.append(columnKey + " " + value + ","); 
		}
		
		builder.deleteCharAt(builder.length() - 1);
		builder.append(");");
		
		this.query = builder.toString();
		return this;
	}
	
	public void exec() {

		this.query = this.queryProcessor();
		
		System.out.println("***");
		System.out.println(this.query);
		System.out.println("***");
		
		this.executeQuery(this.query);
		this.query = null;
	}	
	
	public ResultSet fetch() {
		
		this.query = this.queryProcessor();
		return this.fetchQuery(this.query);
	}
		
	private void executeQuery(String query) {
		
		try {
			Statement queryStatment = (Statement) this.dbConnection.createStatement();
			queryStatment.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ResultSet fetchQuery(String query) {
		
		Statement queryStatment;
		try {
			queryStatment = (Statement) this.dbConnection.createStatement();
			return queryStatment.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String queryProcessor() {
		
		if(this.queryBuilderType == QueryBuilderType.INSERT) {
			return this.query;	
		}
		
		if(this.queryBuilderType == QueryBuilderType.CREATE) {
			return this.query;	
		}
		
		String whereQuery 	= String.join(" ", this.whereQuery);
		this.whereQuery		= new ArrayList();
		
		if(this.queryBuilderType == QueryBuilderType.UPDATE) {
			
			String setQuery 	= String.join(",", this.updateSetQuery);
			this.updateSetQuery = new ArrayList();
			this.query 			+= setQuery;
			this.query 			+= whereQuery;
			return this.query;
		}
		
		if(this.queryBuilderType == QueryBuilderType.DELETE) {

			this.query 			+= whereQuery;
			return this.query;			
		}
		
		if(this.queryBuilderType == QueryBuilderType.SELECT) {

			this.query 			+= whereQuery;
			return this.query;
		}
		
		return null;
	}	
	
	private Database buildWhereOperation(
			String sqlOperator,  
			String key, 
			String operator,  
			Object value) {
		
		String dbValue = this.transformFromJavaValueToDatabaseValue(value);
		String resultQuery =  " " + sqlOperator + " " + key + " " + operator + " " + dbValue + " ";
		this.whereQuery.add(resultQuery);
		return this;
	}	

	private boolean isProcessable(Object javaValue) {
		
		if(javaValue instanceof Number) {
			return true;
		}
		
		if(javaValue instanceof String) {
			return true;
		}
		
		return false;
	}
	
	private String transformFromJavaValueToDatabaseValue(Object javaValue) {
		
		if(!this.isProcessable(javaValue)) {
			throw new RuntimeException("No sutable java Value type");
		}

		if(javaValue instanceof Number) {
			return javaValue.toString();
		}
		
		if(javaValue instanceof String) {
			return "'" + javaValue + "'"; 
		}
		
		return javaValue.toString();
	}
}
