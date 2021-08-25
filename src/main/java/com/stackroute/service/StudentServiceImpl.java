package com.stackroute.service;


import com.stackroute.exception.InvalidCredentialException;
import com.stackroute.exception.StudentDataAlreadyExistException;
import com.stackroute.exception.StudentDataNotFoundException;
import com.stackroute.model.Student;
import com.stackroute.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public Student registerStudent(Student student) throws StudentDataAlreadyExistException {
        if (studentRepo.findById(student.getUsername()).isPresent()){
            throw new StudentDataAlreadyExistException();
        }
        return studentRepo.save(student);
    }

    @Override
    public Student login(Student student) throws StudentDataNotFoundException, InvalidCredentialException {
        if (!studentRepo.findById(student.getUsername()).isPresent()){
            throw new StudentDataNotFoundException();
        }
        Student getStudent = studentRepo.findByUsernameAndPassword(student.getUsername() , student.getPassword());
        if (getStudent==null){
            throw new InvalidCredentialException();
        }
        return getStudent;
    }

    @Override
    public Student updateData(Student student) throws StudentDataNotFoundException {
        if (!studentRepo.findById(student.getUsername()).isPresent()){
            throw new StudentDataNotFoundException();
        }
        return studentRepo.save(student);
    }
}
