package org.example.framework.server.parsers;

import org.example.framework.server.contracts.HttpContentTypeEnum;
import org.example.framework.server.contracts.HttpRequestObject;
import org.example.framework.server.contracts.HttpResponseObject;
import org.example.framework.server.types.ControllerJsonResponse;
import org.example.framework.server.types.ControllerView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MethodReturnTypeParser {

    private static HttpRequestObject requestObject    = null;
    private static HttpResponseObject responseObject  = null;

    public static String parse(
            Object methodReturnValue,
            HttpRequestObject request,
            HttpResponseObject response
    ) {

        requestObject = request;
        responseObject = response;

        if(methodReturnValue instanceof String s) {
            return parseStringTemplate(s);
        }

        if(methodReturnValue instanceof ControllerView cv) {
            return parseControllerView(cv);
        }

        if(methodReturnValue instanceof ControllerJsonResponse<?> cjr) {
            return parseControllerJsonResponse(cjr);
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

    private static String parseControllerJsonResponse(ControllerJsonResponse cjr) {

        responseObject.setContentType(HttpContentTypeEnum.JSON);
        return cjr.getTypeResult();
    }
}
