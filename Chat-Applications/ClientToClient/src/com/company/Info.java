package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/** Information about client on the server */
public class Info {
    private String clientName;
    private Socket clientSocket;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    public Info(Socket socket) throws IOException {
        this.clientName = "Client";
        this.clientSocket = socket;
        this.reader = new ObjectInputStream(socket.getInputStream());
        this.writer = new ObjectOutputStream(socket.getOutputStream());
    }

    // read from client
    public Object read() throws IOException, ClassNotFoundException {
        return reader.readObject();
    }

    // write to client
    public void write(String message) throws IOException {
        writer.writeObject(message);
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return this.clientName;
    }
}
