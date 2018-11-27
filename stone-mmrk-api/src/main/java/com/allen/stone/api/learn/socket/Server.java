package com.allen.stone.api.learn.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/20 15:31
 **/
public class Server {

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        RequestHandler requestHandler = new RequestHandler();
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("listening on " + serverSocket.getLocalSocketAddress());
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("accepting connection from " + clientSocket.getRemoteSocketAddress());
               executor.submit(new ClientHandler(clientSocket, requestHandler));
            }
        }

    }

}
