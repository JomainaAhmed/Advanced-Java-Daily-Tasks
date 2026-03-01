package com.capg.car;

	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;

	@Entity
	public class Engine {

	    @Id
	    private int id;

	    private String cc;

	    // Getter
	    public int getId() {
	        return id;
	    }

	    // Setter
	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getCc() {
	        return cc;
	    }

	    public void setCc(String cc) {
	        this.cc = cc;
	    }
	}

