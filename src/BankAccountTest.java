import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * 
 */

/**
 * @author rjensen
 * Source: http://stackoverflow.com/a/12184332/4504607
 */
public class BankAccountTest {


    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
	private BankAccount testAccount;
	
	@Before
	public void setUp() throws Exception {
		testAccount = new BankAccount("Test Person", 12345);
		testAccount.deposit(500.00); // add some money 
	}

	/**
	 * Test method for {@link BankAccount#deposit(double)}.
	 * @throws BankAccountException 
	 */
	@Test
	public void testDeposit() throws BankAccountException {
		double testBalance = testAccount.getBalance(); // get the current balance, assume this works for now;
		double testAmount = 123.45;
//		thrown.expect(BankAccountException.class);
		testAccount.deposit(testAmount);
		assert(testAccount.getBalance() == testBalance + testAmount);
	}

	/**
	 * Test method for {@link BankAccount#deposit(double)}.
	 * @throws BankAccountException 
	 */
	@Test
	public void testDepositWithNegativeAmount() throws BankAccountException {
		double testBalance = testAccount.getBalance(); // get the current balance, assume this works for now;
		double testAmount = -123.45;
		thrown.expect(BankAccountException.class);
		testAccount.deposit(testAmount);
		assert(testAccount.getBalance() == testBalance);
	}
	/**
	 * Test method for {@link BankAccount#withdraw(double)}.
	 * @throws BankAccountException 
	 */
	@Test
	public void testWithdraw() throws BankAccountException {
		double testBalance = testAccount.getBalance(); // get the current balance, assume this works for now;
		double testAmount = 123.45;
//		thrown.expect(BankAccountException.class);
		testAccount.withdraw(testAmount);
		assert(testAccount.getBalance() == testBalance - testAmount);
	}

	/**
	 * Test method for {@link BankAccount#withdraw(double)}.
	 * @throws BankAccountException 
	 */
	@Test
	public void testWithdrawWithNegativeAmount() throws BankAccountException {
		double testBalance = testAccount.getBalance(); // get the current balance, assume this works for now;
		double testAmount = -123.45;
		thrown.expect(BankAccountException.class);
		testAccount.withdraw(testAmount);
		assert(testAccount.getBalance() == testBalance);
	}

	/**
	 * Test method for {@link BankAccount#withdraw(double)}.
	 * @throws BankAccountException 
	 */
	@Test
	public void testWithdrawWithOverdraftAmount() {
		double testBalance = testAccount.getBalance(); // get the current balance, assume this works for now;
		double testAmount = testBalance + 1;

		try {
			testAccount.withdraw(testAmount);
		} catch (BankAccountException e) {

		}

		assertTrue (testBalance == testAccount.getBalance());
	}

}
