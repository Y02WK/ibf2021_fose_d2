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
        bankAccount.deposit(100);
    }

    public BankAccount(String name) {
        this.name = name;
        this.accountActive = true;
        this.accountOpened = new Date();
        this.accountNumber = generateAccountNumber();
    }

    public BankAccount(String name, float accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.accountActive = true;
        this.accountOpened = new Date();
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        Random random = new Random();
        int number = random.nextInt(1000000 - 100000) + 100000;
        return Integer.toString(number);
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(" Deposit amount must be positive");
        }

        this.accountBalance += amount;
        String currentDate = new Date().toString();
        String transactionInfo = "Deposit " + Float.toString(amount) + " at " + currentDate;
        this.transactions.add(transactionInfo);
        System.out.println(transactionInfo);
    }

}
