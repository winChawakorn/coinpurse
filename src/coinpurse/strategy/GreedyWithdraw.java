package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;

/**
 * A WithdrawStrategy that uses the greedy solution to withdraw the money. This
 * strategy sorted the money in descending order.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.30
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	/**
	 * @see WithdrawStrategy#withdraw(double, List)
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		money.sort(new Comparator<Valuable>() {
			@Override
			public int compare(Valuable c1, Valuable c2) {
				return (int) Math.signum(c2.getValue() - c1.getValue());
			}
		});
		List<Valuable> usedMoney = new ArrayList<Valuable>();
		for (Valuable v : money) {
			if (v.getValue() <= amount) {
				amount -= v.getValue();
				usedMoney.add(v);
			}
		}
		if (amount > 0) {
			return null;
		}
		return usedMoney;
	}
}
