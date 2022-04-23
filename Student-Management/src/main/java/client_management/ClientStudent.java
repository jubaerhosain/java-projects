package client_management;
import com.example.studentmanagement.ActionTypes;
import com.example.studentmanagement.Connection;
import com.example.studentmanagement.EMPair;
import com.example.studentmanagement.Student;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientStudent implements ClientPerson {
    private ActionTypes actionTypes;

    public ClientStudent() {
        this.actionTypes = new ActionTypes();
    }

    @Override
    public <Student> boolean signUp(Student student, Socket studentSocket) {
        Connection studentConnection = new Connection(studentSocket);

        List<String> message = new ArrayList<>(2);
        // [object type, action]
        message.add("student");
        message.add(actionTypes.getSignUp());

        studentConnection.writeObject(message);
        String messageFromServer = (String) studentConnection.readObject();
        System.out.println(messageFromServer);


        studentConnection.writeObject(student);
        messageFromServer = (String) studentConnection.readObject();
        System.out.println(messageFromServer);

        return true;
    }

    @Override
    public <EMPair> boolean logIn(EMPair emPair, Socket studentSocket) {
        Connection studentConnection = new Connection(studentSocket);
        List<String> message = new ArrayList<>(2);
        // [object type, action]
        message.add("student");
        message.add(actionTypes.getLogIn());

        studentConnection.writeObject(message);
        String ackMessage = (String) studentConnection.readObject();
        System.out.println(ackMessage);


        studentConnection.writeObject(emPair);
        String confirmationMessage = (String) studentConnection.readObject();
        System.out.println(confirmationMessage);
        return true;
    }

    @Override
    public List<Object> getInformation(Socket studentSocket) {
        Connection studentConnection = new Connection(studentSocket);
        List<String> message = new ArrayList<>(2);
        // [object type, action]
        message.add("student");
        message.add(actionTypes.getGetInformation());

        studentConnection.writeObject(message);
        String ackMessage = (String) studentConnection.readObject();
        System.out.println(ackMessage);

        List<Object> objects = (List<Object>) studentConnection.readObject();
        try {
            int count = 1;
            System.out.println("==========Students==========");
            for(Object object: objects) {
                System.out.println(count + ".");
                System.out.println((Student)object);
                count += 1;
            }
        } catch (NullPointerException e) {
            System.out.println("objects is null at ClientStudent.java/List<Object> getInformation()");
        }

        return objects;
    }
}
