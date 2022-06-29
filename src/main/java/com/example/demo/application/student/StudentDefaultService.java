package com.example.demo.application.student;

import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.StudentDTO;
import com.example.demo.application.student.dto.UpdateStudentDTO;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDefaultService implements StudentService{

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Override
    public List<StudentDTO> get() {
        return StudentDTO.fromStudents(studentJpaRepository.findAll());
    }

    @Override
    public Student create(CreateStudentDTO dto) {
        return studentJpaRepository.save(CreateStudentDTO.to(dto));
    }

    @Override
    public Student update(UpdateStudentDTO dto) {
        Optional<Student> student = studentJpaRepository.findById(dto.getId());
        return student.map(value -> studentJpaRepository.save(UpdateStudentDTO.to(dto, value.getId()))).orElse(null);
    }

    @Override
    public void delete(Long id) {
        studentJpaRepository.deleteById(id);
    }
}
