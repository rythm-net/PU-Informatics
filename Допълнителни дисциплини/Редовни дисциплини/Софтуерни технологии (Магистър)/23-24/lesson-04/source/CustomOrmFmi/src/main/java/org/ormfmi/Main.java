package org.ormfmi;

import org.ormfmi.entity.User;
import org.ormfmi.transformars.DatabaseToObjectTransformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Database db = new Database();

        // 1. Създаване на таблици в базата данни
        // ***
        // db.createTable("users", new HashMap<String, String>{{
        //  put("id", "int");
        //  put("name", "varchar(256)");
        // }})

        // DSL
//         db.table("users")
//           .withColumn("id", ColumnTypeEnum.NUMBER)
//           .withColumn("name", ColumnTypeEnum.TEXT, 256)
//           .create();

        // 2. Въвеждане на данни
//        db.into("users")
//            .values("id", 1)
//            .values("name", "Mihail")
//            .insert();

        db.into("users")
            .values("id", 2)
            .values("name", "Pencho")
            .insert();

        // 3. Актуализация на данни
        // 4. Изтриване на данни
        // 5. Селектиране на данни

        // SELECT *
        // FROM users

        ResultSet collection =  db.from("users").fetch();
        ArrayList<User> userCollection =  DatabaseToObjectTransformer.transform(User.class, collection);

        for(var userElement : userCollection) {
            System.out.println(userElement);
        }

//        try {
//            while(collection.next()) {
//                System.out.println(collection.getInt("id"));
//                System.out.println(collection.getString("name"));
//            }
//        }
//        catch (SQLException e) {
//            e.getStackTrace();
//        }



        // 6. Селектиране и конвертиране към обектна колекция

    }
}