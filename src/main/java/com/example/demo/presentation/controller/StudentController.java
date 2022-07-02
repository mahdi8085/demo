package com.example.demo.presentation.controller;

import com.example.demo.application.student.StudentDefaultService;
import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.StudentDTO;
import com.example.demo.domain.student.Student;
import com.example.demo.application.student.dto.UpdateStudentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "students")
public class StudentController {

    StudentDefaultService studentDefaultService;

    public StudentController(StudentDefaultService studentDefaultService) {
        this.studentDefaultService = studentDefaultService;
    }

    @GetMapping(path = "get")
    public List<StudentDTO> getStudents(
            @RequestParam String lastName,
            @RequestParam double gpa,
            @RequestParam int size,
            @RequestParam int pageSize) {
        return studentDefaultService.get(lastName, gpa, size, pageSize);
    }

    @PostMapping(path = "add")
    public Student addStudent(@RequestBody CreateStudentDTO dto) {
        return studentDefaultService.create(dto);
    }

    @PutMapping(path = "edit")
    public Student editStudent(@RequestBody UpdateStudentDTO dto) {
        return studentDefaultService.update(dto);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentDefaultService.delete(id);
    }
}
