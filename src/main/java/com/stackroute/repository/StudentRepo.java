package com.stackroute.repository;

import com.stackroute.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student , String> {

    public Student findByUsername(String username);

    public Student findByPassword(String password);

    public Student findByUsernameAndPassword(String username , String password);
}
