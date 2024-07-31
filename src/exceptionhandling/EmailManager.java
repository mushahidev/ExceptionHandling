package exceptionhandling;

import java.util.HashSet;
import java.util.Scanner;

public class EmailManager {
    private HashSet<String> emailSet;
    private Scanner scanner;

    public EmailManager() {
        emailSet = new HashSet<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nEmail Manager Menu:");
            System.out.println("1. Add an email");
            System.out.println("2. Remove an email");
            System.out.println("3. Check if an email exists");
            System.out.println("4. Display all emails");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addEmail();
                    break;
                case 2:
                    removeEmail();
                    break;
                case 3:
                    checkEmail();
                    break;
                case 4:
                    displayEmails();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void addEmail() {
        System.out.print("Enter the email address to add: ");
        String email = scanner.nextLine();
        if (emailSet.add(email)) {
            System.out.println("Email added.");
        } else {
            System.out.println("Email already exists.");
        }
    }

    private void removeEmail() {
        System.out.print("Enter the email address to remove: ");
        String email = scanner.nextLine();
        if (emailSet.remove(email)) {
            System.out.println("Email removed.");
        } else {
            System.out.println("Email not found.");
        }
    }

    private void checkEmail() {
        System.out.print("Enter the email address to check: ");
        String email = scanner.nextLine();
        if (emailSet.contains(email)) {
            System.out.println("Email exists in the set.");
        } else {
            System.out.println("Email does not exist in the set.");
        }
    }

    private void displayEmails() {
        System.out.println("\nList of email addresses:");
        for (String email : emailSet) {
            System.out.println(email);
        }
    }

    public static void main(String[] args) {
        EmailManager manager = new EmailManager();
        manager.displayMenu();
    }
}
