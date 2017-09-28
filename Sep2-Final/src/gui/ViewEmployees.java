package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import model.Employee;

/**Creates the "View Employees" pannel with all the included elements
 * @author Marian, Bogdan
 *
 */
public class ViewEmployees extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;
	private JList<Employee> jlistEmployee;
	private JScrollPane scrollPaneEmployee;
	private JLabel lblSsn, lblName, lblMngrSsn, lblPhoneNr, lblUsername,
			lblPassword;
	private JButton btnRefresh, btnLogOut;

	public ViewEmployees(MainGUI gui, ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		jlistEmployee = new JList<Employee>();

		jlistEmployee.addListSelectionListener(new SelectedPartAction());

		scrollPaneEmployee = new JScrollPane(jlistEmployee);
		scrollPaneEmployee
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneEmployee.setBounds(20, 85, 850, 410);
		jlistEmployee.setFont(new Font("monospaced", Font.ROMAN_BASELINE, 11));
		add(scrollPaneEmployee);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(400, 20, 100, 25);
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

		lblSsn = new JLabel("SSN");
		lblSsn.setBounds(20, 60, 100, 25);
		lblSsn.setForeground(Color.BLACK);
		add(lblSsn);

		lblName = new JLabel("Name");
		lblName.setBounds(160, 60, 100, 25);
		lblName.setForeground(Color.BLACK);
		add(lblName);

		lblMngrSsn = new JLabel("Manager SSN");
		lblMngrSsn.setBounds(300, 60, 100, 25);
		lblMngrSsn.setForeground(Color.BLACK);
		add(lblMngrSsn);

		lblPhoneNr = new JLabel("Phone nr.");
		lblPhoneNr.setBounds(440, 60, 100, 25);
		lblPhoneNr.setForeground(Color.BLACK);
		add(lblPhoneNr);

		lblUsername = new JLabel("Username");
		lblUsername.setBounds(580, 60, 100, 25);
		lblUsername.setForeground(Color.BLACK);
		add(lblUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(720, 60, 100, 25);
		lblPassword.setForeground(Color.BLACK);
		add(lblPassword);
	}

	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JList<Employee> getJlistEmployee() {
		return jlistEmployee;
	}

	public JScrollPane getScrollPaneEmployee() {
		return scrollPaneEmployee;
	}

	private class SelectedPartAction implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {

		}
	}

}
