package com.capg;

import org.springframework.stereotype.Component;

@Component(value = "emp")
public class Employee {
	public void work() {
		System.out.println("working");
	}

}
