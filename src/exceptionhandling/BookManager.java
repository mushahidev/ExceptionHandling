/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

import java.util.LinkedList;
import java.util.Scanner;

public class BookManager {
    private LinkedList<Book> bookList;
    private Scanner scanner;

    public BookManager() {
        bookList = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nBook Manager Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    printAllBooks();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book book = new Book(title, author, year);
        bookList.add(book);
        System.out.println("Book added.");
    }

    private void printAllBooks() {
        System.out.println("\nList of books:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.displayMenu();
    }
}
