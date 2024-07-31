package exceptionhandling;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<String> students;
    private Scanner scanner;

    public StudentManager() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nStudent Manager Menu:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addStudent() {
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        students.add(name);
        System.out.println("Student added.");
    }

    private void removeStudent() {
        System.out.print("Enter the student's name to remove: ");
        String name = scanner.nextLine();
        if (students.remove(name)) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayStudents() {
        System.out.println("\nList of students:");
        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.displayMenu();
    }
}