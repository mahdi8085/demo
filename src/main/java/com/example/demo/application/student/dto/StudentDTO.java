package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.studentrole.studentauthority.StudentAuthority;
import com.example.demo.domain.student.studentrole.studentauthority.StudentAuthorityType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDTO {

    private long id;
    private String username;
    private String fullName;
    private double gpa;
    private String studentRoleType;
    private Set<String> studentAuthorityTypes;
    private String accessToken;

    StudentDTO() {}

    public StudentDTO(long id, String username, String fullName, double gpa, String studentRoleType, Set<String> studentAuthorityTypes, String accessToken) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.gpa = gpa;
        this.studentRoleType = studentRoleType;
        this.studentAuthorityTypes = studentAuthorityTypes;
        this.accessToken = accessToken;
    }

    public StudentDTO(long id, String username, String fullName, double gpa, String studentRoleType, Set<String> studentAuthorityTypes) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.gpa = gpa;
        this.studentRoleType = studentRoleType;
        this.studentAuthorityTypes = studentAuthorityTypes;
    }

    public static StudentDTO createDtoFromStudent(Student student, String accessToken) {
        Set<String> authorities = new HashSet<>();
        for (StudentAuthority authority : student.getStudentRole().getStudentAuthorities()) {
            authorities.add(authority.getStudentAuthorityType().getTitle());
        }
        return new StudentDTO(student.getId(),
                student.getUsername(),
                student.getFirstName() + " " + student.getLastName(),
                student.getGpa(),
                student.getStudentRole().getStudentRoleType().getTitle(),
                authorities,
                accessToken
        );
    }

    public static StudentDTO createDtoFromStudent(Student student) {
        Set<String> authorities = new HashSet<>();
        for (StudentAuthority authority : student.getStudentRole().getStudentAuthorities()) {
            authorities.add(authority.getStudentAuthorityType().getTitle());
        }
        return new StudentDTO(student.getId(),
                student.getUsername(),
                student.getFirstName() + " " + student.getLastName(),
                student.getGpa(),
                student.getStudentRole().getStudentRoleType().getTitle(),
                authorities
        );
    }

    public static List<StudentDTO> fromStudents(List<Student> students) {
        return students.stream().map(StudentDTO::createDtoFromStudent).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
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

    public String getAccessToken() {
        return accessToken;
    }
}
