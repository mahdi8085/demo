package com.example.demo.application.student;

import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.StudentDTO;
import com.example.demo.application.student.dto.UpdateStudentDTO;
import com.example.demo.application.util.pagination.PageDTO;
import com.example.demo.domain.student.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    PageDTO<StudentDTO> get(String lastName, double gpa, int page, int pageSize);

    Student create(CreateStudentDTO dto);

    Student update(UpdateStudentDTO dto);

    void delete(Long id);
}
