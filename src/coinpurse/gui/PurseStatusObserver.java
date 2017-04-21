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

public class PurseStatusObserver extends JFrame implements Observer {
	private JLabel label;
	private JProgressBar bar;

	public PurseStatusObserver() {
		super("Purse Status");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	public void initComponent() {
		label = new JLabel("", SwingConstants.CENTER);
		label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		add(label, BorderLayout.CENTER);
		bar = new JProgressBar(0, 10);
		add(bar, BorderLayout.SOUTH);
		this.setSize(300, 150);
		this.setLocation(1370, 400);
	}

	public void run() {
		setVisible(true);
	}

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
