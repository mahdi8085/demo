package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;

public class CreateStudentDTO {

    private long id;
    private String fullName;
    private double gpa;

    public CreateStudentDTO(long id, String fullName, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public static Student to(CreateStudentDTO dto) {
        return new Student(
                dto.getFullName().split(" ")[0],
                dto.getFullName().split(" ")[1],
                dto.getGpa());
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }
}
