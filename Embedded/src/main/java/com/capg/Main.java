package com.capg;

import com.capg.Student;
import jakarta.persistence.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student s = new Student(
                "Jomaina",
                Arrays.asList("Java", "Spring")
        );

        em.persist(s);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}