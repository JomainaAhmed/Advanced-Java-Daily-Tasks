package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("student")
public class Student {

    private StudentId studentId;

    @Autowired // Constructor Injection
    public Student(StudentId studentId) {
        this.studentId = studentId;
    }

    public void display() {
        System.out.println("Student ID: " + studentId.getId());
    }
}