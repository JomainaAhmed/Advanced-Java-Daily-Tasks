package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeDriver {
	public static void main(String[]args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Employee e = context.getBean("emp", Employee.class);
		e.work();
	}

}
