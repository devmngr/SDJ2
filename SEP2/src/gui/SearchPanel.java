package gui;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private ButtonGroup group;
	private JRadioButton radioPartId, radioName, radioCategory, radioLocation;
	private JButton btnSearch, btnLogOut, btnDelete;
	private TextArea txfDisplay;
	JTextField txfSearch;

	public SearchPanel(MainGUI gui,ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		radioPartId = new JRadioButton("Insert part ID");
		radioPartId.setBounds(20, 20, 100, 25);
		radioPartId.setForeground(Color.BLACK);
		radioPartId.setBackground(new Color(180, 200, 240));
		radioName = new JRadioButton("Name");
		radioName.setBounds(120, 20, 75, 25);
		radioName.setForeground(Color.BLACK);
		radioName.setBackground(new Color(180, 200, 240));
		radioCategory = new JRadioButton("Category");
		radioCategory.setBounds(200, 20, 100, 25);
		radioCategory.setForeground(Color.BLACK);
		radioCategory.setBackground(new Color(180, 200, 240));
		radioLocation = new JRadioButton("Location");
		radioLocation.setBounds(320, 20, 75, 25);
		radioLocation.setForeground(Color.BLACK);
		radioLocation.setBackground(new Color(180, 200, 240));

		group = new ButtonGroup();
		group.add(radioPartId);
		group.add(radioName);
		group.add(radioCategory);
		group.add(radioLocation);
		add(radioPartId);
		add(radioName);
		add(radioCategory);
		add(radioLocation);

		txfSearch = new JTextField();
		txfSearch.setBounds(450, 20, 100, 25);
		add(txfSearch);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(600, 20, 100, 25);
		btnSearch.addActionListener(actionlistener);
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		add(btnSearch);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(750, 20, 100, 25);
		btnDelete.addActionListener(actionlistener);
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setForeground(Color.WHITE);
		add(btnDelete);

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

		txfDisplay = new TextArea();
		txfDisplay.setBounds(20, 50, 850, 440);
		add(txfDisplay);

	}
	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public JRadioButton getRadioPartId() {
		return radioPartId;
	}

	public void setRadioPartId(JRadioButton radioPartId) {
		this.radioPartId = radioPartId;
	}

	public JRadioButton getRadioName() {
		return radioName;
	}

	public void setRadioName(JRadioButton radioName) {
		this.radioName = radioName;
	}

	public JRadioButton getRadioCategory() {
		return radioCategory;
	}

	public void setRadioCategory(JRadioButton radioCategory) {
		this.radioCategory = radioCategory;
	}

	public JRadioButton getRadioLocation() {
		return radioLocation;
	}

	public void setRadioLocation(JRadioButton radioLocation) {
		this.radioLocation = radioLocation;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public TextArea getTxfDisplay() {
		return txfDisplay;
	}

	public void setTxfDisplay(TextArea txfDisplay) {
		this.txfDisplay = txfDisplay;
	}
}
