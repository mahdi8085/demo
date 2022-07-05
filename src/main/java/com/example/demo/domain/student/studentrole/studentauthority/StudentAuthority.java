package com.example.demo.domain.student.studentrole.studentauthority;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class StudentAuthority {

    @Enumerated(EnumType.STRING)
    private StudentAuthorityType studentAuthorityType;

    public StudentAuthority() {}

    public StudentAuthority(StudentAuthorityType studentAuthorityType) {
        this.studentAuthorityType = studentAuthorityType;
    }

    public StudentAuthorityType getStudentAuthorityType() {
        return studentAuthorityType;
    }
}
