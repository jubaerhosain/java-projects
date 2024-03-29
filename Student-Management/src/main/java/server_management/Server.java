package server_management;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);

        System.out.println("Server is started...");

        while(true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client " + clientSocket.getInetAddress() + " is connected");

            ServerThread serverThread = new ServerThread(clientSocket);
            serverThread.start();
        }
    }
}
