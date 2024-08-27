package org.example.framework.database.operation;

import java.sql.Connection;
import java.util.HashMap;

public class DatabaseInsertIntoOperation extends DatabaseOperation {

    private HashMap<String, String> columnBuilder = new HashMap<>();

    public DatabaseInsertIntoOperation(
            Connection dbConnection,
            String tableName
    ) {
        super(dbConnection, tableName);
    }

    public DatabaseInsertIntoOperation values(String columnName, String value) {

        this.columnBuilder.put(columnName, "'" + value + "'");
        return this;
    }
    public DatabaseInsertIntoOperation values(String columnName, int value) {

        this.columnBuilder.put(columnName, String.valueOf(value));
        return this;
    }

    public void insert() {

        // INSERT INTO users
        // (id, name)
        // VALUES
        // (1, 'Mihail');

        String query = "INSERT INTO users";
        String keyBuilder = "";
        String valueBuilder = "";
        for(var element : this.columnBuilder.entrySet()) {

            keyBuilder += element.getKey() + ",";
            valueBuilder += element.getValue() + ",";
        }

        keyBuilder      = "(" + keyBuilder.substring(0, keyBuilder.length() - 1) + ")";
        valueBuilder    = "(" + valueBuilder.substring(0, valueBuilder.length() - 1) + ")";

        query += keyBuilder + "VALUES" + valueBuilder;

        this.executeUpdate(query);
    }
}
