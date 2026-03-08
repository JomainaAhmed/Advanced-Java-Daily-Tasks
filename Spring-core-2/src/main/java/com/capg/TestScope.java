package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestScope {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Scope1 s1 = context.getBean(Scope1.class);
        Scope1 s2 = context.getBean(Scope1.class);

        System.out.println(s1);
        System.out.println(s2);
    }
}