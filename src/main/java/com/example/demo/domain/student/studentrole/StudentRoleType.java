package com.example.demo.domain.student.studentrole;

public enum StudentRoleType {

    ROLE_ADMIN(0, "ROLE_ADMIN"),
    ROLE_CLIENT(1, "ROLE_CLIENT");

    private int index;
    private String title;

    StudentRoleType(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public static StudentRoleType getByStudentRoleTypeTitle(String studentRoleTypeTitle){
        for(StudentRoleType studentRoleType : StudentRoleType.values()){
            if(studentRoleType.getTitle().equals(studentRoleTypeTitle))
                return studentRoleType;
        }
        throw new RuntimeException("StudentRoleType title does not exist in StudentRoleType collection.");
    }
}
