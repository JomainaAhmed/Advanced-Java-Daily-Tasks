//package com.lpu;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class EmployeeDAO {
//
//    EntityManagerFactory emf =
//            Persistence.createEntityManagerFactory("dev");
//
//    public void save(Employee emp) {
//
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        tx.begin();
//        em.persist(emp);
//        tx.commit();
//
//        em.close();
//    }
//    
//    public List<Employee> findAll() {
//
//        EntityManager em = emf.createEntityManager();
//
//        List<Employee> list =
//                em.createQuery("from Employee", Employee.class)
//                  .getResultList();
//
//        em.close();
//        return list;
//    }
//}
package com.lpu;

import java.util.List;
import jakarta.persistence.*;

public class EmployeeDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dev");

    public void save(Employee emp) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(emp);
        tx.commit();

        em.close();
    }

    public List<Employee> findAll() {

        EntityManager em = emf.createEntityManager();
        List<Employee> list =
                em.createQuery("from Employee", Employee.class)
                  .getResultList();
        em.close();
        return list;
    }

    public void delete(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            em.remove(emp);
        }
        tx.commit();
        em.close();
    }

    public Employee findById(int id) {
        EntityManager em = emf.createEntityManager();
        Employee emp = em.find(Employee.class, id);
        em.close();
        return emp;
    }

    public void update(Employee emp) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(emp);   // merge keeps same ID
        tx.commit();

        em.close();
    }
}