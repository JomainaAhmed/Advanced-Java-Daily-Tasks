package com.capg;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Apple implements Fruit {

	    @Override
	    public void taste() {
	        System.out.println("Apple is sweet");
	    }
	}
