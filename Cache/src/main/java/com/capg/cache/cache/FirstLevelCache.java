package com.capg.cache.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        // -------- First Fetch --------
        Student student1 = session.get(Student.class, 12424);
        System.out.println("First Fetch: " + student1);

        // -------- Second Fetch (Same Session) --------
        Student student2 = session.get(Student.class, 12424);
        System.out.println("Second Fetch: " + student2);

        session.close();
        factory.close();
    }
}