package coinpurse;

/**
 * a bank note with a monetary value, currency, and serial number from
 * AbstractValuable abstract class.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.03.29
 *
 */
public class BankNote extends AbstractValuable {
	/** The serial number of the bank note. */
	private long serialNumber;

	/**
	 * Initialize new BankNote by the value. The currency will be set to default
	 * currency( Baht ). The serial number will be set to new serial number.
	 * 
	 * @param value
	 *            is the value of the note.
	 */
	public BankNote(double value) {
		super(value);
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
	 * Set the serial number to this bank note.
	 * 
	 * @param newSerialNumber
	 *            is the serial number to set to.
	 */
	public void setSerialNumber(long newSerialNumber) {
		this.serialNumber = newSerialNumber;
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
