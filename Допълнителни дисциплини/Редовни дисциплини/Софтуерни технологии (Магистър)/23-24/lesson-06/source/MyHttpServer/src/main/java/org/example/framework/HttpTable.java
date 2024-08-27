package org.example.framework;

import org.example.framework.container.ClassMethodComposition;
import org.example.framework.server.contracts.HttpRequestObject;
import org.example.framework.server.contracts.HttpResponseObject;
import org.example.framework.server.contracts.HttpStatusCodeEnum;
import org.example.framework.server.parsers.MethodReturnTypeParser;
import org.example.framework.tags.HttpParameterHash;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class HttpTable {

    public static String processRequest(
            HttpRequestObject request) {

        String tableKey                         = getRequestKey(request);
        ClassMethodComposition classComposition = DependencyInjectionContainer.getComponent(tableKey);

        HttpResponseObject httpResponse = new HttpResponseObject();

        if(classComposition == null) {

            httpResponse.setStatusCode(HttpStatusCodeEnum.NOT_FOUND);
            httpResponse.setStatusMessage("Error");
            httpResponse.setResponseBody("<h1>Page Not found</h1>");
            return httpResponse.getHttpMessage();
        }

        var resultObject        = executeControllerMethod(classComposition, request, httpResponse);
        String httpStringResult = MethodReturnTypeParser.parse(resultObject, request, httpResponse);

        httpResponse.setStatusCode(HttpStatusCodeEnum.OK);
        httpResponse.setStatusMessage("Success");
        httpResponse.setResponseBody(httpStringResult);
        return httpResponse.getHttpMessage();
    }

    private static Object executeControllerMethod(
            ClassMethodComposition classComposition,
            HttpRequestObject request,
            HttpResponseObject response
    ) {

        if(DependencyInjectionContainer.isParameterAnnotationPresent(classComposition, HttpParameterHash.class)) {
            return DependencyInjectionContainer.invoke(classComposition, request.getHttpQueryParameterHash());
        }

        return DependencyInjectionContainer.invoke(classComposition);
    }

    private static String getRequestKey(HttpRequestObject request) {
        return  request.getHttpMethod() + ":" + request.getHttpPath();
    }
}
