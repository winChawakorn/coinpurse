package coinpurse.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * A JUnit test for purse.withdraw()
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.30
 *
 */
public class WithdrawTest {
	private Purse purse;

	/*
	 * Set up the purse for testing.
	 */
	@Before
	public void setup() {
		purse = new Purse(4);
		// purse.setWithdrawStrategy(new GreedyWithdraw());
		purse.setWithdrawStrategy(new RecursiveWithdraw());
	}

	/**
	 * Test withdraw when the Valuable is in the descending order.
	 */
	@Test
	public void withdrawDescending() {
		purse.insert(new Coin(5));
		Coin two = new Coin(2);
		purse.insert(two);
		purse.insert(two);
		purse.insert(two);
		assertArrayEquals(new Valuable[] { two, two, two }, purse.withdraw(6));
	}

	/**
	 * Test the output after withdrawing an invalid amount.
	 */
	@Test
	public void testInvalidAmount() {
		Coin c = new Coin(10);
		purse.insert(c);
		assertNull(purse.withdraw(11));
		assertNull(purse.withdraw(0));
	}

	/**
	 * Test the balance after withdraw.
	 */
	@Test
	public void testBalance() {
		purse.insert(new Coin(10));
		assertTrue(10 == purse.getBalance());
	}

	/**
	 * Test withdraw multiple Valuable.
	 */
	@Test
	public void multipleWithdraw() {
		Coin ten = new Coin(10);
		purse.insert(ten);
		purse.insert(ten);
		assertArrayEquals(new Valuable[] { ten, ten }, purse.withdraw(20));
		assertTrue(0 == purse.getBalance());
	}
}
