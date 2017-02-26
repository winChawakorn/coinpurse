package coinpurse;

/**
 * a coin with a monetary value and currency from AbstractValuable abstract
 * class.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.26
 */

public class Coin extends AbstractValuable {
	/*
	 * String of the printed currency in the toString (not the real currency),
	 * such as Satang and Sen.
	 */
	private String toStringCurrency;
	private double toStringValue;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of the coin.
	 */
	public Coin(double value) {
		super(value);
		this.toStringCurrency = super.currency;
		this.toStringValue = super.value;
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
		super(value, currency);
		this.toStringCurrency = super.currency;
		this.toStringValue = super.value;
	}

	/**
	 * Return String that contains toStringValue and toStringCurrency.
	 * 
	 * @return Description of this coin
	 */
	public String toString() {
		return this.toStringValue + "-" + this.toStringCurrency + " coin";
	}

	/**
	 * Set the printed currency and value by the MoneyFactory, such as set 0.5
	 * Baht to 50.0 Satang.
	 * 
	 * @param toStringValue
	 *            is the printed value.
	 * @param toStringCurrency
	 *            is the printed currency.
	 */
	public void setToString(double toStringValue, String toStringCurrency) {
		this.toStringCurrency = toStringCurrency;
		this.toStringValue = toStringValue;
	}
}
