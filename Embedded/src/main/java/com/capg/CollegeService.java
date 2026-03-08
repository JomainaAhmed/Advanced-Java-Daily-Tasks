package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollegeService {

    @Autowired
    private CollegeDAO dao;

    public void registerCollege(College college) {
        dao.saveCollege(college);
    }
}