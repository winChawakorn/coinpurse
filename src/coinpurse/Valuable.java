package coinpurse;

/**
 * An interface for the valuable things to used in the purse.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.26
 *
 */
public interface Valuable extends Comparable<Valuable> {
	/**
	 * Get the value of the valuable.
	 * 
	 * @return value
	 */
	public double getValue();

	/**
	 * Get the currency of the valuable.
	 * 
	 * @return currency
	 */
	public String getCurrency();
}
