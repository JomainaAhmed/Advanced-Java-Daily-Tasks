package com.capg.employee;

	import jakarta.persistence.*;
	import java.util.List;

	public class FetchCompany {

	    public static void main(String[] args) {

	        EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("dev");

	        EntityManager em = emf.createEntityManager();

	        Company company = em.find(Company.class, 1);

	        if (company != null) {

	            System.out.println("-------- COMPANY DETAILS --------");
	            System.out.println("ID: " + company.getId());
	            System.out.println("Name: " + company.getName());
	            System.out.println("Location: " + company.getLocation());

	            System.out.println("\n-------- EMPLOYEE DETAILS --------");

	            List<Employee> employees = company.getEmployees();

	            for (Employee emp : employees) {
	                System.out.println("Employee ID: " + emp.getId());
	                System.out.println("Name: " + emp.getName());
	                System.out.println("Salary: " + emp.getSalary());
	                System.out.println("---------------------------");
	            }

	        } else {
	            System.out.println("Company not found");
	        }

	        em.close();
	        emf.close();
	  }
}