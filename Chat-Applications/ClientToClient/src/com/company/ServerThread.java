package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Locale;
import java.util.Map;

public class ServerThread extends Thread{
    private Info clientInfo;
    private Map<String, Info> clientList;


    public ServerThread(Info clientInfo, Map<String, Info> clientList) {
        this.clientInfo = clientInfo;
        this.clientList = clientList;
    }

    @Override
    public void run() {
        try {
            // to get and sent multiple message from/to client
            while(true) {
                // message from client
                String message = (String) clientInfo.read();

                String[] arguments = message.split("\\$");

                // if client request for register
                if(arguments[0].equals("register")) {
                    String clientName = arguments[1];
                    clientInfo.setClientName(clientName);
                    clientList.put(clientName, clientInfo);

                    // sent to client
                    clientInfo.write(clientName + " logged in successfully.");
                }

                // if a client request for list of registered clients
                else if(arguments[0].equals("get")) {
                    if(clientList.size() == 0) {
                        clientInfo.write("No registered client available.");
                    }
                    else {
                        String clients = "";
                        for(String name: clientList.keySet()) {
                            clients += name + '\n';
                        }
                        clientInfo.write("Registered clients are: \n" + clients);
                    }
                }

                // if a client want to send the message to another client
                else if(arguments[0].equals("send")) {
                    String sender = arguments[1];
                    String receiver = arguments[2];
                    String dataMessage = arguments[3];

                    Info receiverInfo = clientList.get(receiver);
                    receiverInfo.write(sender + ": " + dataMessage);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        try {
//            clientInfo..close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
