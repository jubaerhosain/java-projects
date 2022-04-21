package com.example.studentmanagement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public Connection(Socket socket) {
        this.socket = socket;
        try {
            // output stream should declare before input stream (otherwise not working at client side only)
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("IOException at Connection for client " + socket.getInetAddress());
        }
    }

    public void writeObject(Object object) {
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println("Couldn't able to write message for " + socket.getInetAddress());
        }
    }

    public Object readObject() {
        try {
            Object object = objectInputStream.readObject();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Couldn't able to write message for " + socket.getInetAddress());
        }
        return new Object();
    }

    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Couldn't able to close connection for " + socket.getInetAddress());
        }
    }
}


















