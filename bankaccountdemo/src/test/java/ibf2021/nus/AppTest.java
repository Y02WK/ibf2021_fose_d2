package ibf2021.nus;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testDeposit()
    {
        BankAccount bankAccount = new BankAccount("Kin");
        bankAccount.deposit(100f);

        assertTrue(bankAccount.getAccountBalance()==100f);
        assertTrue(bankAccount.getAccountTransactions().size()==1);
        assertTrue(bankAccount.getAccountName().equals("Kin"));
    }
}
