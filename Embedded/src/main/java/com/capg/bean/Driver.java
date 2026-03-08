package com.capg.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.capg.bean");

        BeanLifeCycle bean =
                context.getBean(BeanLifeCycle.class);

        bean.useBean();

        context.close();
    }
}