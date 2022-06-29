package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;

public class UpdateStudentDTO {

    private long id;
    private String firstName;
    private String lastName;
    private double gpa;

    public UpdateStudentDTO(long id, String firstName, String lastName, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public static Student to(UpdateStudentDTO dto, long studentId) {
        return new Student(
                studentId,
                dto.getFirstName(),
                dto.getLastName(),
                dto.getGpa());
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }
}
