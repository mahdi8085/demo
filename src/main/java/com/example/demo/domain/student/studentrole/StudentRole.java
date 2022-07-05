package com.example.demo.domain.student.studentrole;

import com.example.demo.domain.student.studentrole.studentauthority.StudentAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_role")
public class StudentRole {

    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    private StudentRoleType studentRoleType;

    @CollectionTable(name = "student_role_authority", joinColumns = @JoinColumn(name = "student_role_id"))
    private Set<StudentAuthority> studentAuthorities = new HashSet<>();

    public StudentRole() {}

    public StudentRole(long id, StudentRoleType studentRoleType, Set<StudentAuthority> studentAuthorities) {
        this.id = id;
        this.studentRoleType = studentRoleType;
        this.studentAuthorities = studentAuthorities;
    }

    public long getId() {
        return id;
    }

    public StudentRoleType getStudentRoleType() {
        return studentRoleType;
    }

    public Set<StudentAuthority> getStudentAuthorities() {
        return studentAuthorities;
    }
}
