/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

import java.util.HashSet;
import java.util.Scanner;

public class StringSetManager {
    private HashSet<String> stringSet;
    private Scanner scanner;

    public StringSetManager() {
        stringSet = new HashSet<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nString Set Manager Menu:");
            System.out.println("1. Add a string");
            System.out.println("2. Display all strings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addString();
                    break;
                case 2:
                    printAllStrings();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void addString() {
        System.out.print("Enter a string to add: ");
        String input = scanner.nextLine();
        if (stringSet.add(input)) {
            System.out.println("String added.");
        } else {
            System.out.println("String already exists.");
        }
    }

    private void printAllStrings() {
        System.out.println("\nList of strings:");
        for (String str : stringSet) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        StringSetManager manager = new StringSetManager();
        manager.displayMenu();
    }
}