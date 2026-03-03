//package com.capg.spring.demo;
//
//public class Bike {
//		public void start(){
//		System.out.println("bike started");
//	}
//}
//

package com.capg.spring.demo;

public class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike started");
    }
}

