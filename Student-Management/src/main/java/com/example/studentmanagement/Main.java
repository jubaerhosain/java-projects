package com.example.studentmanagement;


import client_management.ClientStudent;
import client_management.ClientTeacher;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private ClientStudent clientStudent;
    private ClientTeacher clientTeacher;

    private String serverIp;
    private Integer serverPortNumber;

    public Main() {
        scanner = new Scanner(System.in);
        clientStudent = new ClientStudent();
        clientTeacher = new ClientTeacher();
        serverIp = "127.0.0.1";
        serverPortNumber = 22222;
    }

    private void createStudentAccount() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Student student = new Student(name, email, password, 1, "1", "123456789");
        try {
            clientStudent.signUp(student, new Socket(serverIp, serverPortNumber));
        } catch (IOException e) {
            System.out.println(e.getMessage() + ", " + this.getClass());
        }
    }

    private void studentLogin() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        EMPair emPair = new EMPair(email, password);
        try {
            clientStudent.logIn(emPair, new Socket(serverIp, serverPortNumber));
        } catch (IOException e) {
            System.out.println(e.getMessage() + ", " + this.getClass());
        }
    }

    public void student() {
        while(true) {
            System.out.println("==========Student==========");
            System.out.println("Press 0 for go back.");
            System.out.println("Press 1 for create account.");
            System.out.println("Press 2 for log in.");
            System.out.println("Press 3 for get student list.");
            System.out.println("Press -1 for exit");
            System.out.print("Enter: ");

            int type = scanner.nextInt();
            scanner.nextLine();

            if(type == -1) {
                System.exit(0);
            } else if(type == 0) {
                return;
            } else if(type == 1) {
                createStudentAccount();
            } else if(type == 2) {
                studentLogin();
            } else if(type == 3) {
                try {
                    clientStudent.getInformation(new Socket(serverIp, serverPortNumber));
                } catch (IOException e) {
                    System.out.println(e.getMessage() + "," + this.getClass());
                }
            }
        }
    }

    private void createTeacherAccount() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Teacher teacher = new Teacher(name, email, password, 1, "1", 123456789.0);
        try {
            clientTeacher.signUp(teacher, new Socket(serverIp, serverPortNumber));
        } catch (IOException e) {
            System.out.println(e.getMessage() + ", " + this.getClass());
        }
    }

    private void teacherLogin() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        EMPair emPair = new EMPair(email, password);
        try {
            clientTeacher.logIn(emPair, new Socket(serverIp, serverPortNumber));
        } catch (IOException e) {
            System.out.println(e.getMessage() + ", " + this.getClass());
        }
    }

    public void teacher() {
        while(true) {
            System.out.println("==========Teacher==========");
            System.out.println("Press 0 for go back.");
            System.out.println("Press 1 for create account.");
            System.out.println("Press 2 for login.");
            System.out.println("Press 3 for get teacher list.");
            System.out.println("Press -1 for exit.");
            System.out.print("Enter: ");

            int type = scanner.nextInt();
            scanner.nextLine();

            if(type == -1) {
                System.exit(0);
            } else if (type == 0) {
                return;
            } else if (type == 1) {
                createTeacherAccount();
            } else if (type == 2) {
                teacherLogin();
            } else if (type == 3) {
                try {
                    clientTeacher.getInformation(new Socket(serverIp, serverPortNumber));
                } catch (IOException e) {
                    System.out.println(e.getMessage() + "," + this.getClass());
                }
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        while(true) {
            System.out.println("Press 0 for exit.");
            System.out.println("Press 1 for Student.");
            System.out.println("Press 2 for Teacher.");
            System.out.print("Enter: ");

            int type = scanner.nextInt();
            scanner.nextLine();

            if(type == 0) {
                System.exit(0);
            } else if(type == 1) {
                main.student();
            } else if(type == 2) {
                main.teacher();
            }
        }
    }
}














