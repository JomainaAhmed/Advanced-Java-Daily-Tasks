package com.capg.bean;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BeanLifeCycle {

    public BeanLifeCycle() {
        System.out.println("Instantiation of Bean");
    }

    @PostConstruct
    public void init() {
        System.out.println("Initialization of Bean");
    }

    public void useBean() {
        System.out.println("Bean is in use");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");
    }
}