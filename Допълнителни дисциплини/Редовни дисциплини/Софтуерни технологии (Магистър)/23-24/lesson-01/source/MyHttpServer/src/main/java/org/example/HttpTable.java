package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class HttpTable {

    private static class ClassMethodRelation {
        public Class classReference;
        public Method methodReference;

        public ClassMethodRelation(Class classReference, Method methodReference) {

            this.classReference  = classReference;
            this.methodReference = methodReference;
        }
    }

    private static HashMap<String, ClassMethodRelation> table = new HashMap<>();

    public static void addRecord(
        String path,
        String method,
        Class classReference,
        Method methodReference
    ) {
        table.put(path + "___" + method, new ClassMethodRelation(classReference, methodReference));
    }


    public static String processRequest(
        String path,
        String method) {


        ClassMethodRelation reference =  table.get(path + "___" + method);

        if(reference == null) {
            return "";
        }


        try {
            var instance = reference.classReference.getDeclaredConstructor().newInstance();
            return (String) reference.methodReference.invoke(instance);

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
