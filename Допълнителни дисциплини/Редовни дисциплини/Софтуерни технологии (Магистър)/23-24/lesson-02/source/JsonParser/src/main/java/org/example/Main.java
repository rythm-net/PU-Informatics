package org.example;

import java.io.File;
import java.lang.reflect.Field;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static String parseJson(Object referenceObject) throws IllegalAccessException {

        Class classInstance = referenceObject.getClass();

        Field[] filedCollection =  classInstance.getDeclaredFields();

        String resultJSON = "{";

        for(Field memberField : filedCollection) {

            if(memberField.isAnnotationPresent(org.example.JSONField.class)) {

                var resultValue =  memberField.get(referenceObject);

                JSONField annotation =  memberField.getDeclaredAnnotation(org.example.JSONField.class);

                String jsonKey = annotation.name().equals("_")
                                    ? memberField.getName()
                                    :  annotation.name();

                resultJSON += "\"" + jsonKey + "\"" + ":" + "\"" +
                        resultValue + "\"" + ",";
            }
        }

        resultJSON = resultJSON.substring(0, resultJSON.length() - 1);
        resultJSON += "}";

        return resultJSON;
    }

    public static void main(String[] args) throws IllegalAccessException {

        User sampleUser = new User();
        sampleUser.fname = "Mihail";
        sampleUser.lname = "Petrov";
        sampleUser.age   = 31;
        sampleUser.personalNumber = 123456;

        String resultJSON = parseJson(sampleUser);
        System.out.println(resultJSON);
    }
}