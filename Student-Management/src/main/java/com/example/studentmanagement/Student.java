package com.example.studentmanagement;

public class Student extends Person {
    private Integer studentId;
    private String classRoll;
    private String registrationNumber;


    public Student(String name, String email, String password, Integer studentId, String classRoll, String registrationNumber) {
        super(name, email, password);
        this.studentId = studentId;
        this.classRoll = classRoll;
        this.registrationNumber = registrationNumber;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getClassRoll() {
        return classRoll;
    }

    public void setClassRoll(String classRoll) {
        this.classRoll = classRoll;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {

        return  super.toString() + '\n' +
                "Student Id = " + studentId + '\n' +
                "Class Roll = " + classRoll + '\n' +
                "Registration Number = " + registrationNumber + '\n';
    }
}
