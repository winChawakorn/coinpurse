package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import coinpurse.Valuable;

/**
 * A WithdrawStrategy that uses recursion to choose the money. This strategy
 * doesn't sort the money.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.30
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {
	/**
	 * @see WithdrawStrategy#withdraw(double, List)
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		if (amount == 0)
			return new ArrayList<Valuable>();
		if (amount < 0)
			return null;
		if (money.size() == 0) {
			if (amount == 0)
				return new ArrayList<Valuable>();
			return null;
		}
		List<Valuable> list = null;
		Valuable first = money.get(0);
		list = withdraw(amount - first.getValue(),
				money.subList(1, money.size()));
		if (list != null) {
			list.add(first);
			return list;
		}
		return withdraw(amount, money.subList(1, money.size()));
	}
}
