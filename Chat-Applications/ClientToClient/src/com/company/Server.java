package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, Info> clientList;

    public Server() {
        clientList = new HashMap<>();
    }


    public void start(int port) throws IOException {
        System.out.println("Server is started.");

        ServerSocket serverSocket = new ServerSocket(port);

        // server in listen mode
        // this loop for accepting multiple client socket
        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Connected(Server)");

            new ServerThread(new Info(clientSocket), clientList).start();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(22222);
    }
}
