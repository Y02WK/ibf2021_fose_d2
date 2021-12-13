package ibf2021.nus;

import java.math.BigDecimal;
/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
    private final String name;
    private final String accountNumber;
    private BigDecimal accountBalance = BigDecimal.ZERO;
    private List<String> transactions = new ArrayList<String>();
    private boolean accountActive;
    private Date accountOpened;
    private Date accountClosed = null;

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
        this.accountBalance = new BigDecimal(Float.toString(accountBalance));
        this.accountActive = true;
        this.accountOpened = new Date();
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        // Method to generate an Account number. Returns the number as a String
        Random random = new Random();
        int number = random.nextInt(1000000 - 1) + 100000;
        return Integer.toString(number);
    }

    public void deposit(float amount) {
        // Method to deposit an amount into the BankAccount
        if (!validationChecks(amount))
            return;

        BigDecimal deposit = new BigDecimal(Float.toString(amount));
        this.accountBalance = (this.accountBalance.add(deposit));
        this.addTransaction(deposit.toString(), "deposit");
    }

    public void withdraw(float amount) {
        // Method to withdraw an amount from the BankAccount
        if (!this.validationChecks(amount))
            return;

        BigDecimal withdrawal = new BigDecimal(Float.toString(amount));
        if (this.accountBalance.subtract(withdrawal).compareTo(BigDecimal.ZERO) > 0) {
            this.accountBalance = (this.accountBalance.subtract(withdrawal));
            this.addTransaction(withdrawal.toString(), "withdraw");
        } else {
            System.out.println("Error. Not enough funds in account.");
        }
    }

    public void closeAccount() {
        this.accountActive = false;
        this.accountClosed = new Date();
    }

    public BigDecimal getAccountBalance() {
        // Getter method to get the account balance
        return (this.accountBalance);
    }

    public String getAccountName() {
        // Getter method to print the name of the account owner
        return (this.name);
    }

    public String getAccountNumber() {
        // Getter method to print the account number
        return (this.accountNumber);
    }

    public Date getAccountOpenDate() {
        // Getter method to print the account opening date
        return (this.accountOpened);
    }

    public Date getAccountCloseDate() {
        // Getter method to print the account closing date
        return (this.accountClosed);
    }

    public List<String> getAccountTransactions() {
        // Getter method to print all the transactions in the account
        return (this.transactions);
    }

    public boolean getAccountActive() {
        return (this.accountActive);
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
        // Runs the account and amount validation checks and prints an error message if
        // an exception is thrown.
        try {
            this.checkValidAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Error. Amount must be positive.");
            return false;
        }

        try {
            this.checkActive();
        } catch (IllegalArgumentException e) {
            System.out.println("Error. Account is closed.");
            return false;
        }

        return true;
    }

    private void addTransaction(String amount, String type) {
        // Function to add a transaction record to the account's transaction list.
        String currentDate = new Date().toString();
        String currentTransaction = type + " $" + amount + " " + currentDate;
        System.out.println(currentTransaction);
        this.transactions.add(currentTransaction);
    }
}
