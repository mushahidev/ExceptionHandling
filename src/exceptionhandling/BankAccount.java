package exceptionhandling;

public class BankAccount {
    private double balance;

    // Constructor to initialize the account with a balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: $" + balance);
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}
