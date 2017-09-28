package gui;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**Creates the "View" pannel with all the included elements
 * @author Marian
 *
 */
public class ViewPanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private JRadioButton radioParts, radioLocation, radioEmployee;
	private JLabel lblParts, lblLocation, lblEmployee;
	private ButtonGroup group;
	private JTextArea txfView;
	private JButton btnView, btnLogOut;

	public ViewPanel(MainGUI gui, ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		radioParts = new JRadioButton("Parts");
		radioParts.setBounds(150, 20, 150, 30);
		radioParts.setBackground(new Color(180, 200, 240));
		radioParts.setForeground(Color.BLACK);
		radioLocation = new JRadioButton("Locations");
		radioLocation.setBounds(400, 20, 150, 30);
		radioLocation.setForeground(Color.BLACK);
		radioLocation.setBackground(new Color(180, 200, 240));
		radioEmployee = new JRadioButton("Employees");
		radioEmployee.setBackground(new Color(180, 200, 240));
		radioEmployee.setForeground(Color.BLACK);
		radioEmployee.setBounds(650, 20, 150, 30);
		group = new ButtonGroup();
		group.add(radioParts);
		group.add(radioLocation);
		group.add(radioEmployee);
		add(radioParts);
		add(radioLocation);
		add(radioEmployee);

		txfView = new JTextArea();
		txfView.setBounds(50, 80, 790, 400);
		txfView.setEditable(false);
		add(txfView);

		btnView = new JButton("Display");
		btnView.setBounds(350, 500, 120, 25);
		btnView.addActionListener(actionlistener);
		btnView.setBackground(Color.BLACK);
		btnView.setForeground(Color.WHITE);
		add(btnView);

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

	}
	public JRadioButton getRadioParts() {
		return radioParts;
	}

	public void setRadioParts(JRadioButton radioParts) {
		this.radioParts = radioParts;
	}

	public JRadioButton getRadioLocation() {
		return radioLocation;
	}

	public void setRadioLocation(JRadioButton radioLocation) {
		this.radioLocation = radioLocation;
	}

	public JRadioButton getRadioEmployee() {
		return radioEmployee;
	}

	public void setRadioEmployee(JRadioButton radioEmployee) {
		this.radioEmployee = radioEmployee;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JTextArea getTxfView() {
		return txfView;
	}

	public void setTxfView(JTextArea txfView) {
		this.txfView = txfView;
	}

	public JButton getBtnView() {
		return btnView;
	}

	public void setBtnView(JButton btnView) {
		this.btnView = btnView;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}

}
