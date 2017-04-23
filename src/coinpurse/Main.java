package coinpurse;

import java.util.ResourceBundle;

import javax.swing.JList;
import javax.swing.ListModel;

import coinpurse.gui.PurseBalanceObserver;
import coinpurse.gui.PurseListModel;
import coinpurse.gui.PurseStatusObserver;
import coinpurse.gui.PurseTransactions;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to purse. Now it use ResourceBundle to read the
 * factory class from the file purse.properties to set the MoneyFactory.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.23
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
		PurseBalanceObserver observer1 = new PurseBalanceObserver();
		PurseStatusObserver observer2 = new PurseStatusObserver();
		PurseListModel observer3 = new PurseListModel(purse);
		PurseTransactions observer4 = new PurseTransactions();
		purse.addObserver(observer1);
		purse.addObserver(observer2);
		purse.addObserver(observer3);
		purse.addObserver(observer4);
		observer1.run();
		observer2.run();
		observer3.run();
		observer4.run();
		new ConsoleDialog(purse).run();
	}
}
