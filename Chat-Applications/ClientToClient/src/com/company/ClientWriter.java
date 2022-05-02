package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriter extends Thread{
    private String clientName;
    private Socket clientSocket;
    private ObjectOutputStream clientOutputStream;

    public ClientWriter(Socket clientSocket, String clientName) throws IOException {
        this.clientName = clientName;
        this.clientSocket = clientSocket;
        this.clientOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
    }


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            // message to be sent
            String message = scanner.nextLine();
            try {
                // sent message to the server
                clientOutputStream.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
