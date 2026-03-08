package com.capg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Course course() {
        return new Course();
    }

    @Bean
    public StudentBean student() {
        return new StudentBean();   // dependency injected manually
    }
}