package com.capg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component(value = "myStudent") //Field DI
public class Student {
//	public void study() {
//		System.out.println("sleeping");
//	}

	@Value("101")
	private int id;
	@Value("XYZ")
	private String name;
	
	public void study() {
	System.out.println("sleeping");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
