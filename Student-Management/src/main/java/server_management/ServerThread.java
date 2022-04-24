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

    private void signUp(String fileName) {
        Object object = clientConnection.readObject();
        if(query.signUp(fileName, object)) {
            clientConnection.writeObject("Signed up successfully.");
        } else {
            clientConnection.writeObject("Couldn't sign up.");
        }
    }

    private void logIn(String fileName) {
        Object object = clientConnection.readObject();
        if(query.logIn(fileName, (EMPair) object)) {
            clientConnection.writeObject("Logged in successfully.");
        } else {
            clientConnection.writeObject("Couldn't log in.");
        }
    }

    private void getInformation(String fileName) {
        List<Object> students = query.getInformation(fileName);
        clientConnection.writeObject(students);
    }

    private void student(String actionType) {
        String fileName = "students.txt";
        if(actionType.equals(this.actionTypes.getSignUp())) {
            signUp(fileName);
        } else if(actionType.equals(this.actionTypes.getLogIn())) {
            logIn(fileName);
        } else if(actionType.equals(this.actionTypes.getGetInformation())) {
            getInformation(fileName);
        }
    }

    private void teacher(String actionType) {
        String fileName = "teachers.txt";
        if(actionType.equals(this.actionTypes.getSignUp())) {
            signUp(fileName);
        } else if(actionType.equals(this.actionTypes.getLogIn())) {
            logIn(fileName);
        } else if(actionType.equals(this.actionTypes.getGetInformation())) {
            getInformation(fileName);
        }
    }

    @Override
    public void run() {
        List<String> clientQuery = (List<String>) clientConnection.readObject();
        System.out.println("Client Message: " +  clientQuery);
        clientConnection.writeObject("Query received successfully.");

        String objectType = clientQuery.get(0);
        String actionType = clientQuery.get(1);

        if(objectType.equals("student")) {
            student(actionType);
        } else if(objectType.equals("teacher")) {
            teacher(actionType);
        }

        clientConnection.closeConnection();
    }
}

