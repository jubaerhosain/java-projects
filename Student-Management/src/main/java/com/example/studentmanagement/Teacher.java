package com.example.studentmanagement;

public class Teacher extends Person{
    private Integer teacherId;
    private Integer designation;
    private Double salary;

    public Teacher(String firstName, String lastName, String email, String password, String sex, Integer age) {
        super(firstName, lastName, email, password, sex, age);
    }
}
