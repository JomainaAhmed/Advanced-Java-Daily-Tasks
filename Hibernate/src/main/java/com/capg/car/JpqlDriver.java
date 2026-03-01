package com.capg.car;

import jakarta.persistence.*;

public class JpqlDriver {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dev");

    private static EntityManager em =
            emf.createEntityManager();

    private static EntityTransaction tr =
            em.getTransaction();

    public static void main(String[] args) {

        Query query = em.createQuery(
                "SELECT e FROM Engine e WHERE e.cc = :cc");

        query.setParameter("cc", "450CC");

        Engine engine = (Engine) query.getSingleResult();

        System.out.println(engine.getId() + " " + engine.getCc());
    }
}

	    		
	    		