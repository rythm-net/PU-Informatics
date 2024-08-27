package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CRL;

public class HttpServer {

    public  static void main(String[] args) {

        try {
            HttpServerClassLoader.bootstrapApplication();
            HttpServerClassLoader.bootstrapServices();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            HttpProcessor httpProcessor = new HttpProcessor(3184);
            httpProcessor.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}