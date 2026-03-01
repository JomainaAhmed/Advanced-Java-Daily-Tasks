package com.OTM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FirstLevelCache {
	public static void main(String[]args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bidirection");
		EntityManager em1 = emf.createEntityManager();
		
		em1.find(Bank.class, 10); //DB
		em1.find(Bank.class, 10); //cache
		em1.find(Bank.class, 11); //DB
		
		EntityManager em2 = emf.createEntityManager();
		em2.find(Bank.class, 10); //DB
		em2.find(Bank.class, 10); //Cache
	}
	

}
