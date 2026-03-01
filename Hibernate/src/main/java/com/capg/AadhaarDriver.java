package com.capg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AadhaarDriver {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Aadhaar aadhaar = new Aadhaar(123456789014L, "Mumbai");
        Person person = new Person(1, "Jomaina", 22, aadhaar);

        em.persist(person);   // Aadhaar saved automatically

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Person and Aadhaar saved successfully");
    }
}

