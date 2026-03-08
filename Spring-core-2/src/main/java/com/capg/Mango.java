package com.capg;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mangoBean")
@Primary
public class Mango implements Fruit {

    @Override
    public void taste() {
        System.out.println("Mango is juicy");
    }
}