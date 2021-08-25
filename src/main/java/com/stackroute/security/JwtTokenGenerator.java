package com.stackroute.security;

import com.stackroute.model.Student;

import java.util.Map;

public interface JwtTokenGenerator {

    Map<String , String> genrateToken(Student student);
}
