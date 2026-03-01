package com.capg.bank;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    private int id;

    private String holderName;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    // No-arg constructor
    public Account() {}

    // Parameterized constructor
    public Account(int id, String holderName, double balance) {
        this.id = id;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
