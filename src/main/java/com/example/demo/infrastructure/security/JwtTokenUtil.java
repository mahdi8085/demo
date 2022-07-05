package com.example.demo.infrastructure.security;

import com.example.demo.domain.student.Student;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.String.format;

@Component
public class JwtTokenUtil {

    private final String jwtSecret = "GUE7R832T329Y28G328239G38GFF238329RLK9048485YE9RE";

    public JwtTokenUtil() {}

    public String generateAccessToken(Student student) {
        return Jwts.builder()
                .setSubject(format("%s,%s", student.getId(), student.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7*24*60*60*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject().split(",")[0];
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject().split(",")[1];
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT signature - {}" + ex.getMessage());
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token - {}" + ex.getMessage());
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token - {}" + ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token - {}" + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty - {}" + ex.getMessage());
        }
        return false;
    }
}
