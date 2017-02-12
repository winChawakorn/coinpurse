package coinpurse;

/**
 * a coin with a monetary value and currency
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.12
 */

public class Coin implements Comparable<Coin> {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of the coin.
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is the value of the coin.
	 * @param currency
	 *            is the currency of the coin.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return the value of the coin.
	 * 
	 * @return value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the currency of the coin.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Equal this coin with another object. Return true if equal, false if not
	 * equal.
	 * 
	 * @param arg
	 *            is the object to equal with this coin.
	 * @return true if the coins are equal, false if they aren't equal.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if (other.value == this.value && other.currency.equals(this.currency))
			return true;
		return false;

	}

	/**
	 * Compare this coin with another coin. Return -1 if another coin is null or
	 * this coin is less than another coin, 0 if they are equal, 1 if this coin
	 * is more than another coin.
	 * 
	 * @param c
	 *            is the another coin to compare with.
	 * @return -1 if another coin is null or this coin is less than another
	 *         coin, 0 if they are equal, 1 if this coin is more than another
	 *         coin.
	 */
	@Override
	public int compareTo(Coin c) {
		if (c == null)
			return -1;
		return (int) Math.signum(this.value - c.value);
	}

	/**
	 * Return String that contains value and currency.
	 * 
	 * @return value and currency of this coin.
	 */
	public String toString() {
		return this.value + "-" + this.currency;
	}

}
