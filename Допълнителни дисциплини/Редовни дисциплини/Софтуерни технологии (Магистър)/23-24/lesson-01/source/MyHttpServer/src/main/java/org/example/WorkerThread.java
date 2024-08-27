package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WorkerThread extends Thread {

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

    public void run() {

        try {
            ServerSocket serverSocket = new ServerSocket(3219);

            while(serverSocket.isBound() && !serverSocket.isClosed()) {

                Socket socket = serverSocket.accept();

                InputStream request     = socket.getInputStream();
                OutputStream response   = socket.getOutputStream();

                // Basic HTTP parser
                InputStreamReader streamReader = new InputStreamReader(request);
                BufferedReader buffer          = new BufferedReader(streamReader);

                String bufferedString;
                String httpMethod = "";
                String httpEndpoint = "";

                while ((bufferedString = buffer.readLine()) != null) {

                    var httpElementCollection = bufferedString.split(" ");
                    httpMethod   = httpElementCollection[0];
                    httpEndpoint = httpElementCollection[1];
                    break;
                }


                String result       = HttpTable.processRequest(httpEndpoint, httpMethod);
                String responseBody = buildHttpResponse(result, "200", "OK");
                response.write(responseBody.getBytes());


                // reflection - get all classes based on anotation


//                if(httpMethod.equals("GET") && httpEndpoint.equals("/users")) {
//
//                    String responseBody = buildHttpResponse("<h1>USERS endpoint</h1>", "200", "OK");
//                    response.write(responseBody.getBytes());
//                }
//
//                if(httpMethod.equals("GET") && httpEndpoint.equals("/hello")) {
//
//                    String responseBody = buildHttpResponse("<h1>HELLO endpoint</h1>", "400", "Error");
//                    response.write(responseBody.getBytes());
//                }

                socket.close();
                // request.close();
                // response.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
