package client_management;
import com.example.studentmanagement.*;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientTeacher implements ClientPerson {
    private ActionTypes actionTypes;

    public ClientTeacher() {
        this.actionTypes = new ActionTypes();
    }

    @Override
    public <Teacher> boolean signUp(Teacher teacher, Socket teacherSocket) {
        Connection teacherConnection = new Connection(teacherSocket);

        List<String> message = new ArrayList<>(2);
        // [object type, action]
        message.add("teacher");
        message.add(actionTypes.getSignUp());

        teacherConnection.writeObject(message);
        String messageFromServer = (String) teacherConnection.readObject();
        System.out.println(messageFromServer);

        teacherConnection.writeObject(teacher);
        messageFromServer = (String) teacherConnection.readObject();
        System.out.println(messageFromServer);

        return true;
    }

    @Override
    public <EMPair> boolean logIn(EMPair emPair, Socket teacherSocket) {
        Connection teacherConnection = new Connection(teacherSocket);
        List<String> message = new ArrayList<>(2);
        // [object type, action]
        message.add("teacher");
        message.add(actionTypes.getLogIn());

        teacherConnection.writeObject(message);
        String ackMessage = (String) teacherConnection.readObject();
        System.out.println(ackMessage);

        teacherConnection.writeObject(emPair);
        String confirmationMessage = (String) teacherConnection.readObject();
        System.out.println(confirmationMessage);
        return true;
    }

    @Override
    public List<Object> getInformation(Socket teacherSocket) {
        Connection teacherConnection = new Connection(teacherSocket);
        List<String> message = new ArrayList<>(2);
        // [object type, action]
        message.add("teacher");
        message.add(actionTypes.getGetInformation());

        teacherConnection.writeObject(message);
        String ackMessage = (String) teacherConnection.readObject();
        System.out.println(ackMessage);

        List<Object> objects = (List<Object>) teacherConnection.readObject();
        try {
            int count = 1;
            System.out.println("==========Teachers==========");
            for(Object object: objects) {
                System.out.println(count + ".");
                System.out.println((Teacher)object);
                count += 1;
            }
        } catch (NullPointerException e) {
            System.out.println("objects is null at ClientTeacher.java/List<Object> getInformation()");
        }

        return objects;
    }
}
