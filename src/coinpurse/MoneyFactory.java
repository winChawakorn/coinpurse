package coinpurse;

/**
 * An abstract class for each country money factory to edit for their currency.
 * It contains some method that every factory must have.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.26
 */
public abstract class MoneyFactory {
	private static MoneyFactory factory;

	/**
	 * Make other class can't call new MoneyFactory
	 */
	protected MoneyFactory() {
	}

	/**
	 * Return the instance of the MoneyFactory.
	 * 
	 * @return factory
	 */
	static MoneyFactory getInstance() {
		return factory;
	}

	/**
	 * Set the factory to f in the parameter.
	 * 
	 * @param f
	 *            is the MoneyFactory to set.
	 */
	static void setMoneyFactory(MoneyFactory f) {
		factory = f;
	}

	/**
	 * Abstract method, used to create the money by primitive double, for edited
	 * in each country factory.
	 * 
	 * @param value
	 *            is the value of the money to create in primitive double.
	 * @return the money in Valuable.
	 */
	abstract Valuable createMoney(double value);

	/**
	 * Try parsing String value into Double to use createMoney(double value)
	 * method. Return the money in valuable, if try parsing String into Double
	 * and it's possible. Throw the IllegalArgumentException if cannot.
	 * 
	 * @param value
	 *            is the value of the money to create in String.
	 * @return the money in Valuable or throw the exception if cannot.
	 */
	Valuable createMoney(String value) {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return createMoney(Double.parseDouble(value));
	}
}
