package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.ObjectInputStream.GetField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * A UI that shows the list of the valuable in the purse at that time.
 * 
 * @author Chawakorn Suphepre
 * @version 2017.04.23
 *
 */
public class PurseListModel extends AbstractListModel<Valuable> implements
		Observer {
	private Purse purse;
	private JFrame frame;
	private ListModel<Valuable> listModel;
	private JList<Valuable> listview;
	private int size;
	private JScrollPane scrollPane;

	/**
	 * Initialize a new PurseListModel.
	 * 
	 * @param purse
	 *            is the purse to get the information.
	 */
	public PurseListModel(Purse purse) {
		this.purse = purse;
		this.size = purse.count();
		frame = new JFrame("Purse Content");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * initialize and set the components.
	 */
	private void initComponent() {
		listModel = new PurseListModel(purse);
		listview = new JList<Valuable>(listModel);
		listview.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		scrollPane = new JScrollPane(listview);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(400, 340);
	}

	/**
	 * Start the UI(Make UI visible)
	 */
	public void run() {
		initComponent();
		this.frame.setVisible(true);
	}

	/**
	 * See also the method {@link AbstractListModel#getSize()}
	 */
	@Override
	public int getSize() {
		return purse.count();
	}

	/**
	 * See also the method {@link AbstractListModel#getElementAt(int)}
	 */
	@Override
	public Valuable getElementAt(int index) {
		return purse.getList().get(index);
	}

	/**
	 * Update the UI to show the list of the valuables in the purse when
	 * notified.
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.size = getSize();
		fireContentsChanged(this, 0, size);
		listview.setModel(this);
		// for (int i = 0; i < listModel.getSize(); i++) {
		// System.out.println("\n              "
		// + listModel.getElementAt(i));
		// }
		// Valuable[] v = purse.getList().toArray(new Valuable[0]);
		// System.out.println("\n updated=================");
		// listview.setListData(v);
	}
}
