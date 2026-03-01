package com.OTM;

	import jakarta.persistence.*;
	import java.util.List;

	public class BankAccountCrudImpl implements BankAccountCRUD {

	    private EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("bidirection");

	    // =========================
	    // Save Bank
	    // =========================
	    @Override
	    public void saveBank(Bank bank) {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        et.begin();
	        em.persist(bank);
	        et.commit();

	        em.close();
	        System.out.println("Bank saved successfully");
	    }

	    // =========================
	    // Update Bank Name by ID
	    // =========================
	    @Override
	    public void updateBank(int id) {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        Bank bank = em.find(Bank.class, id);

	        if (bank != null) {
	            et.begin();
	            bank.setName(bank.getName() + "_Updated");
	            et.commit();
	            System.out.println("Bank updated successfully");
	        } else {
	            System.out.println("Bank not found");
	        }

	        em.close();
	    }
	    // =========================
	    // Find Bank By ID
	    // =========================
	    @Override
	    public Bank findBankByID(int id) {

	        EntityManager em = emf.createEntityManager();
	        Bank bank = em.find(Bank.class, id);
	        em.close();
	        return bank;
	    }

	    // =========================
	    // Find Bank By Name
	    // =========================
	    @Override
	    public Bank findBankByName(String name) {

	        EntityManager em = emf.createEntityManager();

	        TypedQuery<Bank> query = em.createQuery(
	                "SELECT b FROM Bank b WHERE b.name = :name",
	                Bank.class);

	        query.setParameter("name", name);

	        Bank bank = null;
	        try {
	            bank = query.getSingleResult();
	        } catch (NoResultException e) {
	            System.out.println("Bank not found");
	        }

	        em.close();
	        return bank;
	    }

	    // =========================
	    // Assign Single Account
	    // =========================
	    @Override
	    public void assignAccountsToBank(int bankId, Account newAccount) {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        Bank bank = em.find(Bank.class, bankId);

	        if (bank != null) {
	            et.begin();

	            newAccount.setBank(bank);
	            bank.getAccounts().add(newAccount);

	            em.persist(newAccount);

	            et.commit();
	            System.out.println("Account assigned to bank");
	        } else {
	            System.out.println("Bank not found");
	        }

	        em.close();
	    }

	    // =========================
	    // Assign Multiple Accounts
	    // =========================
	    @Override
	    public void assignAccountsToBank(int bankId, List<Account> accounts) {

	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        Bank bank = em.find(Bank.class, bankId);

	        if (bank != null) {
	            et.begin();

	            for (Account acc : accounts) {
	                acc.setBank(bank);
	                bank.getAccounts().add(acc);
	                em.persist(acc);
	            }

	            et.commit();
	            System.out.println("Multiple accounts assigned");
	        } else {
	            System.out.println("Bank not found");
	        }

	        em.close();
	    }
	    // =========================
	    // Find All Accounts in Bank
	    // =========================
	    @Override
	    public List<Account> findAllAccountsInBank(int bankId) {

	        EntityManager em = emf.createEntityManager();

	        TypedQuery<Account> query = em.createQuery(
	                "SELECT a FROM Account a WHERE a.bank.id = :bankId",
	                Account.class);

	        query.setParameter("bankId", bankId);

	        List<Account> accounts = query.getResultList();

	        em.close();
	        return accounts;
	    }
	}