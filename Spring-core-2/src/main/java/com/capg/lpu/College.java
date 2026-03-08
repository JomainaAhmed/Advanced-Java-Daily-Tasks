package com.capg.lpu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("College")
public class College {
	@Value("123")
	private int id;
	private String name;
	private String location;
	private String department;
	
	//public College();
	
	public College(@Value("Jomaina") String name, @Value("Phagwara") String location) {
		this.name = name;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	@Value("Comp")
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
