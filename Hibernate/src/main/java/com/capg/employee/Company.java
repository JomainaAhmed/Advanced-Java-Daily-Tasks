package com.capg.employee;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    private int id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Company() {}

    public Company(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
