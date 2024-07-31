package exceptionhandling;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {
    
     public static void main(String[] args) {
        //ArithmeticException();
        //ArithmeticException();
        //FileNotFoundException();
        //NumberFormatException();
        //NullPointerException();
        InsufficientBalanceException();
      

    }

    public static void ArrayIndexOutOfBoundsException() {
        //ArrayIndexOutOfBoundsException
        Scanner sc = new Scanner(System.in);
        int[] values = new int[5];

        for (int i = 0; i < 7; i++) {
            try {
                System.out.print("Enter Value: ");
                values[i] = sc.nextInt();
                System.out.println("Value added: " + values[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + i + " is out of bounds for array of size " + values.length);
                break;
            }
        }

        sc.close();
    }
    
    public static void ArithmeticException() {
        int x = 5;
        int y = 0;
        
        try {
            int ArithmeticException = x / y;
        } catch (ArithmeticException e) {
            System.out.println("Cannot Divide by Zero " + e.getMessage());
        }
    }
    
    public static void FileNotFoundException() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();

        readFile(filePath);
    }

    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
    
    public static void NumberFormatException() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to parse as an integer: ");
        String inputString = sc.nextLine();

        int result = parseStringToInt(inputString);
        System.out.println("Parsed integer: " + result);
    }

    public static int parseStringToInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format for input: " + inputString);
            return 0; // Default value or another indication of failure
        }
    }
    
    public static void NullPointerException() {
        try {
            // This is the outer try block
            int[] numbers = new int[5];
            String text = null;

            try {
                // Inner try block for ArrayIndexOutOfBoundsException
                numbers[10] = 5;  // This will throw ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            }

            try {
                // Inner try block for NullPointerException
                System.out.println(text.length());  // This will throw NullPointerException
            } catch (NullPointerException e) {
                System.out.println("Caught NullPointerException: " + e.getMessage());
            }

            try {
                // Inner try block for ArithmeticException
                int result = 10 / 0;  // This will throw ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Caught ArithmeticException: " + e.getMessage());
            }

        } catch (Exception e) {
            // This catch block is for any other exceptions that are not caught by inner try blocks
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("This block is executed regardless of an exception.");
        }
        }
    
    public static void InsufficientBalanceException() {
         BankAccount account = new BankAccount(1000.00);

        try {
            // Try to withdraw an amount greater than the balance
            account.withdraw(1500.00);
        } catch (InsufficientBalanceException e) {
            // Catch the custom exception and display an error message
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Try to withdraw an amount within the balance
            account.withdraw(200.00);
        } catch (InsufficientBalanceException e) {
            // Catch the custom exception and display an error message
            System.out.println("Error: " + e.getMessage());
        }
    }
    }

   


