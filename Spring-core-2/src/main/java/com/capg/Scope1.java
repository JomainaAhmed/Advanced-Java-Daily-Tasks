package com.capg;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")  // change to "singleton" to test
public class Scope1 {

   public Scope1() {
        System.out.println("Scope object created: " + this);
    }
}