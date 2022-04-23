package server_management;

import java.util.List;
import java.net.Socket;

import com.example.studentmanagement.*;

public class ServerThread extends Thread {
    private Query query;
    private ActionTypes actionTypes;
    private Connection clientConnection;

    public ServerThread(Socket clientSocket) {
        this.query = new Query();
        this.actionTypes = new ActionTypes();
        this.clientConnection = new Connection(clientSocket);
    }

    public void student(String actionType) {
        String fileName = "students.txt";
        if(actionType.equals(this.actionTypes.getSignUp())) {
            Object object = clientConnection.readObject();
            if(query.studentSignUp(fileName, (Student) object)) {
                clientConnection.writeObject("Signed up successfully.");
            } else {
                clientConnection.writeObject("Couldn't sign up.");
            }
        } else if(actionType.equals(this.actionTypes.getLogIn())) {
            Object object = clientConnection.readObject();
            if(query.studentLogIn(fileName, (EMPair) object)) {
                clientConnection.writeObject("Logged in successfully.");
            } else {
                clientConnection.writeObject("Couldn't log in.");
            }
        } else if(actionType.equals(this.actionTypes.getGetInformation())) {
            List<Object> students = query.getInformation(fileName);
            clientConnection.writeObject(students);
        }
    }

    public void teacher(String actionType) {
        String fileName = "teachers.txt";
        if(actionType.equals(this.actionTypes.getSignUp())) {
            Object object = clientConnection.readObject();
            if(query.teacherSignUp(fileName, (Teacher) object)) {
                clientConnection.writeObject("Signed up successfully.");
            } else {
                clientConnection.writeObject("Couldn't sign up.");
            }
        } else if(actionType.equals(this.actionTypes.getLogIn())) {
            Object object = clientConnection.readObject();
            if(query.teacherLogIn(fileName, (EMPair) object)) {
                clientConnection.writeObject("Logged in successfully.");
            } else {
                clientConnection.writeObject("Couldn't log in.");
            }
        } else if(actionType.equals(this.actionTypes.getGetInformation())) {
            List<Object> teachers = query.getInformation(fileName);
            clientConnection.writeObject(teachers);
        }
    }

    @Override
    public void run() {
        // read query from client
        List<String> clientQuery = (List<String>) clientConnection.readObject();
        System.out.println("Client Message: " +  clientQuery);
        // send to client
        clientConnection.writeObject("Query received successfully.");

        String objectType = clientQuery.get(0);
        String actionType = clientQuery.get(1);

        if(objectType.equals("student")) {
            student(actionType);
        }
        else if(objectType.equals("teacher")) {
            teacher(actionType);
        }

        // close client socket if client connection is broken
        clientConnection.closeConnection();
    }
}

