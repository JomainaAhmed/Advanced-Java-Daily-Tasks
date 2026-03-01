////package com.capg.jdbc;
////
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.SQLException;
////import java.sql.Statement;
////
////public class Employee {
////	public static void main(String[] args) {
////	
////	private static String url = "jdbc:postgresql://localhost:5432";
////	private static String user = "postgres";
////	private static String password = "root";
////	private static Connection con;
////	
////	
////     static {
////    	    try {
////        	//1st step
////        Class.forName("org.postgresql.Driver");//fully qualified class name
////        System.out.println("Driver Loaded");
////
////        // 2. Create connection
////        con = DriverManager.getConnection(url, user, password);
////        System.out.println("Connection Established");
////    	    }catch (ClassNotFoundException | SQLException e) {
////    	    		//TODO: handle Exception
////    	    }
////
////	}
////	
////    public static void saveEmployee() throws SQLException{
////    	Statement stm=con.createStatement();
////    	stm.execute("insert into EMPLOYEE_1 values(1, 'xyz', '345678', '10000.00', '@mail')");	
////	}
////    
////    public static void closeCon() throws SQLException{
////    	con.close();
////    }
////
////}
//package com.capg.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
//
//
//public class Employee {
//
//    private static String url = "jdbc:postgresql://localhost:5432/lpu";
//    private static String user = "postgres";
//    private static String password = "root";
//    private static Connection con;
//
//    static {
//        try {
//            // 1. Load Driver
//            Class.forName("org.postgresql.Driver");
//            System.out.println("Driver Loaded");
//
//            // 2. Create Connection
//            con = DriverManager.getConnection(url, user, password);
//            System.out.println("Connection Established");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            saveEmployee();
//            closeCon();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void saveEmployee() throws SQLException {
//        Statement stm = con.createStatement();
//        stm.executeUpdate(
//            "INSERT INTO EMPLOYEE_1 VALUES (2, 'xyzE', '3456785', 100001.00, 'xyz1@mail.com')"
//        );
//        System.out.println("Employee Inserted");
//    }
//    
//    public static void findEmployee(int id) throws SQLException {
//        Statement stm = con.createStatement();
//        ResultSet rs = stm.executeQuery(
//            "SELECT * FROM EMPLOYEE_1 WHERE id = " + id
//        );
//
//        if (rs.next()) {
//            System.out.println("Employee Found:");
//            System.out.println("ID     : " + rs.getInt(1));
//            System.out.println("Name   : " + rs.getString(2));
//            System.out.println("Phone  : " + rs.getString(3));
//            System.out.println("Salary : " + rs.getDouble(4));
//            System.out.println("Email  : " + rs.getString(5));
//        } else {
//            System.out.println("Employee Not Found");
//        }
//    }
//
//    public static void closeCon() throws SQLException {
//        con.close();
//        System.out.println("Connection Closed");
//    }
//}
package com.capg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class EmployeeDAO {

    // Database details
    private static String url = "jdbc:postgresql://localhost:5432/lpu";
    private static String user = "postgres";
    private static String password = "root";

    // Connection object
    private static Connection con;

    // Static block to load driver and establish connection
    static {
        try {
            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Successfully");

            // Establish Connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            saveEmployee();      // Insert employee
            findEmployee(2);     // Search employee by ID
            closeCon();          // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert employee record
    public static void saveEmployee() throws SQLException {

        Statement stm = con.createStatement();

        String insertQuery =
                "INSERT INTO EMPLOYEE_1 VALUES (2, 'xyzE', '3456785', 100001.00, 'xyz1@mail.com')";

        int rows = stm.executeUpdate(insertQuery);

        if (rows > 0) {
            System.out.println("Employee Inserted Successfully");
        }

        stm.close(); // Close statement
    }

    // Method to find employee by ID
    public static void findEmployee(int id) throws SQLException {

        Statement stm = con.createStatement();

        String selectQuery =
                "SELECT * FROM EMPLOYEE_1 WHERE id = " + id;

        ResultSet rs = stm.executeQuery(selectQuery);

        if (rs.next()) {
            System.out.println("\nEmployee Found:");
            System.out.println("ID     : " + rs.getInt(1));
            System.out.println("Name   : " + rs.getString(2));
            System.out.println("Phone  : " + rs.getString(3));
            System.out.println("Salary : " + rs.getDouble(4));
            System.out.println("Email  : " + rs.getString(5));
        } else {
            System.out.println("Employee Not Found");
        }

        rs.close();   // Close ResultSet
        stm.close();  // Close Statement
    }

    // Method to close database connection
    public static void closeCon() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
            System.out.println("Connection Closed Successfully");
        }
    }
}
