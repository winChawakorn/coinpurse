package coinpurse;

/**
 * Abstract class implements Valuable interface used to extended by valuable
 * things in the purse. Consist of Value, Currency, equals, and compareTo.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.25
 */
public abstract class AbstractValuable implements Valuable {
	/* Value of the valuable */
	protected final double value;
	/* currency of the valuable */
	protected final String currency;
	/* Default currency when user doesn't input the currency */
	protected final static String DEFAULT_CURRENCY = "Baht";

	/**
	 * Constructor for the valuable to initialized with the currency.
	 * 
	 * @param value
	 *            is the value of the valuable.
	 * @param currency
	 *            is the currency of the valuable.
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Constructor for the valuable to initialized with default currency.
	 * 
	 * @param value
	 *            is the value of the valuable.
	 */
	public AbstractValuable(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * Compare this valuable with another valuable. Return -1 or 0 or 1 for each
	 * case.
	 * 
	 * @param v
	 *            is the another valuable to compare with.
	 * @return -1 if another valuable is null or this valuable is less than
	 *         another valuable, 0 if they are equal, 1 if this valuable is more
	 *         than another valuable.
	 */
	public int compareTo(Valuable v) {
		if (v == null)
			return -1;
		return (int) Math.signum(this.value - v.getValue());
	}

	/**
	 * Equal this valuable with another object. Return true if equal, false if
	 * not equal.
	 * 
	 * @param arg
	 *            is the object to equal with this valuable.
	 * @return true if the valuables are equal, false if they aren't equal.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Valuable other = (Valuable) arg;
		if (other.getValue() == this.value
				&& other.getCurrency().equals(this.currency))
			return true;
		return false;

	}

	/**
	 * Return the value of the valuable.
	 * 
	 * @return value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the currency of the valuable.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}
}
