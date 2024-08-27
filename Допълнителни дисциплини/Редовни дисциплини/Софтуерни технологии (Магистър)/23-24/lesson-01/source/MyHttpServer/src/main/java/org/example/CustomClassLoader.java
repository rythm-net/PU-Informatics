package org.example;

import org.example.application.Method;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class CustomClassLoader {

    private class ClassMethodReference {
        public Class classReference;
        public java.lang.reflect.Method methodReference;
    }

    private HashMap<String, HashMap<String, ClassMethodReference>> dic = new HashMap<>();

    public Set<Class> findAllClasses(String packageName) {

        ClassLoader loader = ClassLoader.getSystemClassLoader();
        HashSet<Class> collection = new HashSet<>();

        try(
            InputStream stream = loader.getResourceAsStream("org/example/application")
        ) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(stream)));

            String s = "";
            while((s = reader.readLine()) != null) {

                System.out.println("start");

                var className       = s.replace(".class", "");
                var classPath       = "org.example.application." + className;
                var classInstance   = Class.forName(classPath);

                boolean isControllerClass = classInstance.isAnnotationPresent(
                    org.example.application.Controller.class
                );

                if(isControllerClass) {

                    var methodCollection = classInstance.getMethods();

                    for(var methodElement : methodCollection) {
                        var modifier = methodElement.getModifiers();

                        boolean isMethodAnnotated = methodElement.isAnnotationPresent(
                            org.example.application.Method.class
                        );

                        boolean isMethodPublic = Modifier.isPublic(modifier);

                        boolean isMethodProcessable = isMethodAnnotated && isMethodPublic;


                        Method methodAnnotation =  methodElement.getAnnotation(
                            org.example.application.Method.class
                        );

                        String method   = methodAnnotation.action();
                        String path     = methodAnnotation.path();

                        HttpTable.addRecord(path, method, classInstance, methodElement);
                    }
                }

                collection.add(classInstance);
            }
        }
        catch (Exception e ) {
            return null;
        }

        return collection;
    }


}
