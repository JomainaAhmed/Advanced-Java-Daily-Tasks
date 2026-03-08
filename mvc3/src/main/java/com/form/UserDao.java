package com.form;

import jakarta.persistence.*;

public class UserDao {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dev");

    public void saveUser(Users user) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(user);
        tx.commit();

        em.close();
    }

    public Users getUserById(int id) {

        EntityManager em = emf.createEntityManager();
        Users user = em.find(Users.class, id);
        em.close();

        return user;
    }
}