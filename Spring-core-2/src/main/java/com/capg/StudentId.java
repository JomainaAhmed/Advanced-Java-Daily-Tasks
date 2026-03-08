package com.capg;

import org.springframework.stereotype.Component;

@Component
public class StudentId {

    private int id = 101;

    public int getId() {
        return id;
    }
}