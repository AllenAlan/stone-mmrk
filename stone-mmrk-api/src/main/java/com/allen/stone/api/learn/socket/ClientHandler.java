package com.allen.stone.api.learn.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/20 16:40
 **/
public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final RequestHandler requestHandler;

    public ClientHandler(Socket clientSocket, RequestHandler requestHandler) {
        this.clientSocket = clientSocket;
        this.requestHandler = requestHandler;
    }

    @Override
    public void run() {
        try (Scanner input = new Scanner(clientSocket.getInputStream())) {
            while (true) {
                String request = input.nextLine();
                System.out.println(String.format("Request from %s %s", clientSocket.getRemoteSocketAddress(), request));
                if (request.equals("quit")) {
                    break;
                }
                String response = requestHandler.hander(request);
                clientSocket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            System.out.println("Caught exception:" + e);
            throw new RuntimeException(e);
        }
    }
}
