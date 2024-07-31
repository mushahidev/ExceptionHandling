package exceptionhandling;

import java.util.ArrayList;
import java.util.Scanner;

public class IntegerListManager {
    private ArrayList<Integer> integerList;
    private Scanner scanner;

    public IntegerListManager() {
        integerList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nInteger List Manager Menu:");
            System.out.println("1. Add an integer");
            System.out.println("2. Display all integers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addInteger();
                    break;
                case 2:
                    printAllIntegers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void addInteger() {
        System.out.print("Enter an integer to add: ");
        int number = scanner.nextInt();
        integerList.add(number);
        System.out.println("Integer added.");
    }

    private void printAllIntegers() {
        System.out.println("\nList of integers:");
        for (Integer number : integerList) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        IntegerListManager manager = new IntegerListManager();
        manager.displayMenu();
    }
}