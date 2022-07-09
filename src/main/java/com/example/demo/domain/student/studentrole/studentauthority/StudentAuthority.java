package com.example.demo.domain.student.studentrole.studentauthority;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(studentAuthorityType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StudentAuthority))
            return false;
        StudentAuthority that = (StudentAuthority) obj;
        return studentAuthorityType != null && studentAuthorityType.equals(that.studentAuthorityType);
    }

    @Override
    public String toString() {
        return "UserAuthority{" +
                "authorityType='" + studentAuthorityType + '\'' +
                '}';
    }
}
