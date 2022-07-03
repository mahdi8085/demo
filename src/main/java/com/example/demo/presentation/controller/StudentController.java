package com.example.demo.presentation.controller;

import com.example.demo.application.student.StudentDefaultService;
import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.UpdateStudentDTO;
import com.example.demo.presentation.responseentity.ResponseEntityUtil;
import com.example.demo.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "students")
public class StudentController {

    StudentDefaultService studentDefaultService;

    public StudentController(StudentDefaultService studentDefaultService) {
        this.studentDefaultService = studentDefaultService;
    }

    @GetMapping(path = "get")
    public ResponseEntity<Object> getStudents(
            @RequestParam String lastName,
            @RequestParam double gpa,
            @RequestParam int size,
            @RequestParam int pageSize) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        studentDefaultService.get(lastName, gpa, size, pageSize)
                )
        );
    }

    @PostMapping(path = "add")
    public ResponseEntity<Object> addStudent(@RequestBody CreateStudentDTO dto) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        studentDefaultService.create(dto)
                )
        );
    }

    @PutMapping(path = "edit")
    public ResponseEntity<Object> editStudent(@RequestBody UpdateStudentDTO dto) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        studentDefaultService.update(dto)
                )
        );
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable Long id) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        studentDefaultService.delete(id)
                )
        );
    }
}
