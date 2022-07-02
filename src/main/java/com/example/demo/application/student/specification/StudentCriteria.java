package com.example.demo.application.student.specification;

public class StudentCriteria {

    private String lastName;
    private double gpa;

    public StudentCriteria(String lastName, double gpa) {
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }
}
