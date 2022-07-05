package com.example.demo.infrastructure.security;

import com.example.demo.domain.student.Student;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {

    private final String jwtSecret = "GUE7R832T329Y28G328239G38GFF238329RLK9048485YE9RE";

    public JwtTokenUtil() {}

    public String generateAccessToken(Student student) {
        return null;
    }
}
