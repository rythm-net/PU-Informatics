package org.example;

import org.example.app.UserController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpProcessor extends Thread {


    private int portNumber;
    private ServerSocket serverSocket;

    public HttpProcessor(int portNumber) throws IOException {

        this.portNumber = portNumber;
        this.serverSocket = new ServerSocket(this.portNumber);
    }


    public void run() {

        try {

            while(this.isHttpConnectionProcessable()) {

                Socket socket = this.serverSocket.accept();

                InputStream request     = socket.getInputStream();
                OutputStream response   = socket.getOutputStream();

                // Basic HTTP parser
                InputStreamReader streamReader = new InputStreamReader(request);
                BufferedReader buffer          = new BufferedReader(streamReader);

                String bufferedString;
                String httpMethod = "";
                String httpEndpoint = "";


                while ((bufferedString = buffer.readLine()) != null) {
                    System.out.println(bufferedString);
                    var httpElementCollection = bufferedString.split(" ");
                    httpMethod   = httpElementCollection[0];
                    httpEndpoint = httpElementCollection[1];
                    break;
                }

                String responseBody = HttpTable.processRequest(httpMethod, httpEndpoint);
                response.write(responseBody.getBytes());

//
//                if(httpMethod.equals("GET") && httpEndpoint.equals("/users")) {
//
//                    UserController controller = new UserController();
//                    String responseHTML = controller.getUserBalance();
//
//                    String responseBody = buildHttpResponse(responseHTML, "200", "OK");
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

    private boolean isHttpConnectionProcessable() {
        return this.serverSocket.isBound() &&
                !this.serverSocket.isClosed();
    }
}
