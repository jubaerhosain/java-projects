package com.example.studentmanagement;

public class Teacher extends Person{
    private Integer teacherId;
    private String designation;
    private Double salary;

    public Teacher(String name, String email, String password, Integer teacherId, String designation, Double salary) {
        super(name, email, password);
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
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
        return  super.toString() + '\n' +
                "Teacher Id = " + teacherId + '\n' +
                "Designation = " + designation + '\n' +
                "Salary = " + salary + '\n';
    }
}
