package client_management;


import com.example.studentmanagement.Student;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public Client() {

    }

    public static void main(String[] args) {
        try {
            ClientStudent clientStudent = new ClientStudent();

            Student student = new Student("Jubaer", "Hosain", "jubaerhosain1119@gmail.com",
                    "iit123", "male", 22, 0001, "2018-19", "Eight",
                    "A", "1119", "123456789");

            clientStudent.signUp(student, new Socket("127.0.0.1", 22222));

            clientStudent.getInformation(new Socket("127.0.0.1", 22222));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}














