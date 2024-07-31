package exceptionhandling;

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {
    private HashMap<Integer, String> employees;
    private Scanner scanner;

    public EmployeeManager() {
        employees = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nEmployee Manager Menu:");
            System.out.println("1. Add an employee");
            System.out.println("2. Remove an employee");
            System.out.println("3. Search for an employee by ID");
            System.out.println("4. Display all employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        employees.put(id, name);
        System.out.println("Employee added.");
    }

    private void removeEmployee() {
        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();
        if (employees.remove(id) != null) {
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();
        String name = employees.get(id);
        if (name != null) {
            System.out.println("Employee ID: " + id + ", Name: " + name);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void displayEmployees() {
        System.out.println("\nList of employees:");
        for (HashMap.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.displayMenu();
    }
}