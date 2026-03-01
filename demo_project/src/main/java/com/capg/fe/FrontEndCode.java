package com.capg.fe;

import java.util.Scanner;
import com.capg.back_end.StudentDAO;

public class FrontEndCode {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.println("===== STUDENT MANAGEMENT =====");
        System.out.println("1. Save Student");
        System.out.println("2. Find Student");
        System.out.println("3. Delete Student");
        System.out.println("Enter your choice:");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Enter ID:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Name:");
                String name = sc.nextLine();

                System.out.println("Enter Marks:");
                int marks = sc.nextInt();

                System.out.println("Enter Percentage:");
                double percentage = sc.nextDouble();

                dao.saveStudent(id, name, marks, percentage);
                break;

            case 2:
                System.out.println("Enter ID:");
                int findId = sc.nextInt();
                dao.findStudent(findId);
                break;

            case 3:
                System.out.println("Enter ID:");
                int deleteId = sc.nextInt();
                dao.deleteStudent(deleteId);
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}