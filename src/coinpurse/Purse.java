package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.WithdrawStrategy;

/**
 * A purse contains valuables. You can insert valuables, withdraw money, check
 * the balance, and check if the purse is full. When you withdraw money, the
 * purse decides which valuables to remove.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.30
 */
public class Purse extends Observable {
	/* Collection of objects in the purse. */
	List<Valuable> money = new ArrayList<Valuable>();
	/**
	 * Capacity is maximum number of valuable the purse can hold. Capacity is
	 * set when the purse is created and cannot be changed.
	 */
	private final int capacity;
	/* A WithdrawStrategy to be used in this purse */
	private WithdrawStrategy strategy;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of valuable you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Return the unmodified list of the valuables in the purse.
	 * 
	 * @return unmodifiableList of this.money
	 */
	public List<Valuable> getList() {
		return Collections.unmodifiableList(money);
	}

	/**
	 * Count and return the number of valuables in the purse. This is the number
	 * of valuables, not their value.
	 * 
	 * @return the number of valuables in the purse
	 */
	public int count() {
		return this.money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable x : this.money) {
			balance += x.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.money.size() >= this.capacity)
			return true;
		return false;
	}

	/**
	 * Insert a valuable into the purse. The valuable is only inserted if the
	 * purse has space for it and the valuable has positive value. No worthless
	 * valuables!
	 * 
	 * @param valuable
	 *            is a valuable object to insert into purse
	 * @return true if valuable inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (isFull() || valuable.getValue() <= 0)
			return false;
		this.money.add(valuable);
		// money.sort(new CompareByValue());
		// Collections.reverse(money);
		setChanged();
		notifyObservers("Insert " + valuable.getValue() + " "
				+ valuable.getCurrency());
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of valuables
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount <= 0)
			return null;
		List<Valuable> temptlist = strategy.withdraw(amount, money);
		if (temptlist == null || temptlist.size() <= 0)
			return null;
		Valuable[] array = new Valuable[temptlist.size()];
		temptlist.toArray(array);
		for (Valuable v : temptlist) {
			for (Valuable m : money) {
				if (v.equals(m)) {
					money.remove(m);
					break;
				}
			}
		}
		setChanged();
		notifyObservers("Withdraw " + amount + " Baht");
		return temptlist.toArray(new Valuable[0]);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		int valuableCount = 0;
		int bankCount = 0;
		double valuableBalance = 0;
		double bankBalance = 0;
		for (Valuable x : this.money) {
			if (x.getValue() >= 20) {
				bankCount++;
				bankBalance += x.getValue();
			} else {
				valuableCount++;
				valuableBalance += x.getValue();
			}
		}
		return valuableCount + " valuables with value " + valuableBalance
				+ "\n" + bankCount + " notes with value " + bankBalance;
	}

	/**
	 * Set the purse's WithdrawStrategy to the parameter WithdrawStrategy.
	 * 
	 * @param wdStrategy
	 *            is a WithdrawStrategy to set to.
	 */
	public void setWithdrawStrategy(WithdrawStrategy wdStrategy) {
		this.strategy = wdStrategy;
	}
}