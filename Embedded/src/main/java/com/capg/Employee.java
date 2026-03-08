package com.capg;

	import jakarta.persistence.*;

	@Entity
	public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;

	    @Embedded
	    private Address address;

	    public Employee() {}

	    public Employee(String name, Address address) {
	        this.name = name;
	        this.address = address;
	    }

	    // Getters and Setters
	    public int getId() { return id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public Address getAddress() { return address; }
	    public void setAddress(Address address) { this.address = address; }
}
