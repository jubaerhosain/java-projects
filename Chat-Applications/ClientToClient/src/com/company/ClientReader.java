package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientReader extends Thread{
    private String clientName;
    private Socket clientSocket;
    private ObjectInputStream clientInputStream;

    public ClientReader(Socket clientSocket, String clientName) throws IOException {
        this.clientName = clientName;
        this.clientSocket = clientSocket;
        this.clientInputStream = new ObjectInputStream(clientSocket.getInputStream());
    }

    @Override
    public void run() {
        // wait and read until server/client is running
        while(true) {
            try {
                // message received from server
                Object message = clientInputStream.readObject();
                System.out.println((String) message);
            } catch (IOException e) {
                // e.printStackTrace();
                System.out.println("Server is closed.");
            } catch (ClassNotFoundException e) {
                // e.printStackTrace();
                System.out.println("Class not found");
            }
        }
    }
}
