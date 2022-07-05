package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;

public class CreateStudentDTO {

    private String username;
    private String password;
    private String fullName;
    private double gpa;

    CreateStudentDTO() {}

    public CreateStudentDTO(String fullName, double gpa) {
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public CreateStudentDTO(String username, String password, String fullName, double gpa) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public static Student to(CreateStudentDTO dto) {
        return new Student(
                dto.getFullName().split(" ")[0],
                dto.getFullName().split(" ")[1],
                dto.getGpa());
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
}
