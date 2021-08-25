package com.stackroute.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @Value(value = "${data.exception.msg1}")
    private String msg1;

    @ExceptionHandler(value = StudentDataAlreadyExistException.class)
    public ResponseEntity<String> dataAlreadyException(StudentDataAlreadyExistException studentDataAlreadyExistException){
        return new ResponseEntity<String>(msg1 , HttpStatus.CONFLICT);
    }

    @Value(value = "${data.exception.msg2}")
    private String msg2;

    @ExceptionHandler(value = StudentDataNotFoundException.class)
    public ResponseEntity<String> dataNotFoundException(StudentDataNotFoundException studentDataNotFoundException){
        return new ResponseEntity<String>(msg2 , HttpStatus.CONFLICT);
    }

    @Value(value = "${data.exception.msg3}")
    private String msg3;

    @ExceptionHandler(value = InvalidCredentialException.class)
    public ResponseEntity<String> invalidCredential(InvalidCredentialException credentialException){
        return new ResponseEntity<String>(msg3 , HttpStatus.CONFLICT);
    }
}
