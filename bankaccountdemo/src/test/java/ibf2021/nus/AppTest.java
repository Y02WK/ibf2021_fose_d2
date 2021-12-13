package ibf2021.nus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private BankAccount bankAccount;
    private BankAccount bankAccount2;
    private FixedDepositAccount fdAcc;

    @Before
    public void setUp() {
        bankAccount = new BankAccount("Kin");
        bankAccount2 = new BankAccount("Yong", 20000f);
        fdAcc = new FixedDepositAccount("fdKin", 10000f);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testBankAccount() {
        bankAccount.deposit(100f);
        bankAccount.deposit(200.1f);
        List<String> myT = bankAccount.getAccountTransactions();

        assertEquals(bankAccount.getAccountBalance().compareTo(new BigDecimal(Double.toString(300.1))), 0);
        assertTrue(bankAccount.getAccountTransactions().size() == 2);
        assertTrue(bankAccount.getAccountName().equals("Kin"));
        assertTrue(bankAccount.getAccountCloseDate() == null);
        assertTrue(bankAccount.getAccountOpenDate() != null);
        assertTrue(myT.get(0).contains("deposit $100"));
    }

    @Test
    public void testWithdrawal() {
        bankAccount2.deposit(100.5f);
        bankAccount2.withdraw(50.3f);
        bankAccount2.withdraw(100000f);
        List<String> myT = bankAccount2.getAccountTransactions();

        assertEquals(bankAccount2.getAccountBalance().compareTo(new BigDecimal(Double.toString(20050.2))), 0);
        assertTrue(bankAccount2.getAccountTransactions().size() == 2);
        assertTrue(myT.get(1).contains("withdraw $50"));
    }

    @Test
    public void testFDOpen() {
        fdAcc.deposit(90000f);
        fdAcc.withdraw(10000f);
        assertEquals(fdAcc.getAccountBalance().compareTo(new BigDecimal(Double.toString(10000))), 0);
        assertEquals(fdAcc.getBalance().compareTo(new BigDecimal(Double.toString(10300))), 0);
    }
}
