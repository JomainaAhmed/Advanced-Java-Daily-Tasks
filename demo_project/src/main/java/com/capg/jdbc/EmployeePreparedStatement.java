package com.capg.jdbc;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class EmployeePreparedStatement {

	    // DB details
	    private static String url = "jdbc:postgresql://localhost:5432/lpu";
	    private static String user = "postgres";
	    private static String password = "root";

	    public static void main(String[] args) {

	        Connection con = null;

	        try {
	            // 1. Load Driver
	            Class.forName("org.postgresql.Driver");
	            System.out.println("Driver Loaded");

	            // 2. Create Connection
	            con = DriverManager.getConnection(url, user, password);
	            System.out.println("Connection Established");

	            // 3. INSERT using PreparedStatement
	            String insertSQL = "INSERT INTO EMPLOYEE_1 VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement psInsert = con.prepareStatement(insertSQL);

	            psInsert.setInt(1, 1);
	            psInsert.setString(2, "XYZ");
	            psInsert.setString(3, "345676");
	            psInsert.setDouble(4, 10000.00);
	            psInsert.setString(5, "xyz@mail.com");

	            psInsert.executeUpdate();
	            System.out.println("Employee Inserted");

	            // 4. FIND employee using PreparedStatement
	            String selectSQL = "SELECT * FROM EMPLOYEE_1 WHERE id = ?";
	            PreparedStatement psSelect = con.prepareStatement(selectSQL);

	            psSelect.setInt(1, 1);
	            ResultSet rs = psSelect.executeQuery();

	            if (rs.next()) {
	                System.out.println("Employee Found:");
	                System.out.println("ID     : " + rs.getInt(1));
	                System.out.println("Name   : " + rs.getString(2));
	                System.out.println("Phone  : " + rs.getString(3));
	                System.out.println("Salary : " + rs.getDouble(4));
	                System.out.println("Email  : " + rs.getString(5));
	            } else {
	                System.out.println("Employee Not Found");
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // 5. Close Connection
	            try {
	                if (con != null)
	                    con.close();
	                System.out.println("Connection Closed");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}