package org.ormfmi.operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperation {

    protected String tableName;
    protected Connection dbConnection;

    public DatabaseOperation(Connection dbConnection, String tableName) {

        this.dbConnection = dbConnection;
        this.tableName = tableName;
    }

    protected void execute(String query) {

        try {
            Statement executor =  this.dbConnection.createStatement();
            executor.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void executeUpdate(String query) {

        try {
            Statement executor = this.dbConnection.createStatement();
            executor.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected ResultSet executeQuery(String query) {

        Statement execution = null;
        try {
            execution = this.dbConnection.createStatement();
            return execution.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
