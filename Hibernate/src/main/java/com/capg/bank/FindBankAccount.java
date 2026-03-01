package com.capg.bank;

import jakarta.persistence.*;
import java.util.List;

public class FindBankAccount {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        EntityManager em = emf.createEntityManager();

        // Find bank by ID
        Bank bank = em.find(Bank.class, 102);

        if (bank != null) {

            System.out.println("--------------- BANK ---------------");
            System.out.println("ID: " + bank.getId());
            System.out.println("Name: " + bank.getName());
            System.out.println("Location: " + bank.getLocation());

            System.out.println("\n--------- ACCOUNT DETAILS ---------");

            List<Account> accounts = bank.getAccounts();

            for (Account acc : accounts) {
                System.out.println("Account ID: " + acc.getId());
                System.out.println("Holder Name: " + acc.getHolderName());
                System.out.println("Balance: " + acc.getBalance());
                System.out.println("----------------------");
            }

        } else {
            System.out.println("Bank not found");
        }

        em.close();
        emf.close();
    }
}
