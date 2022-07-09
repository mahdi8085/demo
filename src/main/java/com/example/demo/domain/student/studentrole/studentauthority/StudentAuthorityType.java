package com.example.demo.domain.student.studentrole.studentauthority;

public enum StudentAuthorityType {

    AUTHORITY_CLIENT("AUTHORITY_CLIENT"),
    AUTHORITY_SUPER_ADMIN("AUTHORITY_SUPER_ADMIN"),
    AUTHORITY_ADMIN_GET("AUTHORITY_ADMIN_GET"),
    AUTHORITY_ADMIN_CREATE("AUTHORITY_ADMIN_CREATE"),
    AUTHORITY_ADMIN_EDIT("AUTHORITY_ADMIN_EDIT"),
    AUTHORITY_ADMIN_DELETE("AUTHORITY_ADMIN_DELETE");

    private String title;

    StudentAuthorityType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static StudentAuthorityType getByStudentAuthorityTitle(String studentAuthorityTypeTitle){
        for(StudentAuthorityType studentAuthorityType : StudentAuthorityType.values()){
            if(studentAuthorityType.getTitle().equals(studentAuthorityTypeTitle))
                return studentAuthorityType;
        }
        throw new RuntimeException("StudentAuthorityType title does not exist in StudentAuthorityType collection.");
    }
}
