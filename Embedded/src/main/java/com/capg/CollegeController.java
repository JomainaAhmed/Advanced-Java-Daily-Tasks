package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeController {

    public static void main(String[] args) {

        ApplicationContext ac =
                new AnnotationConfigApplicationContext(MyConfig.class);

        CollegeService service =
                ac.getBean(CollegeService.class);

        service.registerCollege(new College(111, "LPU"));
    }
}