/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

import java.util.HashMap;
import java.util.Scanner;

public class StudentDirectory {
    private HashMap<Integer, String> studentMap;
    private Scanner scanner;

    public StudentDirectory() {
        studentMap = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nStudent Directory Menu:");
            System.out.println("1. Add a student");
            System.out.println("2. Display all students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    printAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        studentMap.put(id, name);
        System.out.println("Student added.");
    }

    private void printAllStudents() {
        System.out.println("\nList of students:");
        for (HashMap.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        directory.displayMenu();
    }
}