package com.example.studentmanagement;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String email;
    private String password;

    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean matchEmail(String email) {
        return this.email.equals(email);
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return  "Name = " + name + "\n" +
                "Email = " + email;
    }
}
