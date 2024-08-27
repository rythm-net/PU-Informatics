package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CRL;
import java.util.Set;

public class HttpServer {
    final static String CRLF = "\n\r";

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

    public  static void main(String[] args) {

        CustomClassLoader ccl = new CustomClassLoader();
        Set<Class> collection = ccl.findAllClasses("application");

        WorkerThread wt = new WorkerThread();
        wt.start();
    }
}