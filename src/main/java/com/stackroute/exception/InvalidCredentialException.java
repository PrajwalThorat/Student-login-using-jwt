package com.stackroute.exception;

public class InvalidCredentialException extends Exception{

    private String message;

    public InvalidCredentialException() {
    }

    public InvalidCredentialException(String message) {
        this.message = message;
    }
}
