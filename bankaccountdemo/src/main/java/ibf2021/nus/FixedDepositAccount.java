package ibf2021.nus;

import java.math.BigDecimal;

public class FixedDepositAccount extends BankAccount {

    public static void main(String[] args) {
        FixedDepositAccount fdacc = new FixedDepositAccount("Kin", 100f, 10f, 6);
        System.out.println(fdacc.getBalance());
        fdacc.deposit(100f);
        fdacc.withdraw(100f);
    }

    private float interest = 3f;
    private int duration = 6;

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
    }

    public FixedDepositAccount(String name, float balance, float interest, Integer duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
    }

    @Override
    public void withdraw(float amount) {
        System.out.println("Withdrawal not allowed.");
        return;
    }

    @Override
    public void deposit(float amount) {
        System.out.println("Deposit not allowed.");
        return;
    }

    public BigDecimal getBalance() {
        BigDecimal bdInterest = new BigDecimal(Float.toString(interest));
        BigDecimal bdBalance = this.getAccountBalance();
        BigDecimal calcResult = bdInterest.multiply(bdBalance).divide(new BigDecimal(Float.toString(100f)))
                .add(bdBalance);
        return calcResult;
    }

    public int getDuration() {
        return this.duration;
    }
}
