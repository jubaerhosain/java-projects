package client_management;
import com.example.studentmanagement.Connection;
import com.example.studentmanagement.Student;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientStudent implements ClientPerson {
    private Connection studentConnection;

    public ClientStudent(Socket studentSocket) {
        this.studentConnection = new Connection(studentSocket);
    }

    @Override
    public <Student> boolean signUp(Student student) {
        List<String> message = new ArrayList<>(2);
        message.add("student");
        message.add("signUp");

        studentConnection.writeObject(message);
        String messageFromServer = (String) studentConnection.readObject();
        System.out.println(messageFromServer);


        studentConnection.writeObject(student);
        messageFromServer = (String) studentConnection.readObject();
        System.out.println(messageFromServer);

        return false;
    }

    @Override
    public <Student> boolean logIn(Student student) {
        return false;
    }

    @Override
    public List<Object> getInformation() {
        return null;
    }
}
