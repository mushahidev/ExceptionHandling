/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeDirectory {
    private TreeMap<Integer, Employee> employeeMap;
    private Scanner scanner;

    public EmployeeDirectory() {
        employeeMap = new TreeMap<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nEmployee Directory Menu:");
            System.out.println("1. Add an employee");
            System.out.println("2. Update employee details");
            System.out.println("3. Print all employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    printAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Employee employee = new Employee(name, department, salary);
        employeeMap.put(id, employee);
        System.out.println("Employee added.");
    }

    private void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (employeeMap.containsKey(id)) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new department: ");
            String department = scanner.nextLine();
            System.out.print("Enter new salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            Employee employee = employeeMap.get(id);
            employee.setName(name);
            employee.setDepartment(department);
            employee.setSalary(salary);
            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee ID not found.");
        }
    }

    private void printAllEmployees() {
        System.out.println("\nList of employees:");
        for (TreeMap.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();
        directory.displayMenu();
    }
}
