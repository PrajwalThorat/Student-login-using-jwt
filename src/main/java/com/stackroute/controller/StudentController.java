package com.stackroute.controller;


import com.stackroute.exception.InvalidCredentialException;
import com.stackroute.exception.StudentDataAlreadyExistException;
import com.stackroute.exception.StudentDataNotFoundException;
import com.stackroute.model.Student;
import com.stackroute.security.JwtTokenGenerator;
import com.stackroute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private StudentService studentService;
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    public StudentController(StudentService studentService, JwtTokenGenerator jwtTokenGenerator) {
        this.studentService = studentService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) throws StudentDataAlreadyExistException {
        return new ResponseEntity<>(studentService.registerStudent(student) , HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Student> studentLogin(@RequestBody Student student) throws StudentDataNotFoundException, InvalidCredentialException {
        Student existStudent = studentService.login(student);
        Map<String , String> tokenMap = null;
        if (existStudent!=null){
            tokenMap = jwtTokenGenerator.genrateToken(student);
        }
        return new ResponseEntity (tokenMap , HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudentData(@RequestBody Student student) throws StudentDataNotFoundException {
        return new ResponseEntity<>(studentService.updateData(student) , HttpStatus.OK);
    }

}
