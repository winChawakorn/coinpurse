package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import coinpurse.Purse;

public class PurseBalanceObserver extends JFrame implements Observer {
	private JLabel label;

	// private JScrollPane scrollPane;

	public PurseBalanceObserver() {
		super("Purse Balance");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	public void initComponent() {
		label = new JLabel("", SwingConstants.CENTER);
		label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		add(label, BorderLayout.CENTER);
		this.setSize(300, 100);
		this.setLocation(1370, 50);
	}

	public void run() {
		setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		// if (info != null)
		// System.out.println(">>>>" + info);
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			// System.out.println("\nBalance is: " + balance);
			label.setText(purse.getBalance() + " Baht");
		}
	}
}
