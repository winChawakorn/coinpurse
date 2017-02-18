package coinpurse;

import java.util.*;

/**
 * Some Valuable utility methods for practice using Lists and Comparator.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.19
 */
public class CoinUtil {

	/**
	 * Method that examines all the valuables in a List and returns only the
	 * valuables that have a currency that matches the parameter value.
	 * 
	 * @param valuablelist
	 *            is a List of Valuable objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuablelist that
	 *         have the requested currency.
	 */
	public static List<Valuable> filterByCurrency(
			final List<Valuable> valuablelist, String currency) {
		if (currency == null) {
			return null;
		}
		List<Valuable> filter = new ArrayList<Valuable>();
		for (Valuable x : valuablelist) {
			if (x.getCurrency().equals(currency))
				filter.add(x);
		}
		return filter; // return a list of valuable references copied from
						// valuablelist
	}

	/**
	 * Method to sort a list of valuables by currency. On return, the list
	 * (valuables) will be ordered by currency.
	 * 
	 * @param valuable
	 *            is a List of Valuable objects we want to sort.
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		valuable.sort(new CompareByCurrency());
	}

	/**
	 * Sum valuables by currency and print the sum for each currency. Print one
	 * line for the sum of each currency. For example: valuables = {
	 * Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit")
	 * } then sumByCurrency(valuables) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 * 
	 * @param valuable
	 */
	public static void sumByCurrency(List<Valuable> valuable) {
		Map<String, Double> wordmap = new HashMap<String, Double>();
		for (Valuable x : valuable) {
			wordmap.put(x.getCurrency(),
					wordmap.getOrDefault(x.getCurrency(), 0.0) + x.getValue());
		}
		for (String x : wordmap.keySet()) {
			double count = wordmap.get(x);
			System.out.printf("%s %.2f\n", x, count);
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
		System.out.println("Filter valuable by currency of " + currency);
		List<Valuable> valuable = makeInternationalValuable();
		int size = valuable.size();
		System.out.print(" INPUT: ");
		printList(valuable, " ");
		List<Valuable> rupees = filterByCurrency(valuable, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (valuable.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort valuable by currency");
		valuable = makeInternationalValuable();
		System.out.print(" INPUT: ");
		printList(valuable, " ");
		sortByCurrency(valuable);
		System.out.print("RESULT: ");
		printList(valuable, " ");

		System.out.println("\nSum valuable by currency");
		valuable = makeInternationalValuable();
		System.out.print("valuable = ");
		printList(valuable, " ");
		sumByCurrency(valuable);

	}

	/**
	 * Make a list of valuables containing different currencies.
	 * 
	 * @return Array of valuables.
	 */
	public static List<Valuable> makeInternationalValuable() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeValuable("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeValuable("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeValuable("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/**
	 * Make a list of valuables using given values.
	 * 
	 * @param currency
	 *            is the currency of these new valuables.
	 * @param values
	 *            is the value of these new valuables.
	 * @return Array of new valuables.
	 */
	public static List<Valuable> makeValuable(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			if (value >= 20) {
				list.add(new BankNote(value, currency));
			} else {
				list.add(new Coin(value, currency));
			}
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
 * Create this class to compare two valuables by their currency to sort them by
 * the currency.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.12
 *
 */
class CompareByCurrency implements Comparator<Valuable> {
	/**
	 * @param c1
	 *            is the first valuable to compare.
	 * @param c2
	 *            is the second valuable to compare.
	 * @return -1 if the first valuable's currency is come first, 0 if they are
	 *         equal, 1 if the second valuable's currency is come first.
	 */
	@Override
	public int compare(Valuable c1, Valuable c2) {
		return c1.getCurrency().compareTo(c2.getCurrency());
	}
}