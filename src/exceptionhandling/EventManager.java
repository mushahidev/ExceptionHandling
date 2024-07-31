package exceptionhandling;

import java.util.Scanner;
import java.util.TreeSet;

public class EventManager {
    private TreeSet<String> events;
    private Scanner scanner;

    public EventManager() {
        events = new TreeSet<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nEvent Manager Menu:");
            System.out.println("1. Add an event");
            System.out.println("2. Remove an event");
            System.out.println("3. Display all events");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    removeEvent();
                    break;
                case 3:
                    displayEvents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addEvent() {
        System.out.print("Enter the event name: ");
        String event = scanner.nextLine();
        if (events.add(event)) {
            System.out.println("Event added.");
        } else {
            System.out.println("Event already exists.");
        }
    }

    private void removeEvent() {
        System.out.print("Enter the event name to remove: ");
        String event = scanner.nextLine();
        if (events.remove(event)) {
            System.out.println("Event removed.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private void displayEvents() {
        System.out.println("\nList of events:");
        for (String event : events) {
            System.out.println(event);
        }
    }

    public static void main(String[] args) {
        EventManager manager = new EventManager();
        manager.displayMenu();
    }
}