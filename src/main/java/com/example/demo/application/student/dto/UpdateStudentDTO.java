package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;

public class UpdateStudentDTO extends CreateStudentDTO{

    private long id;
    private String firstName;
    private String lastName;

    public UpdateStudentDTO(String fullName, double gpa) {
        super(fullName, gpa);
        this.firstName = fullName.split(" ")[0];
        this.lastName = fullName.split(" ")[1];
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
}
