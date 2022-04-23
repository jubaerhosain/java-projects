package com.example.studentmanagement;

public class ActionTypes {
    private String signUp;
    private String logIn;
    private String getInformation;
    
    public ActionTypes() {
        this.signUp = "signUp";
        this.logIn = "logIn";
        this.getInformation = "getInformation";
    }

    public String getSignUp() {
        return signUp;
    }

    public String getLogIn() {
        return logIn;
    }

    public String getGetInformation() {
        return getInformation;
    }
}
