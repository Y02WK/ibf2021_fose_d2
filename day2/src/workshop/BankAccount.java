package workshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class BankAccount {
    private String name;
    private String accountNumber;
    private float accountBalance = 0;
    private ArrayList<String> transactions = new ArrayList<String>();
    private boolean accountActive;
    private Date accountOpened;
    private Date accountClosed = null;
    
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Kin");
        bankAccount.deposit(100f);
        bankAccount.getAccountBalance();
        bankAccount.withdraw(93.22f);
        bankAccount.getAccountBalance();
        bankAccount.getAccountName();
        bankAccount.getAccountNumber();
        bankAccount.getAccountOpenDate();
        bankAccount.getAccountCloseDate();
        bankAccount.getAccountTransactions();
    }

    public BankAccount(String name) {
        // Constructor with only one parameter
        this.name = name;
        this.accountActive = true;
        this.accountOpened = new Date();
        this.accountNumber = generateAccountNumber();
    }

    public BankAccount(String name, float accountBalance) {
        // Constructor with two parameters (updates name and accountBalance)
        this.name = name;
        this.accountBalance = accountBalance;
        this.accountActive = true;
        this.accountOpened = new Date();
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        // Method to generate an Account number. Returns the number as a String
        Random random = new Random();
        int number = random.nextInt(1000000 - 100000) + 100000;
        return Integer.toString(number);
    }

    public void deposit(float amount) {
        // Method to deposit an amount into the BankAccount
        if (!validationChecks(amount)) return;

        this.accountBalance += amount;
        this.addTransaction(Float.toString(amount), "deposit");
    }

    public void withdraw(float amount) {
        // Method to withdraw an amount from the BankAccount
        if (!this.validationChecks(amount)) return;
        
        this.accountBalance -= amount;
        this.addTransaction(Float.toString(amount), "withdraw");
    }

    public void getAccountBalance() {
        // Getter method to get the account balance
        System.out.println(this.accountBalance);
    }

    public void getAccountName() {
        // Getter method to print the name of the account owner
        System.out.println(this.name);
    }

    public void getAccountNumber() {
        // Getter method to print the account number
        System.out.println(this.accountNumber);
    }

    public void getAccountOpenDate() {
        // Getter method to print the account opening date
        System.out.println(this.accountOpened);
    }

    public void getAccountCloseDate() {
        // Getter method to print the account closing date
        System.out.println(this.accountClosed);
    }

    public void getAccountTransactions() {
        // Getter method to print all the transactions in the account
        for (int i = 0; i < this.transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    private void checkActive() {
        // Checks if the account is active
        if (!this.accountActive) {
            throw new IllegalArgumentException("Invalid operation. Account is closed.");
        }
        return;
    }

    private void checkValidAmount(float amount) {
        // Checks if the amount is a positive number
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        return;
    }

    private boolean validationChecks(float amount) {
        // Runs the account and amount validation checks and prints an error message if an exception is thrown.
        try {
            this.checkValidAmount(amount);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error. Amount must be positive.");
            return false;
        }

        try {
            this.checkActive();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error. Account is closed.");
            return false;
        }

        return true;
    }

    private void addTransaction(String amount, String type) {
        // Function to add a transaction record to the account's transaction list.
        String currentDate = new Date().toString();
        String currentTransaction = type + " " + amount + " " + currentDate;
        System.out.println(currentTransaction);
        this.transactions.add(currentTransaction);
    }
}
