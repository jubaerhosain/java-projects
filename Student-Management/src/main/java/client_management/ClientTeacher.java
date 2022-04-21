package client_management;

import com.example.studentmanagement.Connection;
import com.example.studentmanagement.Student;
import com.example.studentmanagement.Teacher;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientTeacher implements ClientPerson {
    private Connection teacherConnection;

    public ClientTeacher(Socket studentSocket) {
        this.teacherConnection = new Connection(studentSocket);
    }

    @Override
    public <Teacher> boolean signUp(Teacher teacher) {
        return false;
    }

    @Override
    public <Teacher> boolean logIn(Teacher teacher) {
        return false;
    }

    @Override
    public List<Object> getInformation() {
        return null;
    }
}
