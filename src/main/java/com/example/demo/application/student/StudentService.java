package com.example.demo.application.student;

import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.StudentDTO;
import com.example.demo.application.student.dto.UpdateStudentDTO;
import com.example.demo.domain.student.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<StudentDTO> get();

    Student create(CreateStudentDTO dto);

    Student update(UpdateStudentDTO dto);

    void delete(Long id);
}
