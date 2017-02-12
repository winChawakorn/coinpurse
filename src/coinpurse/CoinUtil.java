package coinpurse;

import java.util.*;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.12
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Coin> filterByCurrency(final List<Coin> coinlist,
			String currency) {
		if (currency == null) {
			return null;
		}
		List<Coin> filter = new ArrayList<Coin>();
		for (Coin x : coinlist) {
			if (x.getCurrency().equals(currency))
				filter.add(x);
		}
		return filter; // return a list of coin references copied from coinlist
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sort.
	 */
	public static void sortByCurrency(List<Coin> coins) {
		coins.sort(new CompareByCurrency());
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 */
	public static void sumByCurrency(List<Coin> coins) {
		coins.sort(new CompareByCurrency());
		double sum = 0;
		for (int i = 0; i < coins.size() - 1; i++) {
			sum += coins.get(i).getValue();
			if (!(coins.get(i).getCurrency().equals(coins.get(i + 1)
					.getCurrency())) || i == coins.size() - 2) {
				if (coins.get(i).getCurrency()
						.equals(coins.get(i + 1).getCurrency())) {
					sum += coins.get(i + 1).getValue();
				}
				System.out.println(sum + " " + coins.get(i).getCurrency());
				sum = 0;
			}
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Coin> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Coin> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");
		sumByCurrency(coins);

	}

	/**
	 * Make a list of coins containing different currencies.
	 * 
	 * @return Array of coins.
	 */
	public static List<Coin> makeInternationalCoins() {
		List<Coin> money = new ArrayList<Coin>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/**
	 * Make a list of coins using given values.
	 * 
	 * @param currency
	 *            is the currency of these new coins.
	 * @param values
	 *            is the value of these new coins.
	 * @return Array of new coins.
	 */
	public static List<Coin> makeCoins(String currency, double... values) {
		List<Coin> list = new ArrayList<Coin>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/**
	 * Print the list on the console, on one line.
	 * 
	 * @param items
	 *            is the item to print.
	 * @param separator
	 *            is the String to print.
	 */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}

/**
 * Create this class to compare two coins by their currency to sort them by the
 * currency.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.12
 *
 */
class CompareByCurrency implements Comparator<Coin> {
	/**
	 * @param c1
	 *            is the first coin to compare.
	 * @param c2
	 *            is the second coin to compare.
	 * @return -1 if the first coin's currency is come first, 0 if they are
	 *         equal, 1 if the second coin's currency is come first.
	 */
	@Override
	public int compare(Coin c1, Coin c2) {
		return c1.getCurrency().compareTo(c2.getCurrency());
	}
}