package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rmi.RmiClient;

public class CreatePanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private JLabel lblCreatePart, lblCreateLocation, lblCreateEmployee;

	// creating part
	private JLabel lblPartId, lblShelf, lblBox, lblPartName, lblMake,
			lblDescription, lblCategory, lblNrOfParts;
	private JTextField txfPartId, txfShelf, txfBox, txfPartName, txfMake,
			txfDescription, txfCategory, txfNrOfParts;
	private JButton btnCreatePart;

	// creating location;
	private JLabel lblShelfNr, lblBoxNr;
	private JTextField txfShelfNr, txfBoxNr;
	private JButton btnCreateLocation;

	// creating employee
	private JLabel lblName, lblSSN, lblPhoneNr, lblMngSSN, lblUsername,
			lblPassword;
	private JTextField txfName, txfSSN, txfPhoneNr, txfMngSSn, txfUsername,
			txfPassword;
	private JButton btnCreateEmployee, btnLogOut;

	public CreatePanel(MainGUI gui, ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		// Create a new Part
		lblCreatePart = new JLabel("Create a new Part: ");
		lblCreatePart.setBounds(100, 20, 220, 25);
		lblCreatePart.setForeground(Color.BLACK);
		add(lblCreatePart);

		lblPartId = new JLabel("Part Id:");
		lblPartId.setBounds(60, 80, 220, 25);
		add(lblPartId);

		txfPartId = new JTextField();
		txfPartId.setBounds(180, 80, 140, 25);
		txfPartId.setEditable(true);
		add(txfPartId);

		lblShelf = new JLabel("Shelf number:");
		lblShelf.setBounds(60, 110, 220, 25);
		add(lblShelf);

		txfShelf = new JTextField();
		txfShelf.setBounds(180, 110, 140, 25);
		txfShelf.setEditable(true);
		add(txfShelf);

		lblBox = new JLabel("Box number:");
		lblBox.setBounds(60, 140, 220, 25);
		add(lblBox);

		txfBox = new JTextField();
		txfBox.setBounds(180, 140, 140, 25);
		txfBox.setEditable(true);
		add(txfBox);

		lblPartName = new JLabel("Part name:");
		lblPartName.setBounds(60, 170, 220, 25);
		add(lblPartName);

		txfPartName = new JTextField();
		txfPartName.setBounds(180, 170, 140, 25);
		txfPartName.setEditable(true);
		add(txfPartName);

		lblMake = new JLabel("Make: ");
		lblMake.setBounds(60, 200, 220, 25);
		add(lblMake);

		txfMake = new JTextField();
		txfMake.setBounds(180, 200, 140, 25);
		txfMake.setEditable(true);
		add(txfMake);

		lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(60, 230, 220, 25);
		add(lblDescription);

		txfDescription = new JTextField();
		txfDescription.setBounds(180, 230, 140, 25);
		txfDescription.setEditable(true);
		add(txfDescription);

		lblCategory = new JLabel("Category: ");
		lblCategory.setBounds(60, 260, 220, 25);
		add(lblCategory);

		txfCategory = new JTextField();
		txfCategory.setBounds(180, 260, 140, 25);
		txfCategory.setEditable(true);
		add(txfCategory);

		lblNrOfParts = new JLabel("Number of parts: ");
		lblNrOfParts.setBounds(60, 290, 220, 25);
		add(lblNrOfParts);

		txfNrOfParts = new JTextField();
		txfNrOfParts.setBounds(180, 290, 140, 25);
		txfNrOfParts.setEditable(true);
		add(txfNrOfParts);

		btnCreatePart = new JButton("Create a Part");
		btnCreatePart.setBounds(180, 400, 140, 25);
		btnCreatePart.addActionListener(actionlistener);
		btnCreatePart.setBackground(Color.BLACK);
		btnCreatePart.setForeground(Color.WHITE);
		add(btnCreatePart);

		// Create a new Location
		lblCreateLocation = new JLabel("Create a new Location:");
		lblCreateLocation.setBounds(600, 20, 220, 25);
		lblCreateLocation.setForeground(Color.BLACK);
		add(lblCreateLocation);

		lblShelfNr = new JLabel("Shelf number: ");
		lblShelfNr.setBounds(550, 80, 220, 25);
		add(lblShelfNr);

		txfShelfNr = new JTextField();
		txfShelfNr.setBounds(650, 80, 140, 25);
		txfShelfNr.setEditable(true);
		add(txfShelfNr);

		lblBoxNr = new JLabel("Box number: ");
		lblBoxNr.setBounds(550, 110, 220, 25);
		add(lblBoxNr);

		txfBoxNr = new JTextField();
		txfBoxNr.setBounds(650, 110, 140, 25);
		txfBoxNr.setEditable(true);
		add(txfBoxNr);

		btnCreateLocation = new JButton("Create Location");
		btnCreateLocation.setBounds(650, 140, 140, 25);
		btnCreateLocation.addActionListener(actionlistener);
		btnCreateLocation.setBackground(Color.BLACK);
		btnCreateLocation.setForeground(Color.WHITE);
		add(btnCreateLocation);

		// Create a new Employee
		lblCreateEmployee = new JLabel("Create a new Employee:");
		lblCreateEmployee.setBounds(600, 170, 220, 25);
		lblCreateEmployee.setForeground(Color.BLACK);
		add(lblCreateEmployee);

		lblName = new JLabel("Name: ");
		lblName.setBounds(550, 200, 220, 25);
		add(lblName);

		txfName = new JTextField();
		txfName.setBounds(650, 200, 140, 25);
		txfName.setEditable(true);
		add(txfName);

		lblSSN = new JLabel("SSN: ");
		lblSSN.setBounds(550, 230, 220, 25);
		add(lblSSN);

		txfSSN = new JTextField();
		txfSSN.setBounds(650, 230, 140, 25);
		txfSSN.setEditable(true);
		add(txfSSN);

		lblPhoneNr = new JLabel("Phone number: ");
		lblPhoneNr.setBounds(550, 260, 220, 25);
		add(lblPhoneNr);

		txfPhoneNr = new JTextField();
		txfPhoneNr.setBounds(650, 260, 140, 25);
		txfPhoneNr.setEditable(true);
		add(txfPhoneNr);

		lblMngSSN = new JLabel("Manager SSN:");
		lblMngSSN.setBounds(550, 290, 220, 25);
		add(lblMngSSN);

		txfMngSSn = new JTextField();
		txfMngSSn.setBounds(650, 290, 140, 25);
		txfMngSSn.setEditable(true);
		add(txfMngSSn);

		lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(550, 320, 220, 25);
		add(lblUsername);

		txfUsername = new JTextField();
		txfUsername.setBounds(650, 320, 140, 25);
		txfUsername.setEditable(true);
		add(txfUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(550, 350, 220, 25);
		add(lblPassword);

		txfPassword = new JTextField();
		txfPassword.setBounds(650, 350, 140, 25);
		txfPassword.setEditable(true);
		add(txfPassword);

		btnCreateEmployee = new JButton("Create Employee");
		btnCreateEmployee.setBounds(650, 400, 140, 25);
		btnCreateEmployee.addActionListener(actionlistener);
		btnCreateEmployee.setBackground(Color.BLACK);
		btnCreateEmployee.setForeground(Color.WHITE);
		add(btnCreateEmployee);

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

	}

	public JTextField getTxfPartId() {
		return txfPartId;
	}

	public void setTxfPartId(JTextField txfPartId) {
		this.txfPartId = txfPartId;
	}

	public JTextField getTxfShelf() {
		return txfShelf;
	}

	public void setTxfShelf(JTextField txfShelf) {
		this.txfShelf = txfShelf;
	}

	public JTextField getTxfBox() {
		return txfBox;
	}

	public void setTxfBox(JTextField txfBox) {
		this.txfBox = txfBox;
	}

	public JTextField getTxfPartName() {
		return txfPartName;
	}

	public void setTxfPartName(JTextField txfPartName) {
		this.txfPartName = txfPartName;
	}

	public JTextField getTxfMake() {
		return txfMake;
	}

	public void setTxfMake(JTextField txfMake) {
		this.txfMake = txfMake;
	}

	public JTextField getTxfDescription() {
		return txfDescription;
	}

	public void setTxfDescription(JTextField txfDescription) {
		this.txfDescription = txfDescription;
	}

	public JTextField getTxfCategory() {
		return txfCategory;
	}

	public void setTxfCategory(JTextField txfCategory) {
		this.txfCategory = txfCategory;
	}

	public JTextField getTxfNrOfParts() {
		return txfNrOfParts;
	}

	public void setTxfNrOfParts(JTextField txfNrOfParts) {
		this.txfNrOfParts = txfNrOfParts;
	}

	public JButton getBtnCreatePart() {
		return btnCreatePart;
	}

	public void setBtnCreatePart(JButton btnCreatePart) {
		this.btnCreatePart = btnCreatePart;
	}

	public JTextField getTxfShelfNr() {
		return txfShelfNr;
	}

	public void setTxfShelfNr(JTextField txfShelfNr) {
		this.txfShelfNr = txfShelfNr;
	}

	public JTextField getTxfBoxNr() {
		return txfBoxNr;
	}

	public void setTxfBoxNr(JTextField txfBoxNr) {
		this.txfBoxNr = txfBoxNr;
	}

	public JButton getBtnCreateLocation() {
		return btnCreateLocation;
	}

	public void setBtnCreateLocation(JButton btnCreateLocation) {
		this.btnCreateLocation = btnCreateLocation;
	}

	public JTextField getTxfName() {
		return txfName;
	}

	public void setTxfName(JTextField txfName) {
		this.txfName = txfName;
	}

	public JTextField getTxfSSN() {
		return txfSSN;
	}

	public void setTxfSSN(JTextField txfSSN) {
		this.txfSSN = txfSSN;
	}

	public JTextField getTxfPhoneNr() {
		return txfPhoneNr;
	}

	public void setTxfPhoneNr(JTextField txfPhoneNr) {
		this.txfPhoneNr = txfPhoneNr;
	}

	public JTextField getTxfMngSSn() {
		return txfMngSSn;
	}

	public void setTxfMngSSn(JTextField txfMngSSn) {
		this.txfMngSSn = txfMngSSn;
	}

	public JTextField getTxfUsername() {
		return txfUsername;
	}

	public void setTxfUsername(JTextField txfUsername) {
		this.txfUsername = txfUsername;
	}

	public JTextField getTxfPassword() {
		return txfPassword;
	}

	public void setTxfPassword(JTextField txfPassword) {
		this.txfPassword = txfPassword;
	}

	public JButton getBtnCreateEmployee() {
		return btnCreateEmployee;
	}

	public void setBtnCreateEmployee(JButton btnCreateEmployee) {
		this.btnCreateEmployee = btnCreateEmployee;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}
}
