package ibf2021.nus;

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

    public Float getBalance() {
        return (this.interest * this.getAccountBalance() / 100 + this.getAccountBalance());
    }

    public int getDuration() {
        return this.duration;
    }
}
