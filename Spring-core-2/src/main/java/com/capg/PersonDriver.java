package com.capg;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class PersonDriver {
//	
//	public static void main(String[]args) {
//
//	        ApplicationContext context =
//	                new AnnotationConfigApplicationContext(MyConfig.class);
//	        
//
////	        Student s = context.getBean("myStudent", Student.class);
////	        System.out.println(s.getId());
////	        System.out.println(s.getName());
////	        s.study();
//
//	        Person p = context.getBean("person", Person.class);
//	        System.out.println(p.getId());
//	        System.out.println(p.getName());
//	        System.out.println(p.getCard());
//	  }
//}
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonDriver {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean(Person.class);
        person.eat();
    }
}