package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;

public class CreateStudentDTO {

    private String fullName;
    private double gpa;

    public CreateStudentDTO(String fullName, double gpa) {
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public static Student to(CreateStudentDTO dto) {
        return new Student(
                dto.getFullName().split(" ")[0],
                dto.getFullName().split(" ")[1],
                dto.getGpa());
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }
}
