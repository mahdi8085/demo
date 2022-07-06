package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.studentrole.StudentRole;
import com.example.demo.domain.student.studentrole.StudentRoleType;
import com.example.demo.domain.student.studentrole.studentauthority.StudentAuthority;
import com.example.demo.domain.student.studentrole.studentauthority.StudentAuthorityType;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class CreateStudentDTO {

    private String username;
    private String password;
    private String fullName;
    private double gpa;
    private String studentRoleType;
    private Set<String> studentAuthorityTypes;

    CreateStudentDTO() {}

    public CreateStudentDTO(String username, String password, String fullName, double gpa,
                            String studentRoleType, Set<String> studentAuthorityTypes) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gpa = gpa;
        this.studentRoleType = studentRoleType;
        this.studentAuthorityTypes = studentAuthorityTypes;
    }

    public static Student to(CreateStudentDTO dto, PasswordEncoder passwordEncoder){
        Set<StudentAuthority> authorities = new HashSet<>();
        for(String type: dto.getStudentAuthorityTypes()) {
            authorities.add(
                    new StudentAuthority(
                            StudentAuthorityType.getByStudentAuthorityTitle(type)
                    )
            );
        }
        return new Student(
                dto.getUsername(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getFullName().split(" ")[0],
                dto.getFullName().split(" ")[1],

                dto.getGpa(),
                new StudentRole(StudentRoleType.getByStudentRoleTypeTitle(
                        dto.getStudentRoleType()),
                        authorities
                ));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public String getStudentRoleType() {
        return studentRoleType;
    }

    public Set<String> getStudentAuthorityTypes() {
        return studentAuthorityTypes;
    }
}
