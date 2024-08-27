package org.example;

import org.example.server.contracts.HttpRequestObject;
import org.example.server.contracts.HttpResponseObject;
import org.example.server.contracts.HttpStatusCodeEnum;
import org.example.server.parsers.MethodReturnTypeParser;
import org.example.server.types.ControllerJsonResponse;
import org.example.server.types.ControllerView;
import org.example.services.MedicationService;
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

//    private final static String CRLF = "\r\n";

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

        String tableKey                         = getRequestKey(request);
        ClassMethodComposition classComposition = httpTable.get(tableKey);

        HttpResponseObject httpResponse = new HttpResponseObject();


        if(classComposition == null) {

            httpResponse.setStatusCode(HttpStatusCodeEnum.NOT_FOUND);
            httpResponse.setStatusMessage("Error");
            httpResponse.setResponseBody("<h1>Page Not found</h1>");
            return httpResponse.getHttpMessage();

            // return buildHttpResponse("<h1>Page Not found</h1>", "400", "Error");
        }

        var resultObject        = executeControllerMethod(classComposition, request, httpResponse);
        String httpStringResult = MethodReturnTypeParser.parse(resultObject, request, httpResponse);

        httpResponse.setStatusCode(HttpStatusCodeEnum.OK);
        httpResponse.setStatusMessage("Success");
        httpResponse.setResponseBody(httpStringResult);
        return httpResponse.getHttpMessage();

        // return buildHttpResponse(httpStringResult, "200", "Success");
    }

    private static Object executeControllerMethod(
            ClassMethodComposition classComposition,
            HttpRequestObject request,
            HttpResponseObject response
    ) {

        try {

            // Взимам конструкторите на контролера
            var constructorControllerCollection = classComposition.classReference.getConstructors();
            ArrayList<Object> serviceInstanceCollection = new ArrayList<>();
            Class[] serviceClassCollection = null;

            for(Constructor element : constructorControllerCollection) {
                var constructorParameterTypeCollection  = element.getGenericParameterTypes();
                serviceClassCollection                  = element.getParameterTypes();

                for(Type parameterType : constructorParameterTypeCollection) {

                    String parameterName    = parameterType.getTypeName();
                    Object serviceInstance  = serviceTable.get(parameterName);
                    serviceInstanceCollection.add(serviceInstance);
                }
            }

            // ИНстанция на контролер
            var instance = classComposition.classReference.getDeclaredConstructor(
                    serviceClassCollection
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

    private static String getRequestKey(HttpRequestObject request) {
        return request.getHttpPath() + "___" + request.getHttpMethod();
    }
}
