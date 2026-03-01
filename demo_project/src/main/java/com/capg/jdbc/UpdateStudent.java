package com.capg.jdbc;

import java.sql.*;

	public class UpdateStudent{

	    public static void main(String[] args) {

	        String url = "jdbc:postgresql://localhost:5432/lpu";
	        String user = "postgres";
	        String password = "root";

	        try {
	            // 1. Load driver
	            Class.forName("org.postgresql.Driver");
	            System.out.println("Driver Loaded");

	            // 2. Create connection
	            Connection con = DriverManager.getConnection(url, user, password);
	            System.out.println("Connection Established");

	            // 3. Create statement
	            Statement stmt = con.createStatement();

	            // 4. Execute UPDATE query
	            stmt.executeUpdate(
	                "UPDATE student SET marks = 90 WHERE id = 11"
	            );
	            System.out.println("Record Updated");

	            // 5. Close connection
	            con.close();

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}