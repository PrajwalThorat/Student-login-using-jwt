package com.stackroute.service;

import com.stackroute.exception.InvalidCredentialException;
import com.stackroute.exception.StudentDataAlreadyExistException;
import com.stackroute.exception.StudentDataNotFoundException;
import com.stackroute.model.Student;

public interface StudentService {

    public Student registerStudent(Student student) throws StudentDataAlreadyExistException;

    public Student login(Student student) throws StudentDataNotFoundException, InvalidCredentialException;

    public Student updateData(Student student) throws StudentDataNotFoundException;
}
