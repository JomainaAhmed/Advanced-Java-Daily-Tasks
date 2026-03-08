package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Component
public class StudentDAO {

    @Autowired
    private EntityManagerFactory emf;

    public void save(Student student) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();
        em.close();
    }
}