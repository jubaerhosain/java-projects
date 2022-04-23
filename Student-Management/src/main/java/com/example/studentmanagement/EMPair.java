package com.example.studentmanagement;

import java.io.Serializable;

/** Pair of Email and Password */

public class EMPair implements Serializable {
    private String email;
    private String password;

    public EMPair(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
