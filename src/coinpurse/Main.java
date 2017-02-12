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
		// TODO follow the steps in the sequence diagram
		// 1. create a Purse

		// 2. create a ConsoleDialog with a reference to the Purse object

		// 3. run the ConsoleDialog
		Purse purse = new Purse(CAPACITY);
		new ConsoleDialog(purse).run();
	}
}
