package coinpurse;

/**
 * a bank note with a monetary value, currency, and serial number.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.19
 *
 */
public class BankNote implements Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the bank note. */
	private final double value;
	/** The currency. */
	private final String currency;
	/** The serial number of the bank note. */
	private long serialNumber;
	/** The next serial number of the bank note. */
	public static long nextSerialNumber = 1000000;

	/**
	 * Initialize new BankNote by the value. The currency will be set to default
	 * currency( Baht ). The serial number will be set to new serial number.
	 * 
	 * @param value
	 *            is the value of the note.
	 */
	public BankNote(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * Initialize new BankNote by the value and currency. The next serial number
	 * will be set to new serial number.
	 * 
	 * @param value
	 *            is the value of the note.
	 * @param currency
	 *            is the currency of the note.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/**
	 * Return the currency of the note.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Return the value of the note.
	 * 
	 * @return value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the serial number of the note.
	 * 
	 * @return serialNumber
	 */
	public long getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * Equal this note with another object. Return true if equal, false if not
	 * equal.
	 * 
	 * @param arg
	 *            is the object to equal with this note.
	 * @return true if the notes are equal, false if they aren't equal.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) arg;
		if (other.value == this.value && other.currency.equals(this.currency))
			return true;
		return false;
	}

	/**
	 * Return String that contains value, currency, and serial number.
	 * 
	 * @return value and currency of this note.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber
				+ "]";
	}
}
