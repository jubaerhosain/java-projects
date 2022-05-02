package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Locale;

public class ServerThread1 extends Thread{
    private Socket clientSocket;


    public ServerThread1(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream serverInputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            // to get and sent multiple message from/to client
            while(true) {
                // message from client
                Object message = serverInputStream.readObject();
                System.out.println("Client Message: " + (String) message);

                String serverMessage = (String) message;
                serverMessage = serverMessage.toUpperCase();

                // send to client
                serverOutputStream.writeObject(serverMessage);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
