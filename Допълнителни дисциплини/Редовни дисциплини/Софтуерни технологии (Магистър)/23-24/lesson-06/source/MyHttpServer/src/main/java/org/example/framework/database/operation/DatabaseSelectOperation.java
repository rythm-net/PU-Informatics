package org.example.framework.database.operation;

import java.sql.Connection;
import java.sql.ResultSet;

public class DatabaseSelectOperation extends DatabaseOperation {

    private String[] selectedColumns = null;

    public DatabaseSelectOperation(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public DatabaseSelectOperation select(String... columNameCollection) {

        this.selectedColumns = columNameCollection;
        return this;
    }

    public ResultSet fetch() {

        String columnDefinition = (this.selectedColumns == null)
                ? "*"
                : String.join(",", this.selectedColumns);
        String query = "SELECT " + columnDefinition + " FROM " + this.tableName;

        return this.executeQuery(query);
    }

}
