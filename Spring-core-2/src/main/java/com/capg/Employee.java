package com.capg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Employee") //DI using Setter 
public class Employee {

    private int empId;
    private String empName;
    private double salary;

    public void work() {
        System.out.println("Employee is working");
    }

	public int getEmpId() {
		return empId;
	}
	
	@Value("5001")
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	@Value("John")
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	@Value("50000")
	public void setSalary(double salary) {
		this.salary = salary;
	}
    
    
}