package coinpurse;

import java.util.Arrays;
import java.util.List;

/**
 * A MoneyFactory for Malaysian money. Used to create the Sen coin,and Ringgit
 * bank note.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.03.29
 */
public class MalayMoneyFactory extends MoneyFactory {
	/** The next serial number of the bank note. */
	private long nextSerialNumber = 1000000;

	/**
	 * Create Malaysian money by primitive double. Filter the value to be able
	 * to create only specific coin, bank note, and currency(Sen and Ringgit).
	 * Throw IllegalArgumentException if it is the invalid coin or bank note
	 * value in the parameter.
	 * */
	@Override
	Valuable createMoney(double value) {
		Double[] validCoin = { 0.05, 0.1, 0.2, 0.5 };
		Double[] validNote = { 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0 };
		List<Double> vc = Arrays.asList(validCoin);
		List<Double> vn = Arrays.asList(validNote);
		if (vc.contains(value)) {
			Coin c = new Coin(value, "Ringgit");
			c.setToString(value * 100, "Sen");
			return c;
		} else if (vn.contains(value)) {
			BankNote b = new BankNote(value, "Ringgit");
			b.setSerialNumber(++this.nextSerialNumber);
			return b;
		}
		throw new IllegalArgumentException();
	}
}
