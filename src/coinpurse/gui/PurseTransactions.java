package coinpurse.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import coinpurse.Purse;

/**
 * A UI that shows all transactions of the purse.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.23
 *
 */
public class PurseTransactions extends JFrame implements Observer {
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	/**
	 * initialize new PurseTransactions.
	 */
	public PurseTransactions() {
		super("Purse Transactions");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	/**
	 * Initialize and set the components.
	 */
	private void initComponent() {
		model = new DefaultTableModel();
		model.addColumn("Date/Time");
		model.addColumn("Description");
		model.addColumn("Balance");
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		table.setFont(new Font(Font.MONOSPACED, NORMAL, 18));
		scrollPane.setMinimumSize(new Dimension(80, 30));
		this.add(scrollPane);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
		setSize(600, 200);
		setLocation(400, 0);
	}

	/**
	 * Start the UI(Make UI visible)
	 */
	public void run() {
		setVisible(true);
	}

	/**
	 * Add a row to the UI to show the purse's transactions when notified.
	 */
	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			DateFormat date = new SimpleDateFormat("HH:mm:ss");
			model.addRow(new String[] { date.format(new Date()) + "",
					info.toString(), purse.getBalance() + "" });
		}
	}

}
