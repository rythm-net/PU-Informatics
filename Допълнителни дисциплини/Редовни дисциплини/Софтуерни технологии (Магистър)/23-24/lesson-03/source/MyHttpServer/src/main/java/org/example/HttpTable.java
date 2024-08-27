package org.example;

import org.example.server.contracts.HttpRequestObject;
import org.example.server.types.ControllerView;
import org.example.tags.HttpParameterHash;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class HttpTable {

    private final static String CRLF = "\n\r";

    private static class ClassMethodComposition {
        public Class classReference;
        public Method methodReference;

        public ClassMethodComposition(Class classReference, Method methodReference) {
            this.classReference = classReference;
            this.methodReference = methodReference;
        }
    }

    private static HashMap<String, ClassMethodComposition> httpTable = new HashMap<>();

    private static HashMap<String, Object> serviceTable = new HashMap<>();

    public static String buildHttpResponse(
            String httpResponseBody,
            String statusCode,
            String statusMessage
    ) {
        return "HTTP/1.1 " + statusCode + " " + statusMessage + CRLF +
                "Access-Control-Allow-Origin: *" + CRLF +
                "Content-Length: " + httpResponseBody.getBytes().length + CRLF +
                "Content-Type: text/html" + CRLF + CRLF +
                httpResponseBody        + CRLF + CRLF;
    }


    public static void addRequest(
            HttpRequestObject request,
            Class classReference,
            Method methodInstance) {

        String tableKey = getRequestKey(request);
        httpTable.put(tableKey, new ClassMethodComposition(classReference, methodInstance));
    }

    public static void addService(
            String serviceName,
            Object instance
    ) {
        serviceTable.put(serviceName, instance);
    }

    public static String processRequest(
            HttpRequestObject request) {

        String tableKey = getRequestKey(request);
        ClassMethodComposition classComposition = httpTable.get(tableKey);

        if(classComposition == null) {
            return buildHttpResponse("<h1>Page Not found</h1>", "400", "Error");
        }

        var resultObject        = executeControllerMethod(classComposition, request);
        String httpStringResult = parseMethodReturnType(resultObject);
        return buildHttpResponse(httpStringResult, "200", "Success");
    }

    private static Object executeControllerMethod(
            ClassMethodComposition classComposition,
            HttpRequestObject request
    ) {

        try {

            // Взимам конструкторите на контролера
            var constructorControllerCollection = classComposition.classReference.getConstructors();
            ArrayList<Object> serviceInstanceCollection = new ArrayList<>();

            for(Constructor element : constructorControllerCollection) {
                var constructorParameterTypeCollection = element.getGenericParameterTypes();

                for(Type parameterType : constructorParameterTypeCollection) {
                    String parameterName    = parameterType.getTypeName();
                    Object serviceInstance  = serviceTable.get(parameterName);
                    serviceInstanceCollection.add(serviceInstance);
                }
            }

            // ИНстанция на контролер
            var instance = classComposition.classReference.getDeclaredConstructor(
                    org.example.services.HealthCheckerService.class
            ).newInstance(
                    serviceInstanceCollection.toArray()
            );

            Annotation[][] parameterAnnotationCollection =
                    classComposition.methodReference.getParameterAnnotations();

            // Ако имаш една единствена анотация, която да кореспондира с параметъра
            if(parameterAnnotationCollection.length == 1) {
                if(parameterAnnotationCollection[0].length == 1) {
                    if(parameterAnnotationCollection[0][0] instanceof HttpParameterHash) {

                        return classComposition.methodReference.invoke(
                                instance,
                                request.getHttpQueryParameterHash()
                        );
                    }
                }
            }

            return classComposition.methodReference.invoke(instance);

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

    private static String parseMethodReturnType(Object methodReturnValue) {

        if(methodReturnValue instanceof String s) {
            return parseStringTemplate(s);
        }

        if(methodReturnValue instanceof ControllerView cv) {
            return parseControllerView(cv);
        }

        return (String) methodReturnValue;
    }

    private static String parseStringTemplate(String templateId) {

        Path templatePath =  Paths.get("src/main/java/org/example/templates/" + templateId + ".html");
        try {
            return  new String(Files.readAllBytes(templatePath));
        } catch (IOException e) {
            return templateId;
        }
    }

    private static String parseControllerView(ControllerView cv) {
        return parseStringTemplate(cv.getStringId());
    }

    private static String getRequestKey(HttpRequestObject request) {
        return request.getHttpPath() + "___" + request.getHttpMethod();
    }
}
