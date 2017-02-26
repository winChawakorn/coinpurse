package coinpurse;

/**
 * a bank note with a monetary value, currency, and serial number from
 * AbstractValuable abstract class.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.26
 *
 */
public class BankNote extends AbstractValuable {
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
		super(value);
		this.serialNumber = nextSerialNumber;
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
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		// nextSerialNumber++;
	}

	/**
	 * Set the serial number for new bank.
	 */
	public void setNextSerialNumber() {
		nextSerialNumber++;
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
	 * Return String that contains value, currency, and serial number.
	 * 
	 * @return Description of this bank note
	 */
	public String toString() {
		return this.getValue() + "-" + this.getCurrency() + " note ["
				+ this.serialNumber + "]";
	}
}
