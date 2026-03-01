package com.capg.bank;

import jakarta.persistence.*;
import java.util.*;

public class DriverBank {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create Bank
        Bank bank = new Bank(101, "SBI", "Mohali");

        // Create Accounts
        Account a1 = new Account(12, "Akram", 150.00);
        Account a2 = new Account(13, "Raju", 50.00);

        // Set relationship (VERY IMPORTANT)
        a1.setBank(bank);
        a2.setBank(bank);

        List<Account> accountList = new ArrayList<>();
        accountList.add(a1);
        accountList.add(a2);

        bank.setAccounts(accountList);

        // Persist only Bank (cascade saves accounts)
        em.persist(bank);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Data Saved Successfully");
    }
}
