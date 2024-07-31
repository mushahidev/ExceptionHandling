/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptionhandling;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskManager {
    private PriorityQueue<Task> taskQueue;
    private Scanner scanner;

    public TaskManager() {
        taskQueue = new PriorityQueue<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Add a task");
            System.out.println("2. Remove the highest priority task");
            System.out.println("3. Print all tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    printAllTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task priority (higher number means higher priority): ");
        int priority = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Task task = new Task(description, priority);
        taskQueue.add(task);
        System.out.println("Task added.");
    }

    private void removeTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to remove.");
        } else {
            Task removedTask = taskQueue.poll();
            System.out.println("Removed task: " + removedTask);
        }
    }

    private void printAllTasks() {
        System.out.println("\nList of tasks:");
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : taskQueue) {
                System.out.println(task);
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.displayMenu();
    }
}
