package coinpurse;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.12
 */
public class Main {
	/** The capacity of the purse */
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(CAPACITY);
		new ConsoleDialog(purse).run();
	}
}
