package org.example.framework.database.operation;

import org.example.framework.database.ColumnTypeEnum;

import java.sql.Connection;
import java.util.HashMap;

public class DatabaseCreateTableOperation extends DatabaseOperation {

    private HashMap<String, String> columnBuilder = new HashMap<>();

    public DatabaseCreateTableOperation(
            Connection dbConnection,
            String tableName
    ) {
        super(dbConnection, tableName);
    }

    public DatabaseCreateTableOperation withColumn(HashMap<String, ColumnTypeEnum> colDefinitions) {
        for(var record : colDefinitions.entrySet()) {
            withColumn(record.getKey(), record.getValue());
        }

        return this;
    }


    public DatabaseCreateTableOperation withColumn(
            String columnName,
            ColumnTypeEnum columnType
    ) {

        if(columnType == ColumnTypeEnum.NUMBER) {
            this.columnBuilder.put(columnName, "INT");
        }

        if(columnType == ColumnTypeEnum.TEXT) {
            this.columnBuilder.put(columnName, "VARCHAR(16)");
        }

        return this;
    }


    public DatabaseCreateTableOperation withColumn(
            String columnName,
            ColumnTypeEnum columnType,
            int columnSize
    ) {

        if(columnType == ColumnTypeEnum.NUMBER) {
            this.columnBuilder.put(columnName, "INT(" + columnSize + ")");
        }

        if(columnType == ColumnTypeEnum.TEXT) {
            this.columnBuilder.put(columnName, "VARCHAR(" + columnSize + ")");
        }

        return this;
    }

    public void create() {

        // CREATE TABLE users(
        //  id INT,
        //  name VARCHAR(256)
        // )
        String resultQuery = "CREATE TABLE " + this.tableName + "(";
        for(var element : this.columnBuilder.entrySet()) {
            resultQuery += element.getKey() + " " + element.getValue() + ",";
        }

        resultQuery = resultQuery.substring(0, resultQuery.length() - 1);
        resultQuery += ")";

        this.execute(resultQuery);
    }
}
