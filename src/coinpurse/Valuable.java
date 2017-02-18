package coinpurse;

/**
 * An interface for the valuable things to used in the purse.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.19
 *
 */
public interface Valuable {
	/**
	 * Get the value of the valuable.
	 * 
	 * @return value of the valuable
	 */
	public double getValue();

	/**
	 * Get the currency of the valuable.
	 * 
	 * @return currency of the valuable
	 */
	public String getCurrency();
}
