package com.example.demo.domain.student.studentrole.studentauthority;

public enum StudentAuthorityType {

    AUTHORITY_CLIENT(0, "AUTHORITY_CLIENT"),
    AUTHORITY_SUPER_ADMIN(1, "AUTHORITY_SUPER_ADMIN"),
    AUTHORITY_ADMIN_GET(2, "AUTHORITY_ADMIN_GET"),
    AUTHORITY_ADMIN_CREATE(3, "AUTHORITY_ADMIN_CREATE"),
    AUTHORITY_ADMIN_EDIT(4, "AUTHORITY_ADMIN_EDIT"),
    AUTHORITY_ADMIN_DELETE(5, "AUTHORITY_ADMIN_DELETE");

    private int index;
    private String title;

    StudentAuthorityType(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }
}
