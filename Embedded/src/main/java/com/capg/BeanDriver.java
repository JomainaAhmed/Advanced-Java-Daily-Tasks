package com.capg;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;

	import com.capg.*;

	public class BeanDriver {

	    public static void main(String[] args) {

	        ApplicationContext context =
	                new AnnotationConfigApplicationContext(MyConfig.class);

	        EntityManagerFactory emf =
	                context.getBean(EntityManagerFactory.class);
	        
	        System.out.println(emf);
	    }
	}
