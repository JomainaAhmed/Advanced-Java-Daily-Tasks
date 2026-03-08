package com.capg;

import com.capg.Driver1;

public class Driver2 {
	
	public static void main(String[]args) {
		Mobile m1 = Mobile.getMobile();
		Mobile m2 = Mobile.getMobile();
		System.out.println(m1);
		System.out.println(m2);
		Driver1.mobileTest();

	}

}
