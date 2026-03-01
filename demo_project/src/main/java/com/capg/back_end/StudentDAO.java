package com.capg.back_end;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    private String url = "jdbc:postgresql://localhost:5432/lpu";
    private String user = "postgres";
    private String password = "root";

    // Save Student
    public void saveStudent(int id, String name, int marks, double percentage) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO student VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);
            ps.setDouble(4, percentage);

            ps.executeUpdate();
            System.out.println("Student Saved Successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find Student
    public void findStudent(int id) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM student WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Student Found:");
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Marks: " + rs.getInt(3));
                System.out.println("Percentage: " + rs.getDouble(4));
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String query = "DELETE FROM student WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully");
            } else {
                System.out.println("Student Not Found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}