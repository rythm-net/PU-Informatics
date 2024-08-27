package org.example.framework.database;

import org.example.framework.database.operation.DatabaseCreateTableOperation;
import org.example.framework.database.operation.DatabaseInsertIntoOperation;
import org.example.framework.database.operation.DatabaseSelectOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Database {

    private Connection dbConnection = null;

    private String tableName;

    private HashMap<String, String> columnBuilder = new HashMap<>();
    private String query;
    // CREATE TABLE table_name()

    public Database() {

        String dbUrl = "jdbc:sqlite:C:\\db\\fmi_lesson_06";
        try {
            this.dbConnection = DriverManager.getConnection(dbUrl);

            System.out.println("Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DatabaseCreateTableOperation table(String tableName) {
        return new DatabaseCreateTableOperation(this.dbConnection, tableName);
    }

    public DatabaseInsertIntoOperation into(String tableName) {
        return new DatabaseInsertIntoOperation(this.dbConnection, tableName);
    }

    public DatabaseSelectOperation from(String tableName) {
        return new DatabaseSelectOperation(this.dbConnection, tableName);
    }
}
