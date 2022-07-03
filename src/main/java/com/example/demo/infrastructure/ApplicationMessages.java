package com.example.demo.infrastructure;

public enum ApplicationMessages {

    OPERATION_COMPLETED(0, "Operation completed successfully.");

    private int index;
    private String title;

    ApplicationMessages(int index, String title) {
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
