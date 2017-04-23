package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import coinpurse.Purse;

/**
 * A UI that shows the presently balance of the purse.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.21
 *
 */
public class PurseBalanceObserver extends JFrame implements Observer {
	private JLabel label;

	/**
	 * initialize a new PurseBalanceObserver
	 */
	public PurseBalanceObserver() {
		super("Purse Balance");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	/**
	 * initialize and set the components.
	 */
	public void initComponent() {
		label = new JLabel("", SwingConstants.CENTER);
		label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		add(label, BorderLayout.CENTER);
		this.setSize(300, 100);
		this.setLocation(1370, 50);
	}

	/**
	 * Start the UI(Make UI visible)
	 */
	public void run() {
		setVisible(true);
	}

	/**
	 * Update the UI to show the purse's balance when notified.
	 */
	@Override
	public void update(Observable subject, Object info) {

		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			label.setText(purse.getBalance() + " Baht");
		}
	}
}
