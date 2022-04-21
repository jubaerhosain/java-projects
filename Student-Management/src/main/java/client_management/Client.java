package client_management;


import com.example.studentmanagement.Connection;
import com.example.studentmanagement.Person;
import com.example.studentmanagement.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Client {
    private ClientStudent clientStudent;
    private ClientTeacher clientTeacher;

    public Client() {

    }

    public static void m(Person p) {

    }


    public static void main(String[] args) {
        try {
            ClientStudent clientStudent = new ClientStudent(new Socket("127.0.0.1", 22222));

            Student student = new Student("Jubaer", "Hosain", "jubaerhosain1119@gmail.com",
                    "iit123", "male", 22, 0001, "2018-19", "Eight",
                    "A", "1119", "123456789");

            clientStudent.signUp(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}














