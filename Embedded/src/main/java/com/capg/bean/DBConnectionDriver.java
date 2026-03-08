package com.capg.bean;

public class DBConnectionDriver {

    public static void main(String[] args) {

        DBConnection db = new DBConnection();

        db.init();        // manually call lifecycle method
        db.fetchData();   // use it
        db.closeEMF();    // manually destroy
    }
}