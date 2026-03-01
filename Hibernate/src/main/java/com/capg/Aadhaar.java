package com.capg;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "aadhaar")
public class Aadhaar {

	@Id
    private long aadhaarNumber;
    private String address;

    public Aadhaar() {
    }

    public Aadhaar(long aadhaarNumber, String address) {
        this.aadhaarNumber = aadhaarNumber;
        this.address = address;
    }

    public long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
