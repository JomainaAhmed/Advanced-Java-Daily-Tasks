//package com.capg.spring.springcore;
//
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.context.ApplicationContext;
//
//
//public class Driver {
//	public static void main(String[]args) {
//		BeanFactory b;
//		ApplicationContext context = ClassPathXmlApplicationContext();
//		
//		System.out.println("main start");
//		Student student = new Student();
//		student.study();
//		System.out.println("main end");
//	}
//
//}
//package com.capg.spring.springcore;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class Driver {
//    public static void main(String[] args) {
//
//        System.out.println("main start");
//
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("beans.xml");
//
//        Student student = context.getBean("student", Student.class);
//        student.study();
//
//        System.out.println("main end");
//    }
//}
package com.capg.spring.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import com.capg.spring.applicationcontext.Employee;

public class Driver {
	public static void main(String[] args) {

		// Bean factory b;
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		//creating container
		Employee e=(Employee)context.getBean("emp");
		System.out.println(e.getId());//101
		System.out.println(e.getName());//More
		e.work(); //If spring container is making the object, then it is bean

		LapTop laptop = e.getLaptop();
		laptop.start();
		
//		System.out.println("main start");
//		// Student student = new Student();
//		Student student = (Student)context.getBean("myStudent");//IOC
//		student.study();
//		Employee e = (Employee)context.getBean("emp");//IOC
//		e.work();
//		System.out.println("main end");

//        try (ClassPathXmlApplicationContext context =
//                     new ClassPathXmlApplicationContext("beans.xml")) {
//
//            Student student = context.getBean("student", Student.class);
//            student.study();
//        }
//
//        System.out.println("main end");
	}
}
