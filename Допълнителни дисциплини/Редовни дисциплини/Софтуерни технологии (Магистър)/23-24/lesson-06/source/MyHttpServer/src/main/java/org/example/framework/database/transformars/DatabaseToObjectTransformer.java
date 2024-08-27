package org.example.framework.database.transformars;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseToObjectTransformer {

    public static <T> ArrayList<T> transform(
            Class objectType,
            ResultSet collection
    ) {

        ArrayList<T> resultCollection = new ArrayList<>();
        Field[] fieldCollection =  objectType.getDeclaredFields();

        try {

            while(collection.next()) {
                // ще правя трансформации на обекти

                var instanceClass = objectType.getDeclaredConstructor().newInstance();

                for(var fieldElement : fieldCollection) {

                    String fieldName    = fieldElement.getName();
                    Type fieldType      = fieldElement.getGenericType();

                    if(fieldType.getTypeName().equals("java.lang.String")) {

                        String result = collection.getString(fieldName);
                        fieldElement.set(instanceClass, result);
                    }

                    if(fieldType.getTypeName().equals("int")) {

                        int result = collection.getInt(fieldName);
                        fieldElement.set(instanceClass, result);
                    }
                }

                resultCollection.add((T) instanceClass);
            }

            return resultCollection;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
