package com.stackroute.security;

import com.stackroute.model.Student;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenGeneratorImpl implements JwtTokenGenerator{


    @Override
    public Map<String, String> genrateToken(Student student) {
        String jwtToken = Jwts.builder().setIssuer("StudentDataApp").setIssuedAt(new Date()).setSubject(student.getUsername()).signWith(SignatureAlgorithm.HS256 , "secretKey").compact();
        Map<String,String> map = new HashMap<>();
        map.put("token" , jwtToken);
        map.put("message" , "Authenticate Succesfull");
        return map;
    }
}
