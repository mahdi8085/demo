package com.example.demo.application.student;

import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.StudentDTO;
import com.example.demo.application.student.dto.UpdateStudentDTO;
import com.example.demo.application.student.specification.StudentCriteria;
import com.example.demo.application.student.specification.StudentSpecification;
import com.example.demo.application.util.pagination.PageDTO;
import com.example.demo.application.util.pagination.PaginationDTO;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentJpaRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDefaultService implements StudentService{

    StudentJpaRepository studentJpaRepository;

    public StudentDefaultService(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public PageDTO<StudentDTO> get(String lastName, double gpa, int page, int pageSize) {
        Specification<Student> specification = Specification.where(
                new StudentSpecification(new StudentCriteria(lastName, gpa)));
        return new PageDTO<>(
                StudentDTO.fromStudents(
                        studentJpaRepository.findAll(
                                specification,
                                PaginationDTO.pageable(page, pageSize)).getContent()),
                studentJpaRepository.count(specification));
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
