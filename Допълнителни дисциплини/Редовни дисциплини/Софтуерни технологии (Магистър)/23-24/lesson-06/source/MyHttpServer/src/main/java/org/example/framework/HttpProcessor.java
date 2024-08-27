package org.example.framework;

import org.example.framework.server.contracts.HttpRequestObject;

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

            System.out.println("Server is listening on port " + this.portNumber);

            while(this.isHttpConnectionProcessable()) {

                Socket socket = this.serverSocket.accept();

                InputStream request     = socket.getInputStream();
                OutputStream response   = socket.getOutputStream();

                HttpRequestObject httpRequest = this.processHttpStream(request);

                String responseBody = HttpTable.processRequest(httpRequest);
                response.write(responseBody.getBytes());

                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpRequestObject processHttpStream(InputStream request) {

        // Basic HTTP parser
        InputStreamReader streamReader = new InputStreamReader(request);
        BufferedReader buffer          = new BufferedReader(streamReader);

        String bufferedString;
        String httpMethod = "";
        String httpEndpoint = "";


        try {
            while ((bufferedString = buffer.readLine()) != null) {
                System.out.println(bufferedString);
                var httpElementCollection = bufferedString.split(" ");
                httpMethod   = httpElementCollection[0];
                httpEndpoint = httpElementCollection[1];
                break;
            }

            return new HttpRequestObject(httpMethod, httpEndpoint);
        }
        catch (IOException e) {
            return new HttpRequestObject();
        }
    }

    private boolean isHttpConnectionProcessable() {
        return this.serverSocket.isBound() &&
                !this.serverSocket.isClosed();
    }
}
