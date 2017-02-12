package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.12
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Coin> money = new ArrayList<Coin>();
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
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
		for (Coin x : this.money) {
			balance += x.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
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
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		if (isFull() || coin.getValue() <= 0)
			return false;
		this.money.add(coin);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		Collections.sort(money);
		Collections.reverse(money);
		if (amount <= 0)
			return null;
		List<Coin> usedCoin = new ArrayList<Coin>();
		for (int i = 0; i < this.count(); i++) {
			if (this.money.get(i).getValue() <= amount) {
				amount -= this.money.get(i).getValue();
				usedCoin.add(this.money.get(i));
			}
		}
		if (amount > 0) {
			return null;
		}
		Coin[] array = new Coin[usedCoin.size()];
		usedCoin.toArray(array);
		for (Coin x : usedCoin) {
			for (int i = 0; i < this.count(); i++) {
				if (x.equals(this.money.get(i))) {
					this.money.remove(i);
					break;
				}
			}
		}
		return array;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return this.money.size() + " coins with value " + this.getBalance();
	}
}