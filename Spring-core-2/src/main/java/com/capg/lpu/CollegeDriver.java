package com.capg.lpu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeDriver {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        
//        Student s = context.getBean("myStudent", Student.class);
//        System.out.println(s.getId());
//        System.out.println(s.getName());
//        s.study();

        College c = context.getBean("College", College.class);
        System.out.println(c.getId());
        System.out.println(c.getName());
        System.out.println(c.getLocation());
        System.out.println(c.getDepartment());
    }
}