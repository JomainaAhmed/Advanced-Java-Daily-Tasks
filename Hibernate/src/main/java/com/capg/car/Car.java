package com.capg.car;

	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToOne;
	import jakarta.persistence.CascadeType;
	import jakarta.persistence.JoinColumn;

	@Entity
	public class Car {

	    @Id
	    private int id;

	    private String brand;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "engine_id")   // Foreign Key
	    private Engine engine;

	    // Getters and Setters

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getBrand() {
	        return brand;
	    }

	    public void setBrand(String brand) {
	        this.brand = brand;
	    }

	    public Engine getEngine() {
	        return engine;
	    }

	    public void setEngine(Engine engine) {
	        this.engine = engine;
	    }
	}

