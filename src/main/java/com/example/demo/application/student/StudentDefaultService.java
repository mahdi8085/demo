package com.example.demo.application.student;

import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.StudentDTO;
import com.example.demo.application.student.dto.UpdateStudentDTO;
import com.example.demo.application.student.specification.StudentCriteria;
import com.example.demo.application.student.specification.StudentSpecification;
import com.example.demo.application.util.actionresponse.SuccessResponseDTO;
import com.example.demo.application.util.pagination.PageDTO;
import com.example.demo.application.util.pagination.PaginationDTO;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentJpaRepository;
import com.example.demo.infrastructure.ApplicationMessages;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDefaultService implements UserDetailsService, StudentService{

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
    public SuccessResponseDTO create(CreateStudentDTO dto) {
        studentJpaRepository.save(CreateStudentDTO.to(dto));
        return new SuccessResponseDTO(ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public SuccessResponseDTO update(UpdateStudentDTO dto) {
        Optional<Student> student = studentJpaRepository.findById(dto.getId());
        student.map(value -> studentJpaRepository.save(UpdateStudentDTO.to(dto, value.getId()))).orElse(null);
        return new SuccessResponseDTO(ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public SuccessResponseDTO delete(Long id) {
        studentJpaRepository.deleteById(id);
        return new SuccessResponseDTO(ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentJpaRepository.findByUsername(username).orElseThrow(() -> null);
    }
}
