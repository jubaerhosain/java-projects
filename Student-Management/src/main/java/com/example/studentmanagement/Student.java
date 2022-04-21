package com.example.studentmanagement;

public class Student extends Person {
    private Integer studentId;
    private String session;
    private String className;
    private String group;
    private String classRoll;
    private String registrationNumber;

    public Student(String firstName, String lastName, String email, String password, String sex, Integer age, Integer studentId, String session, String className, String group, String classRoll, String registrationNumber) {
        super(firstName, lastName, email, password, sex, age);
        this.studentId = studentId;
        this.session = session;
        this.className = className;
        this.group = group;
        this.classRoll = classRoll;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getClassRoll() {
        return classRoll;
    }

    public void setClassRoll(String classRoll) {
        this.classRoll = classRoll;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
