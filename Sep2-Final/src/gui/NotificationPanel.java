package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**Creates the "Notification" pannel with all the included elements
 * @author Alexandru, Bogdan
 *
 */
public class NotificationPanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private JButton btnUpdateStock, btnLogOut;
	private JList jlistNotification;
	private JTextField txfStockField;
	private JScrollPane scrollDisplay;
	private JLabel lblRuningLow;
	private JButton btnRefresh;

	public NotificationPanel(MainGUI mainGUI, ButtonHandler buttonHandler) {

		this.setLayout(null);
		this.gui = gui;
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		txfStockField = new JTextField();
		txfStockField.setBounds(480, 20, 100, 25);
		add(txfStockField);

		
		btnUpdateStock = new JButton("Update stock");
		btnUpdateStock.setBounds(600, 20, 120, 25);
		btnUpdateStock.addActionListener(actionlistener);
		btnUpdateStock.setBackground(Color.BLACK);
		btnUpdateStock.setForeground(Color.WHITE);
		add(btnUpdateStock);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(750, 20, 100, 25);
		btnRefresh.addActionListener(actionlistener);
		btnRefresh.setBackground(Color.BLACK);
		btnRefresh.setForeground(Color.WHITE);
		add(btnRefresh);

		
		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

		jlistNotification = new JList<Object>();
		jlistNotification.addListSelectionListener(new SelectedObjAction());
		scrollDisplay = new JScrollPane(jlistNotification);
		scrollDisplay
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDisplay.setBounds(20, 50, 850, 440);
		add(scrollDisplay);

	}
	
	
	
	public JButton getBtnUpdateStock() {
		return btnUpdateStock;
	}

	public JButton getBtnRefreshNotification() {
		return btnRefresh;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JList getJlistNotification() {
		return jlistNotification;
	}

	public JTextField getTxfStockField() {
		return txfStockField;
	}

	public JScrollPane getScrollDisplay() {
		return scrollDisplay;
	}

	private class SelectedObjAction implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {

		}

	}
}
