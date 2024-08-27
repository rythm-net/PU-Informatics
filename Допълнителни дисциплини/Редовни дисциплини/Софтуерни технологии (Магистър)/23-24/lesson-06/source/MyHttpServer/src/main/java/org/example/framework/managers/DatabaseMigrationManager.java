package org.example.framework.managers;

import org.example.framework.DependencyInjectionContainer;
import org.example.framework.database.ColumnTypeEnum;
import org.example.framework.database.Database;

import java.util.HashMap;

public class DatabaseMigrationManager {

    public static void run() {

        // 1. Вземи всички CucstomEntity класове
        var appEntityCollection = DependencyInjectionContainer.getAllEntity();
        Database db = new Database();


        // 2. Вземи им полетата
        for(var entity : appEntityCollection) {

            String entityName = entity.classReference.getSimpleName().toLowerCase();
            var fieldCollection = entity.classReference.getDeclaredFields();
            HashMap<String, ColumnTypeEnum> tableColumn = new HashMap<>();
            for(var field : fieldCollection) {
                String fieldName    = field.getName();
                String typeName     = field.getGenericType().getTypeName();
                tableColumn.put(fieldName, transformTypeToEnum(typeName));
            }

            db.table(entityName)
                    .withColumn(tableColumn)
                    .create();
        }


        System.out.println("Database migration finished successfuly");


        // 3. Направи, таблици базирани на полетата
        // 4. Изпълни заявката в базата данни
    }

    private static ColumnTypeEnum transformTypeToEnum(String typeName) {

        if(typeName.equals("java.lang.String")) {
            return ColumnTypeEnum.TEXT;
        }

        if(typeName.equals("int")) {
            return ColumnTypeEnum.NUMBER;
        }

        return ColumnTypeEnum.TEXT;
    }
}
