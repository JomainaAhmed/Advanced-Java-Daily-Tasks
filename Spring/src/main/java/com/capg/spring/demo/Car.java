//package com.capg.spring.demo;
//
//public class Car {
//		public void start(){
//		System.out.println("car started");
//	}
//}

package com.capg.spring.demo;

public class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }
}
