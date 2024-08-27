package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
            String method,
            String path,
            Class classReference,
            Method methodInstance) {

        String tableKey = getRequestKey(method, path);
        httpTable.put(tableKey, new ClassMethodComposition(classReference, methodInstance));
    }

    public static String processRequest(
            String method,
            String path) {

        String tableKey = getRequestKey(method, path);
        ClassMethodComposition classComposition = httpTable.get(tableKey);

        if(classComposition == null) {
            return buildHttpResponse("<h1>Page Not found</h1>", "400", "Error");
        }

        try {
            var instance = classComposition.classReference.getDeclaredConstructor().newInstance();
            var html =  (String) classComposition.methodReference.invoke(instance);
            return buildHttpResponse(html, "200", "Success");

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

    private static String getRequestKey(String method, String path) {
        return path + "___" + method;
    }
}
