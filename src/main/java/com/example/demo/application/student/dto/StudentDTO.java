package com.example.demo.application.student.dto;

import com.example.demo.domain.student.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO extends CreateStudentDTO{

    private long id;

    StudentDTO() {}

    public StudentDTO(long id, String fullName, double gpa) {
        super(fullName, gpa);
        this.id = id;
    }

    public static StudentDTO createDtoFromStudent(Student student) {
        return new StudentDTO(student.getId(),
                student.getFirstName() + " " + student.getLastName(),
                student.getGpa()
        );
    }

    public static List<StudentDTO> fromStudents(List<Student> students) {
        return students.stream().map(StudentDTO::createDtoFromStudent).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }
}
