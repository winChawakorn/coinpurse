package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

/**
 * A purse contains valuables. You can insert valuables, withdraw money, check
 * the balance, and check if the purse is full. When you withdraw money, the
 * purse decides which valuables to remove.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.17
 */
public class Purse extends Observable {
	/** Collection of objects in the purse. */
	List<Valuable> money = new ArrayList<Valuable>();
	/**
	 * Capacity is maximum number of valuable the purse can hold. Capacity is
	 * set when the purse is created and cannot be changed.
	 */
	private final int capacity;

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
		money.sort(new CompareByValue());
		Collections.reverse(money);
		setChanged();
		notifyObservers("insert " + valuable.getValue());
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
		double saveAmount = amount;
		List<Valuable> usedMoney = new ArrayList<Valuable>();
		for (int i = 0; i < this.count(); i++) {
			if (this.money.get(i).getValue() <= amount) {
				amount -= this.money.get(i).getValue();
				usedMoney.add(this.money.get(i));
			}
		}
		if (amount > 0) {
			return null;
		}
		Valuable[] array = new Valuable[usedMoney.size()];
		usedMoney.toArray(array);
		for (Valuable v : usedMoney) {
			for (int i = 0; i < this.count(); i++) {
				if (v.equals(this.money.get(i))) {
					this.money.remove(i);
					break;
				}
			}
		}
		setChanged();
		notifyObservers("withdrew " + saveAmount);
		return array;
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
}

/**
 * Create this class to compare two valuables by their value to sort them by the
 * value.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.19
 *
 */
class CompareByValue implements Comparator<Valuable> {
	/**
	 * @param c1
	 *            is the first valuable to compare.
	 * @param c2
	 *            is the second valuable to compare.
	 * @return -1 if the first valuable's currency is come first, 0 if they are
	 *         equal, 1 if the second valuable's currency is come first.
	 */
	@Override
	public int compare(Valuable c1, Valuable c2) {
		return (int) Math.signum(c1.getValue() - c2.getValue());
	}
}