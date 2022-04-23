package client_management;

import com.example.studentmanagement.Connection;
import com.example.studentmanagement.Student;
import com.example.studentmanagement.Teacher;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientTeacher implements ClientPerson {

    public ClientTeacher() {

    }

    @Override
    public <Teacher> boolean signUp(Teacher teacher, Socket teacherSocket) {
        return false;
    }

    @Override
    public <Type> boolean logIn(Type object, Socket teacherSocket) {
        return false;
    }

    @Override
    public List<Object> getInformation(Socket teacherSocket) {
        return null;
    }

}
