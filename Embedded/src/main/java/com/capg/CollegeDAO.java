package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Component
public class CollegeDAO {

    @Autowired
    private EntityManagerFactory emf;

    public void saveCollege(College college) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();                // Start transaction
        em.persist(college);       // Save entity
        et.commit();               // Commit

        em.close();                // Always close EM

        System.out.println("College Saved Successfully!");
    }
}