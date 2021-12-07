package ibf2021.nus;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount("Kin");
        bankAccount.deposit(100f);
        ArrayList<String> myT = bankAccount.getAccountTransactions();

        assertTrue(bankAccount.getAccountBalance() == 100f);
        assertTrue(bankAccount.getAccountTransactions().size() == 1);
        assertTrue(bankAccount.getAccountName().equals("Kin"));
        assertTrue(myT.get(0).contains("deposit $100"));
    }

    @Test
    public void testWithdrawal() {
        BankAccount bankAccount = new BankAccount("Kin");
        bankAccount.deposit(100f);
        bankAccount.withdraw(50f);
        ArrayList<String> myT = bankAccount.getAccountTransactions();

        assertTrue(bankAccount.getAccountBalance() == 50f);
        assertTrue(bankAccount.getAccountTransactions().size() == 2);
        assertTrue(myT.get(1).contains("withdraw $100"));
    }
}
