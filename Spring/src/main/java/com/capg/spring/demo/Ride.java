package com.capg.spring.demo;

public class Ride {
	Vehicle v;
	public void startRide(){
	v.start();
}
	public static void main(String[]args){
		Ride ride = new Ride();
	ride.v=new Car();//UC
	ride.startRide();
	ride.v=new Bike();//UC
	ride.startRide();
	
	}

}


