package com.stackroute.exception;

public class StudentDataAlreadyExistException extends Exception{

    private String message;

    public StudentDataAlreadyExistException() {
    }

    public StudentDataAlreadyExistException(String message) {
        this.message = message;
    }
}
