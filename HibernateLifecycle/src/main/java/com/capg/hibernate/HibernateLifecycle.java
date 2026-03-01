package com.capg.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HibernateLifecycle {

            public static void main(String[] args) {

                EntityManagerFactory emf =
                        Persistence.createEntityManagerFactory("dev");

                EntityManager em = emf.createEntityManager();
                EntityTransaction et = em.getTransaction();

                // =========================
                // TRANSIENT
                // =========================
                Student student = new Student();
                student.setId(101);
                student.setName("Ali");

                System.out.println("Transient: " + student.getName());

                // =========================
                // MANAGED (PERSIST)
                // =========================
                et.begin();
                em.persist(student);   // Now Managed
                et.commit();

                System.out.println("After persist (Managed)");

                // =========================
                // UPDATE WHILE MANAGED
                // =========================
                et.begin();

                student.setName("Ahmed");   // Hibernate tracks automatically

                et.commit();   // Auto UPDATE query generated

                System.out.println("Updated while Managed");

                // =========================
                // DETACHED
                // =========================
                em.close();   // student becomes Detached

                student.setName("Rahman");   // NOT saved in DB

                System.out.println("Detached modified (Not saved)");

                // =========================
                // MERGE (Reattach)
                // =========================
                EntityManager em2 = emf.createEntityManager();
                EntityTransaction et2 = em2.getTransaction();

                et2.begin();

                Student managedAgain = em2.merge(student);  // Detached → Managed

                et2.commit();

                System.out.println("Merged back");

                // =========================
                // REMOVE
                // =========================
                et2.begin();

                em2.remove(managedAgain);

                et2.commit();

                em2.close();
                emf.close();

                System.out.println("Entity Removed");
            }
        }