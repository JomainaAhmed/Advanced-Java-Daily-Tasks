package com.capg.jdbc;

import java.sql.*;

public class SaveStudent {
	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/lpu";
		String user = "postgres";
		String password = "root";
		//1. Load driver
		try {
		Class.forName("org.postgresql.Driver");
		System.out.println("Loaded");
		//2. Create connection
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
		//3. Create Statement
		Statement stm=con.createStatement();
		//4. Insert into Student 
		stm.execute("insert into student values(12,'xyza', 8887, 35.5)");
		System.out.println("inserted");
		//5. Close Connection
		con.close();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
}
