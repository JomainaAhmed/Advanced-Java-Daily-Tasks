package com.OTM;

	import java.util.Arrays;

	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.EntityTransaction;
	import jakarta.persistence.Persistence;

	public class BankAccountDriver {
		
		public static void main(String[] args) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("bidirection");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			Bank bank = new Bank();
			bank.setId(102);
			bank.setName("ICICI");
			
			Account acc1 = new Account();
			acc1.setId(11);
			acc1.setName("Priyaa");
			
			Account acc2 = new Account();
			acc2.setId(12);
			acc2.setName("Rashua");
			
			bank.setAccounts(Arrays.asList(acc1, acc2));
			
			acc1.setBank(bank);
			acc2.setBank(bank);
			
			et.begin();
			em.persist(bank);
			em.persist(acc1);
			em.persist(acc2);
			et.commit();
			
		}
	}