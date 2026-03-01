package com.capg.car;

	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.EntityTransaction;
	import jakarta.persistence.Persistence;

	public class DriverCar {

	    private static EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("dev");

	    private static EntityManager em =
	            emf.createEntityManager();

	    private static EntityTransaction tr =
	            em.getTransaction();

	    public static void main(String[] args) {

	        // Create Engine
	        Engine e = new Engine();
	        e.setId(102);
	        e.setCc("451CC");

	        // Create Car
	        Car c = new Car();
	        c.setId(2);
	        c.setBrand("Nexona");
	        c.setEngine(e);  // Linking engine to car

	        // Save to database
	        tr.begin();
	        em.persist(c);   // Engine auto-saved because of CascadeType.ALL
	        tr.commit();

	        System.out.println("Data Inserted Successfully!");
	    }
	}
