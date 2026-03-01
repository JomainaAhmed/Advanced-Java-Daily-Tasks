package com.capg.employee;

import jakarta.persistence.*;
import java.util.*;

public class DriverCompanyEmployee {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Company company = new Company(1, "TCS", "Mumbai");

        Employee e1 = new Employee(101, "Akram", 50000);
        Employee e2 = new Employee(102, "Raju", 60000);

        // Set relationship
        e1.setCompany(company);
        e2.setCompany(company);

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        company.setEmployees(list);

        // Persist only company (cascade saves employees)
        em.persist(company);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Saved Successfully");
    }
}