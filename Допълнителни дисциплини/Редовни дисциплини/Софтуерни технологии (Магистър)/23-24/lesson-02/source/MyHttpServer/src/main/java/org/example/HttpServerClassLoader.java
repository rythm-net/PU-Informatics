package org.example;

import org.example.tags.HttpController;
import org.example.tags.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class HttpServerClassLoader {

    public static void bootstrapApplication() throws IOException, ClassNotFoundException {

        // Сканиране на директория - съдържаща контролери
        ClassLoader appLoader                 = ClassLoader.getSystemClassLoader();
        InputStream appLoaderStream           =  appLoader.getResourceAsStream("org/example/app");
        BufferedReader appLoaderStreamReader  = new BufferedReader(new InputStreamReader(appLoaderStream));

        // Зареждане на фактическия клас
        String line = "";
        while((line = appLoaderStreamReader.readLine()) != null) {

            String classPath    = "org.example.app." + line.replace(".class", "");
            Class classInstance =  Class.forName(classPath);

            // Работим само с класове, които са анотирани като Controller - и
            boolean isClassController = classInstance.isAnnotationPresent(
                    HttpController.class
            );

            if(!isClassController) continue;

            Method[] instanceMethodCollection = classInstance.getMethods();

            for(Method instanceMethod : instanceMethodCollection) {

                int modificatorCode     =  instanceMethod.getModifiers();
                boolean isPublic        = Modifier.isPublic(modificatorCode);
                boolean hasAnnotation   = instanceMethod.isAnnotationPresent(
                        org.example.tags.HttpMethod.class
                );
                boolean isMethodProcessable = isPublic && hasAnnotation;

                if(!isMethodProcessable) continue;

                HttpMethod httpMethodAnnotation = instanceMethod.getAnnotation(
                        org.example.tags.HttpMethod.class
                );

                String httpMethod   = httpMethodAnnotation.method();
                String httpPath     = httpMethodAnnotation.path();
                HttpTable.addRequest(httpMethod, httpPath, classInstance, instanceMethod);
            }
        }
    }
}
