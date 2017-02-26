package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to purse. Now it use ResourceBundle to read the
 * factory class from the file purse.properties to set the MoneyFactory.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.26
 */
public class Main {
	/** The capacity of the purse */
	private static int CAPACITY = 10;

	/**
	 * Configure ,read the file for creating the factory, create the factory,
	 * and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out
					.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null) {
			System.exit(1);
		} else {
			MoneyFactory.setMoneyFactory(factory);
		}
		Purse purse = new Purse(CAPACITY);
		new ConsoleDialog(purse).run();
	}
}
