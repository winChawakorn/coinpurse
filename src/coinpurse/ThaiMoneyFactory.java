package coinpurse;

import java.util.Arrays;
import java.util.List;

/**
 * A MoneyFactory for Thai money. Used to create the Baht coin, Satang coin, and
 * Baht bank note.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.02.26
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/** The next serial number of the bank note. */
	private long nextSerialNumber = 1000000;

	/**
	 * Create Thai money by primitive double. Filter the value to be able to
	 * create only specific coin, bank note, and currency(Baht and Satang).
	 * Throw IllegalArgumentException if it is the invalid coin or bank note
	 * value in the parameter.
	 */
	@Override
	Valuable createMoney(double value) {
		Double[] validCoin = { 1.0, 2.0, 5.0, 10.0, 0.25, 0.5 };
		Double[] validNote = { 20.0, 50.0, 100.0, 500.0, 1000.0 };
		List<Double> vc = Arrays.asList(validCoin);
		List<Double> vn = Arrays.asList(validNote);
		if (vc.contains(value)) {
			Coin c = new Coin(value);
			if (value <= 0.5) {
				c.setToString(value * 100, "Satang");
			}
			return c;
		} else if (vn.contains(value)) {
			BankNote b = new BankNote(value);
			b.setSerialNumber(++this.nextSerialNumber);
			return b;
		}
		throw new IllegalArgumentException();
	}
}
