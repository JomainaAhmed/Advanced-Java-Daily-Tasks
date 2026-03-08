package com.capg.bean;

import com.capg.College;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
//import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;



public class DBConnection {
	
	@Autowired
	EntityManagerFactory emf;
	
	public DBConnection() {
		System.out.println("Bean object created");
	}
	
	@PostConstruct
	public void init() {
		emf=Persistence.createEntityManagerFactory("dev");
		System.out.println("use bean object phase 3");
	}
	
	public void fetchData() {
		EntityManager em=emf.createEntityManager();
		College c = em.find(College.class, 111);
		System.out.println(c.getName());
		System.out.println("use bean object phase 3");
	}
	
	@PreDestroy
	public void closeEMF() {
		emf.close();
		System.out.println("pre destroy phase 4");
	}

}
