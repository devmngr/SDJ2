package gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Creates the "create" pannel with all the included elements
 * 
 * @author Bogdan and Tomas
 *
 */
public class CreatePanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;

	private JLabel lblCreatePart, lblCreateEmployee;

	// creating part
	private JLabel lblPartId, lblShelf, lblBox, lblPartName, lblMake,
			lblDescription, lblCategory, lblNrOfParts;
	private JTextField txfPartId, txfShelf, txfBox, txfPartName, txfMake,
			txfDescription, txfCategory, txfNrOfParts;
	private JButton btnCreatePart;

	// creating employee
	private JLabel lblName, lblSSN, lblPhoneNr, lblMngSSN, lblUsername,
			lblPassword;
	private JTextField txfName, txfSSN, txfPhoneNr, txfMngSSn, txfUsername,
			txfPassword;
	private JButton btnCreateEmployee, btnLogOut;

	/**
	 * Builds the "create" pannel with all the included elements
	 * 
	 * @param gui
	 *            the gui object that allows access to the main GUI
	 * @param buttonHandler
	 */
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
		// Create a new Employee
		lblCreateEmployee = new JLabel("Create a new Employee:");
		lblCreateEmployee.setBounds(600, 20, 220, 25);
		lblCreateEmployee.setForeground(Color.BLACK);
		add(lblCreateEmployee);

		lblName = new JLabel("Name: ");
		lblName.setBounds(550, 80, 220, 25);
		add(lblName);

		txfName = new JTextField();
		txfName.setBounds(650, 80, 140, 25);
		txfName.setEditable(true);
		add(txfName);

		lblSSN = new JLabel("SSN: ");
		lblSSN.setBounds(550, 110, 220, 25);
		add(lblSSN);

		txfSSN = new JTextField();
		txfSSN.setBounds(650, 110, 140, 25);
		txfSSN.setEditable(true);
		add(txfSSN);

		lblPhoneNr = new JLabel("Phone number: ");
		lblPhoneNr.setBounds(550, 140, 220, 25);
		add(lblPhoneNr);

		txfPhoneNr = new JTextField();
		txfPhoneNr.setBounds(650, 140, 140, 25);
		txfPhoneNr.setEditable(true);
		add(txfPhoneNr);

		lblMngSSN = new JLabel("Manager SSN:");
		lblMngSSN.setBounds(550, 170, 220, 25);
		add(lblMngSSN);

		txfMngSSn = new JTextField();
		txfMngSSn.setBounds(650, 170, 140, 25);
		txfMngSSn.setEditable(true);
		add(txfMngSSn);

		lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(550, 200, 220, 25);
		add(lblUsername);

		txfUsername = new JTextField();
		txfUsername.setBounds(650, 200, 140, 25);
		txfUsername.setEditable(true);
		add(txfUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(550, 230, 220, 25);
		add(lblPassword);

		txfPassword = new JTextField();
		txfPassword.setBounds(650, 230, 140, 25);
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

	/**
	 * Returns part id field
	 * 
	 * @return
	 */
	public JTextField getTxfPartId() {
		return txfPartId;
	}

	/**
	 * Returns shelf field
	 * 
	 * @return
	 */
	public JTextField getTxfShelf() {
		return txfShelf;
	}

	/**
	 * Returns the box field
	 * 
	 * @return
	 */
	public JTextField getTxfBox() {
		return txfBox;
	}

	/**
	 * Returns the part name field
	 * 
	 * @return
	 */
	public JTextField getTxfPartName() {
		return txfPartName;
	}

	/**
	 * Returns make field
	 * 
	 * @return
	 */
	public JTextField getTxfMake() {
		return txfMake;
	}

	/**
	 * Returns description field
	 * 
	 * @return
	 */
	public JTextField getTxfDescription() {
		return txfDescription;
	}

	/**
	 * Returns the category
	 * 
	 * @return
	 */
	public JTextField getTxfCategory() {
		return txfCategory;
	}

	/**
	 * Returns the number of parts
	 * 
	 * @return
	 */
	public JTextField getTxfNrOfParts() {
		return txfNrOfParts;
	}

	/**
	 * Returns the employee name text
	 * 
	 * @return
	 */
	public JTextField getTxfName() {
		return txfName;
	}

	/**
	 * Returns the employee ssn text
	 * 
	 * @return
	 */
	public JTextField getTxfSSN() {
		return txfSSN;
	}

	/**
	 * Returns the employee phone nr text
	 * 
	 * @return
	 */
	public JTextField getTxfPhoneNr() {
		return txfPhoneNr;
	}

	/**
	 * Returns the employee manager ssn text
	 * 
	 * @return
	 */
	public JTextField getTxfMngSSn() {
		return txfMngSSn;
	}

	/**
	 * Returns the employee user name text
	 * 
	 * @return
	 */
	public JTextField getTxfUsername() {
		return txfUsername;
	}

	/**
	 * Returns the employee password text
	 * 
	 * @return
	 */
	public JTextField getTxfPassword() {
		return txfPassword;
	}

	/**
	 * Returns the create part button
	 * 
	 * @return
	 */
	public JButton getBtnCreatePart() {
		return btnCreatePart;
	}

	/**
	 * Returns the create employee button
	 * 
	 * @return
	 */
	public JButton getBtnCreateEmployee() {
		return btnCreateEmployee;
	}

	/**
	 * Returns the log out button
	 * 
	 * @return
	 */
	public JButton getBtnLogOut() {
		return btnLogOut;
	}
}
