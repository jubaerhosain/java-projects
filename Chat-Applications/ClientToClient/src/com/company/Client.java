package com.company;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public void start(int port) throws IOException {
        System.out.println("Client is started on port: " + port);

        Socket clientSocket = new Socket("127.0.0.1", port);

        // start client-writer and client-reader thread
        // output-stream should declare before input-stream in client side
        new ClientWriter(clientSocket, "Client1").start();
        new ClientReader(clientSocket, "Client1").start();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start(22222);
    }
}
