package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	public static void main(String[]args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Student s = context.getBean("myStudent", Student.class);
		System.out.println(s.getId());
		System.out.println(s.getName());
		s.study();
	}

}
