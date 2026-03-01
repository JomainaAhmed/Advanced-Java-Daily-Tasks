package com.capg.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.Calculator;

public class TestCalculator {

    static Calculator c;

    @BeforeAll
    public static void CreateObject() {
        c = new Calculator();
        System.out.println("Object created");
    }
    
    @Test
    public void testAdd() {
        Assertions.assertEquals(5, c.add(2, 3));
    }

    @Test
    public void testMulti() {
        int res = c.multi(2, 2);
        Assertions.assertEquals(4, res);
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("close DB conn");
    }
}