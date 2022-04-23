package com.example.studentmanagement;

public class Teacher extends Person{
    private Integer teacherId;
    private Integer designation;
    private Double salary;

    public Teacher(String firstName, String lastName, String email, String password, String sex, Integer age, Integer teacherId, Integer designation, Double salary) {
        super(firstName, lastName, email, password, sex, age);
        this.teacherId = teacherId;
        this.designation = designation;
        this.salary = salary;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Teacher{" +
                "teacherId=" + teacherId +
                ", designation=" + designation +
                ", salary=" + salary +
                '}';
    }
}
