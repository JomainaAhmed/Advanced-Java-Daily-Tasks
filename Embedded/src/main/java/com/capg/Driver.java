package com.capg;

import com.capg.*;
import jakarta.persistence.*;

public class Driver {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address address = new Address("Pune", "Maharashtra", "411001");
        Employee emp = new Employee("Jomaina", address);

        em.persist(emp);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}