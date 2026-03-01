package com.capg;

public class TestCalculator {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		System.out.println("Addition: " + calc.add(10, 5));
		System.out.println("Multiplication: " + calc.multi(10, 5));
		System.out.println("Subtraction: " + calc.sub(10, 5));
	}
}