package com.example.demo.application.student;

import com.example.demo.application.student.dto.CreateStudentDTO;
import com.example.demo.application.student.dto.SignInDTO;
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
import com.example.demo.infrastructure.security.JwtTokenUtil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDefaultService implements UserDetailsService, StudentService{

    private final StudentJpaRepository studentJpaRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public StudentDefaultService(StudentJpaRepository studentJpaRepository,
                                 AuthenticationManager authenticationManager,
                                 PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.studentJpaRepository = studentJpaRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
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
        studentJpaRepository.save(CreateStudentDTO.to(dto, passwordEncoder));
        return new SuccessResponseDTO(ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public StudentDTO signIn(SignInDTO dto) {
        Optional<Student> student = studentJpaRepository.findByUsername(dto.getUsername());
        if (student.isPresent()) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
            return StudentDTO.createDtoFromStudent(student.get(), jwtTokenUtil.generateAccessToken(student.get()));
        }
        return null;
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
