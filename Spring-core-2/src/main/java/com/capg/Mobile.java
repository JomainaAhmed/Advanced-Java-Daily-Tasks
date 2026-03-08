package com.capg;

//single
public class Mobile {
	
	private static Mobile m;
	
	private Mobile() {};
	
	public static Mobile getMobile() {
		if(m == null) {
			m = new Mobile();
		}
		
		return m;
	}

}
