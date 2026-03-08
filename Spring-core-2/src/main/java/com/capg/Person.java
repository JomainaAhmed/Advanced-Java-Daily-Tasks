package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("person")
//public class Person {
//	
//	@Value("108")
//	private int id;
//	@Value("raju")
//	private String name;
//	//@Autowired //DI for object
//	private Adhaar card; //field DI
//	
//	//@Autowired
//	public Person(Adhaar card) {
//		this.card = card;
//	}
//
//	//@Autowired //setter DI 
//	public void setCard(Adhaar card) {
//		this.card = card;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Adhaar getCard() {
//		return card;
//	}	
//
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private Fruit fruit;

    @Autowired
    public Person(@Qualifier("mangoBean") Fruit fruit) {
        this.fruit = fruit;
    }

    public void eat() {
        fruit.taste();
    }
}
