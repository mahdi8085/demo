package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;

import java.util.Set;

public class UpdateStudentDTO extends CreateStudentDTO {

    private long id;
    private String firstName;
    private String lastName;

    UpdateStudentDTO() {}

    public UpdateStudentDTO(long id, String username, String password, String fullName, double gpa,
                            String studentRoleType, Set<String> studentAuthorityTypes) {
        super(username, password, fullName, gpa, studentRoleType, studentAuthorityTypes);
        this.firstName = fullName.split(" ")[0];
        this.lastName = fullName.split(" ")[1];
        this.id = id;
    }

    public static Student to(UpdateStudentDTO dto, long studentId) {
        return new Student(
                studentId,
                dto.getFirstName(),
                dto.getLastName(),
                dto.getGpa());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }
}
