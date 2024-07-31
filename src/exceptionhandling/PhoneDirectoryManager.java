package exceptionhandling;

import java.util.Scanner;
import java.util.TreeMap;

public class PhoneDirectoryManager {
    private TreeMap<String, String> phoneDirectory;
    private Scanner scanner;

    public PhoneDirectoryManager() {
        phoneDirectory = new TreeMap<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nPhone Directory Manager Menu:");
            System.out.println("1. Add a phone number");
            System.out.println("2. Remove a phone number");
            System.out.println("3. Search for a phone number by name");
            System.out.println("4. Display all phone numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addPhoneNumber();
                    break;
                case 2:
                    removePhoneNumber();
                    break;
                case 3:
                    searchPhoneNumber();
                    break;
                case 4:
                    displayPhoneNumbers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void addPhoneNumber() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        phoneDirectory.put(name, phoneNumber);
        System.out.println("Phone number added.");
    }

    private void removePhoneNumber() {
        System.out.print("Enter the name to remove: ");
        String name = scanner.nextLine();
        if (phoneDirectory.remove(name) != null) {
            System.out.println("Phone number removed.");
        } else {
            System.out.println("Name not found.");
        }
    }

    private void searchPhoneNumber() {
        System.out.print("Enter the name to search: ");
        String name = scanner.nextLine();
        String phoneNumber = phoneDirectory.get(name);
        if (phoneNumber != null) {
            System.out.println("Name: " + name + ", Phone Number: " + phoneNumber);
        } else {
            System.out.println("Name not found.");
        }
    }

    private void displayPhoneNumbers() {
        System.out.println("\nList of phone numbers:");
        for (TreeMap.Entry<String, String> entry : phoneDirectory.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Phone Number: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneDirectoryManager manager = new PhoneDirectoryManager();
        manager.displayMenu();
    }
}