package com.capg.employee;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    private int id;

    private String name;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Employee() {}

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) {
        this.company = company;
    }
}
