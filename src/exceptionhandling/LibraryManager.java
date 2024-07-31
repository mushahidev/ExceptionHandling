package exceptionhandling;

import java.util.LinkedList;
import java.util.Scanner;

public class LibraryManager {
    private LinkedList<String> books;
    private Scanner scanner;

    public LibraryManager() {
        books = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nLibrary Manager Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addBook() {
        System.out.print("Enter the book title: ");
        String book = scanner.nextLine();
        books.add(book);
        System.out.println("Book added.");
    }

    private void removeBook() {
        System.out.print("Enter the book title to remove: ");
        String book = scanner.nextLine();
        if (books.remove(book)) {
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private void displayBooks() {
        System.out.println("\nList of books:");
        for (String book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.displayMenu();
    }
}