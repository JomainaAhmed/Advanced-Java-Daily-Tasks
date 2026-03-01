package com.capg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// use PreparedStatement and Scanner input from the user
// save() method
// update() method
// delete() by id method
// findAll() method
// find() by Id
//create scanner object 


public class EmployeeUserInPut {

    private static final String url = "jdbc:postgresql://localhost:5432/lpu";
    private static final String user = "postgres";
    private static final String password = "root";
    private static Connection con;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("org.postgresql.Driver");

            // Create Connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database");

            while (true) {
                System.out.println("\n1. Save Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Find All Employees");
                System.out.println("5. Find Employee By ID");
                System.out.println("6. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> save(con, sc);
                    case 2 -> update(con, sc);
                    case 3 -> delete(con, sc);
                    case 4 -> findAll(con);
                    case 5 -> findById(con, sc);
                    case 6 -> {
                        con.close();
                        sc.close();
                        System.out.println("Connection Closed");
                        return;
                    }
                    default -> System.out.println("Invalid Choice");
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------- SAVE ----------
    public static void save(Connection con, Scanner sc) throws SQLException {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO EMPLOYEE_1 VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setLong(3, phone);
        ps.setDouble(4, salary);
        ps.setString(5, email);

        ps.executeUpdate();
        ps.close();

        System.out.println("Employee Saved Successfully");
    }

    // ---------- UPDATE ----------
    public static void update(Connection con, Scanner sc) throws SQLException {

        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE EMPLOYEE_1 SET salary = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, salary);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        ps.close();

        System.out.println(rows > 0 ? "Employee Updated" : "Employee Not Found");
    }

    // ---------- DELETE ----------
    public static void delete(Connection con, Scanner sc) throws SQLException {

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM EMPLOYEE_1 WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        ps.close();

        System.out.println(rows > 0 ? "Employee Deleted" : "Employee Not Found");
    }

    // ---------- FIND ALL ----------
    public static void findAll(Connection con) throws SQLException {

        String sql = "SELECT * FROM EMPLOYEE_1";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Employee List ---");

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println(
                rs.getInt(1) + " | " +
                rs.getString(2) + " | " +
                rs.getLong(3) + " | " +
                rs.getDouble(4) + " | " +
                rs.getString(5)
            );
        }

        if (!found) {
            System.out.println("No Employees Found");
        }

        rs.close();
        ps.close();
    }

    // ---------- FIND BY ID ----------
    public static void findById(Connection con, Scanner sc) throws SQLException {

        System.out.print("Enter ID to find: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM EMPLOYEE_1 WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("\nEmployee Found:");
            System.out.println("ID     : " + rs.getInt(1));
            System.out.println("Name   : " + rs.getString(2));
            System.out.println("Phone  : " + rs.getLong(3));
            System.out.println("Salary : " + rs.getDouble(4));
            System.out.println("Email  : " + rs.getString(5));
        } else {
            System.out.println("Employee Not Found");
        }

        rs.close();
        ps.close();
    }
}
