package exceptionhandling;

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
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
