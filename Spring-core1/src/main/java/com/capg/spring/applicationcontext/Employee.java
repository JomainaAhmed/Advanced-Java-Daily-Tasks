//package com.capg.spring.applicationcontext;
//
//import com.capg.spring.springcore.LapTop;
//
//public class Employee {
//
////	public void work() {
////		System.out.println();
////	}
////
////}
////
//	private int id;
//	private String name;
//	private LapTop myLap;
//	
//	public void work() {
//		System.out.println("Work");
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//    public LapTop getLapTop() {
//        return lapTop;
//    }
//
//	public void setLapTop(LapTop lapTop) {
//        this.lapTop = lapTop;
//    }
//
//}
package com.capg.spring.applicationcontext;

import com.capg.spring.springcore.LapTop;

public class Employee {

    private int id;
    private String name;
    private LapTop laptop;   // ✅ correct name

    public void work() {
        System.out.println("Employee working...");
        laptop.start();   // call method from LapTop
    }
    

    public Employee(int id, String name, LapTop laptop) {
		this.id = id;
		this.name = name;
		this.laptop = laptop;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LapTop getLaptop() {   // ✅ matches variable
        return laptop;
    }

    public void setLaptop(LapTop laptop) {   // ✅ matches XML
        this.laptop = laptop;
    }
}
