package com.capg.constructordi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myEmployee") //DI using Constructor
public class Employee {

    private int empId;
    private String empName;
    private double salary;

    public void work() {
        System.out.println("Employee is working");
    }

    //public Employee(); //No arg constructor
    
    public Employee(@Value ("102") int empId, @Value ("Jomaina") String empName, @Value ("10") double salary) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
    
	public int getEmpId() {
		return empId;
	}
	

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
    
}