package server_management;

import java.util.List;
import java.net.Socket;
import com.example.studentmanagement.Connection;

public class ServerThread extends Thread {
    private Connection clientConnection;

    public ServerThread(Socket clientSocket) {
        this.clientConnection = new Connection(clientSocket);
    }

    @Override
    public void run() {
        // read from client
        List<String> clientMessage = (List<String>) clientConnection.readObject();
        System.out.println("Client Message: " +  clientMessage);

         // send to client
         clientConnection.writeObject("Query received successfully.");

        Object object = clientConnection.readObject();
        clientConnection.writeObject("Object received successfully.");



        // close client socket if client connection is broken
        clientConnection.closeConnection();
    }
}

