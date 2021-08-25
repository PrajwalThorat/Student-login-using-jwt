package com.stackroute.exception;

public class StudentDataNotFoundException extends Exception{

    private String message;

    public StudentDataNotFoundException() {
    }

    public StudentDataNotFoundException(String message) {
        this.message = message;
    }
}
