package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import coinpurse.Purse;

/**
 * A status bar for the purse shows the amount of the valuable in the
 * purse(sometimes it shows the status in a word e.g. FULL, EMPTY) and move the
 * progress bar follow the amount of valuable in the purse.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.21
 *
 */
public class PurseStatusObserver extends JFrame implements Observer {
	private JLabel label;
	private JProgressBar bar;

	/**
	 * initialize a new PurseStatusObserver
	 */
	public PurseStatusObserver() {
		super("Purse Status");
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
		bar = new JProgressBar(0, 10);
		add(bar, BorderLayout.SOUTH);
		this.setSize(300, 150);
		this.setLocation(1370, 400);
	}

	/**
	 * Start the UI(Make UI visible)
	 */
	public void run() {
		setVisible(true);
	}

	/**
	 * Update the UI to show the amount status of the purse when notified.
	 */
	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			int size = purse.count();
			int capacity = purse.getCapacity();
			bar.setMaximum(capacity);
			if (size == 0) {
				label.setText("EMPTY");
			} else if (size > 0 && size < capacity) {
				label.setText(size + "/" + capacity);
			} else if (size == capacity) {
				label.setText("FULL");
			}
			bar.setValue(size);
		}
	}
}
