package gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Creates the "Edit" pannel with all the included elements
 * @author Tomas, Alexandru
 *
 */
public class EditPanel extends JPanel {

	private ButtonHandler actionlistener;
	private MainGUI gui;
	
	private JButton btnDeletePart, btnDeleteEmployee;

	private JButton btnSearchPart, btnSearchLocation, btnSearchEmployee,
			btnSavePart, btnSaveLocation, btnSaveEmployee, btnLogOut;
	private JLabel lblSearchPart, lblSearchLocationShelf, lblSearchLocationBox,
			lblSearchEmployee;
	private JTextField txfSearchPart, txfSearchLocationShelf,
			txfSearchLocationBox, txfSearchEmployee;

	// editing part
	private JLabel lblPartId, lblShelf, lblBox, lblPartName, lblMake,
			lblDescription, lblCategory, lblNrOfParts;
	private JTextField txfPartId, txfShelf, txfBox, txfPartName, txfMake,
			txfDescription, txfCategory, txfNrOfParts;

	// editing location;
	private JLabel lblShelfNr, lblBoxNr, lblLocationNrOfParts,
			lblLocationPartId;
	private JTextField txfShelfNr, txfBoxNr, txfLocationNrOfParts,
			txfLocationPartId;

	// editing employee
	private JLabel lblName, lblSSN, lblPhoneNr, lblMngSSN, lblUsername,
			lblPassword;
	private JTextField txfName, txfSSN, txfPhoneNr, txfMngSSn, txfUsername,
			txfPassword;

	public EditPanel(MainGUI gui, ButtonHandler buttonHandler) {
		this.setLayout(null);
		this.gui = gui;
		this.actionlistener = buttonHandler;
		this.setBackground(new Color(180, 200, 240));

		// Edit Part
		lblSearchPart = new JLabel("Part ID:");
		lblSearchPart.setBounds(10, 20, 220, 25);
		lblSearchPart.setForeground(Color.BLACK);
		add(lblSearchPart);

		txfSearchPart = new JTextField();
		txfSearchPart.setBounds(60, 20, 80, 25);
		txfSearchPart.setEditable(true);
		add(txfSearchPart);


		btnSearchPart = new JButton("Search Part");
		btnSearchPart.setBounds(150, 20, 140, 25);
		btnSearchPart.addActionListener(actionlistener);
		btnSearchPart.setBackground(Color.BLACK);
		btnSearchPart.setForeground(Color.WHITE);
		add(btnSearchPart);
	
		
		
		
		// Edit Location

		lblSearchLocationShelf = new JLabel("Shelf nr:");
		lblSearchLocationShelf.setBounds(300, 20, 220, 25);
		lblSearchLocationShelf.setForeground(Color.BLACK);
		add(lblSearchLocationShelf);

		txfSearchLocationShelf = new JTextField();
		txfSearchLocationShelf.setBounds(350, 20, 80, 25);
		txfSearchLocationShelf.setEditable(true);
		add(txfSearchLocationShelf);
		// txfSearchPart.setVisible(false);

		lblSearchLocationBox = new JLabel("Box nr:");
		lblSearchLocationBox.setBounds(300, 40, 220, 25);
		lblSearchLocationBox.setForeground(Color.BLACK);
		add(lblSearchLocationBox);

		txfSearchLocationBox = new JTextField();
		txfSearchLocationBox.setBounds(350, 40, 80, 25);
		txfSearchLocationBox.setEditable(true);
		add(txfSearchLocationBox);
		// txfSearchPart.setVisible(false);

		btnSearchLocation = new JButton("Search Location");
		btnSearchLocation.setBounds(440, 20, 140, 25);
		btnSearchLocation.addActionListener(actionlistener);
		btnSearchLocation.setBackground(Color.BLACK);
		btnSearchLocation.setForeground(Color.WHITE);
		add(btnSearchLocation);

		// Edit Employeee

		lblSearchEmployee = new JLabel("Employee SSN:");
		lblSearchEmployee.setBounds(590, 20, 220, 25);
		lblSearchEmployee.setForeground(Color.BLACK);
		add(lblSearchEmployee);

		txfSearchEmployee = new JTextField();
		txfSearchEmployee.setBounds(680, 20, 80, 25);
		txfSearchEmployee.setEditable(true);
		add(txfSearchEmployee);
		// txfSearchPart.setVisible(false);

		btnSearchEmployee = new JButton("Search Employee");
		btnSearchEmployee.setBounds(760, 20, 140, 25);
		btnSearchEmployee.addActionListener(actionlistener);
		btnSearchEmployee.setBackground(Color.BLACK);
		btnSearchEmployee.setForeground(Color.WHITE);
		add(btnSearchEmployee);

		// Edit Parts Text fields and labels

		lblPartId = new JLabel("Part Id:");
		lblPartId.setBounds(10, 80, 220, 25);
		add(lblPartId);
		lblPartId.setVisible(false);

		txfPartId = new JTextField();
		txfPartId.setBounds(130, 80, 140, 25);
		txfPartId.setEditable(false);
		add(txfPartId);
		txfPartId.setVisible(false);

		lblShelf = new JLabel("Shelf number:");
		lblShelf.setBounds(10, 110, 220, 25);
		add(lblShelf);
		lblShelf.setVisible(false);

		txfShelf = new JTextField();
		txfShelf.setBounds(130, 110, 140, 25);
		txfShelf.setEditable(true);
		add(txfShelf);
		txfShelf.setVisible(false);

		lblBox = new JLabel("Box number:");
		lblBox.setBounds(10, 140, 220, 25);
		add(lblBox);
		lblBox.setVisible(false);

		txfBox = new JTextField();
		txfBox.setBounds(130, 140, 140, 25);
		txfBox.setEditable(true);
		add(txfBox);
		txfBox.setVisible(false);

		lblPartName = new JLabel("Part name:");
		lblPartName.setBounds(10, 170, 220, 25);
		add(lblPartName);
		lblPartName.setVisible(false);

		txfPartName = new JTextField();
		txfPartName.setBounds(130, 170, 140, 25);
		txfPartName.setEditable(true);
		add(txfPartName);
		txfPartName.setVisible(false);

		lblMake = new JLabel("Make: ");
		lblMake.setBounds(10, 200, 220, 25);
		add(lblMake);
		lblMake.setVisible(false);

		txfMake = new JTextField();
		txfMake.setBounds(130, 200, 140, 25);
		txfMake.setEditable(true);
		add(txfMake);
		txfMake.setVisible(false);

		lblDescription = new JLabel("Description: ");
		lblDescription.setBounds(10, 230, 220, 25);
		add(lblDescription);
		lblDescription.setVisible(false);

		txfDescription = new JTextField();
		txfDescription.setBounds(130, 230, 140, 25);
		txfDescription.setEditable(true);
		add(txfDescription);
		txfDescription.setVisible(false);

		lblCategory = new JLabel("Category: ");
		lblCategory.setBounds(10, 260, 220, 25);
		add(lblCategory);
		lblCategory.setVisible(false);

		txfCategory = new JTextField();
		txfCategory.setBounds(130, 260, 140, 25);
		txfCategory.setEditable(true);
		add(txfCategory);
		txfCategory.setVisible(false);

		lblNrOfParts = new JLabel("Number of parts: ");
		lblNrOfParts.setBounds(10, 290, 220, 25);
		add(lblNrOfParts);
		lblNrOfParts.setVisible(false);

		txfNrOfParts = new JTextField();
		txfNrOfParts.setBounds(130, 290, 140, 25);
		txfNrOfParts.setEditable(true);
		add(txfNrOfParts);
		txfNrOfParts.setVisible(false);

		btnSavePart = new JButton("Save Part");
		btnSavePart.setBounds(150, 350, 140, 25);
		btnSavePart.addActionListener(actionlistener);
		btnSavePart.setBackground(Color.BLACK);
		btnSavePart.setForeground(Color.WHITE);
		add(btnSavePart);
		btnSavePart.setVisible(false);
		
		btnDeletePart = new JButton("Delete Part");
		btnDeletePart.setBounds(150, 400, 140, 25);
		btnDeletePart.addActionListener(actionlistener);
		btnDeletePart.setBackground(Color.BLACK);
		btnDeletePart.setForeground(Color.WHITE);
		add(btnDeletePart);
		btnDeletePart.setVisible(false);

		// Edit location --- Text fields and labels

		lblShelfNr = new JLabel("Shelf number: ");
		lblShelfNr.setBounds(300, 80, 220, 25);
		add(lblShelfNr);
		lblShelfNr.setVisible(false);

		txfShelfNr = new JTextField();
		txfShelfNr.setBounds(420, 80, 140, 25);
		txfShelfNr.setEditable(false);
		add(txfShelfNr);
		txfShelfNr.setVisible(false);

		lblBoxNr = new JLabel("Box number: ");
		lblBoxNr.setBounds(300, 110, 220, 25);
		add(lblBoxNr);
		lblBoxNr.setVisible(false);

		txfBoxNr = new JTextField();
		txfBoxNr.setBounds(420, 110, 140, 25);
		txfBoxNr.setEditable(false);
		add(txfBoxNr);
		txfBoxNr.setVisible(false);

		lblLocationNrOfParts = new JLabel("Nr of pats: ");
		lblLocationNrOfParts.setBounds(300, 140, 220, 25);
		add(lblLocationNrOfParts);
		lblLocationNrOfParts.setVisible(false);

		txfLocationNrOfParts = new JTextField();
		txfLocationNrOfParts.setBounds(420, 140, 140, 25);
		txfLocationNrOfParts.setEditable(true);
		add(txfLocationNrOfParts);
		txfLocationNrOfParts.setVisible(false);

		lblLocationPartId = new JLabel("Part Id: ");
		lblLocationPartId.setBounds(300, 170, 220, 25);
		add(lblLocationPartId);
		lblLocationPartId.setVisible(false);

		txfLocationPartId = new JTextField();
		txfLocationPartId.setBounds(420, 170, 140, 25);
		txfLocationPartId.setEditable(false);
		add(txfLocationPartId);
		txfLocationPartId.setVisible(false);

		btnSaveLocation = new JButton("Save Location");
		btnSaveLocation.setBounds(440, 350, 140, 25);
		btnSaveLocation.addActionListener(actionlistener);
		btnSaveLocation.setBackground(Color.BLACK);
		btnSaveLocation.setForeground(Color.WHITE);
		add(btnSaveLocation);
		btnSaveLocation.setVisible(false);
		


		// Edit Employee --- Text fields and labels

		lblName = new JLabel("Name: ");
		lblName.setBounds(600, 80, 220, 25);
		add(lblName);
		lblName.setVisible(false);

		txfName = new JTextField();
		txfName.setBounds(710, 80, 140, 25);
		txfName.setEditable(true);
		add(txfName);
		txfName.setVisible(false);

		lblSSN = new JLabel("SSN: ");
		lblSSN.setBounds(600, 110, 220, 25);
		add(lblSSN);
		lblSSN.setVisible(false);

		txfSSN = new JTextField();
		txfSSN.setBounds(710, 110, 140, 25);
		txfSSN.setEditable(true);
		add(txfSSN);
		txfSSN.setVisible(false);

		lblPhoneNr = new JLabel("Phone number: ");
		lblPhoneNr.setBounds(600, 140, 220, 25);
		add(lblPhoneNr);
		lblPhoneNr.setVisible(false);

		txfPhoneNr = new JTextField();
		txfPhoneNr.setBounds(710, 140, 140, 25);
		txfPhoneNr.setEditable(true);
		add(txfPhoneNr);
		txfPhoneNr.setVisible(false);

		lblMngSSN = new JLabel("Manager SSN:");
		lblMngSSN.setBounds(600, 170, 220, 25);
		add(lblMngSSN);
		lblMngSSN.setVisible(false);

		txfMngSSn = new JTextField();
		txfMngSSn.setBounds(710, 170, 140, 25);
		txfMngSSn.setEditable(true);
		add(txfMngSSn);
		txfMngSSn.setVisible(false);

		lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(600, 200, 220, 25);
		add(lblUsername);
		lblUsername.setVisible(false);

		txfUsername = new JTextField();
		txfUsername.setBounds(710, 200, 140, 25);
		txfUsername.setEditable(true);
		add(txfUsername);
		txfUsername.setVisible(false);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(600, 230, 220, 25);
		add(lblPassword);
		lblPassword.setVisible(false);

		txfPassword = new JTextField();
		txfPassword.setBounds(710, 230, 140, 25);
		txfPassword.setEditable(true);
		add(txfPassword);
		txfPassword.setVisible(false);

		btnSaveEmployee = new JButton("Save Employee");
		btnSaveEmployee.setBounds(760, 350, 140, 25);
		btnSaveEmployee.addActionListener(actionlistener);
		btnSaveEmployee.setBackground(Color.BLACK);
		btnSaveEmployee.setForeground(Color.WHITE);
		add(btnSaveEmployee);
		btnSaveEmployee.setVisible(false);
		
		
		btnDeleteEmployee = new JButton("Delete employee");
		btnDeleteEmployee.setBounds(760, 400, 140, 25);
		btnDeleteEmployee.addActionListener(actionlistener);
		btnDeleteEmployee.setBackground(Color.BLACK);
		btnDeleteEmployee.setForeground(Color.WHITE);
		add(btnDeleteEmployee);
		btnDeleteEmployee.setVisible(false);
		

		btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(750, 500, 100, 25);
		btnLogOut.addActionListener(actionlistener);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setForeground(Color.WHITE);
		add(btnLogOut);

	}

	public JButton getBtnSearchPart() {
		return btnSearchPart;
	}

	public JButton getBtnSearchLocation() {
		return btnSearchLocation;
	}

	public JButton getBtnSearchEmployee() {
		return btnSearchEmployee;
	}

	public JButton getBtnSavePart() {
		return btnSavePart;
	}

	public JButton getBtnSaveLocation() {
		return btnSaveLocation;
	}

	public JButton getBtnSaveEmployee() {
		return btnSaveEmployee;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JTextField getTxfSearchPart() {
		return txfSearchPart;
	}

	public JTextField getTxfSearchLocationShelf() {
		return txfSearchLocationShelf;
	}

	public JTextField getTxfSearchLocationBox() {
		return txfSearchLocationBox;
	}

	public JTextField getTxfSearchEmployee() {
		return txfSearchEmployee;
	}

	public JTextField getTxfPartId() {
		return txfPartId;
	}

	public JTextField getTxfShelf() {
		return txfShelf;
	}

	public JTextField getTxfBox() {
		return txfBox;
	}

	public JTextField getTxfPartName() {
		return txfPartName;
	}

	public JTextField getTxfMake() {
		return txfMake;
	}

	public JTextField getTxfDescription() {
		return txfDescription;
	}

	public JTextField getTxfCategory() {
		return txfCategory;
	}

	public JTextField getTxfNrOfParts() {
		return txfNrOfParts;
	}

	public JTextField getTxfShelfNr() {
		return txfShelfNr;
	}

	public JTextField getTxfBoxNr() {
		return txfBoxNr;
	}

	public JTextField getTxfLocationNrOfParts() {
		return txfLocationNrOfParts;
	}

	public JTextField getTxfLocationPartId() {
		return txfLocationPartId;
	}

	public JTextField getTxfName() {
		return txfName;
	}

	public JTextField getTxfSSN() {
		return txfSSN;
	}

	public JTextField getTxfPhoneNr() {
		return txfPhoneNr;
	}

	public JTextField getTxfMngSSn() {
		return txfMngSSn;
	}

	public JTextField getTxfUsername() {
		return txfUsername;
	}

	public JTextField getTxfPassword() {
		return txfPassword;
	}

	public JLabel getLblSearchPart() {
		return lblSearchPart;
	}

	public JLabel getLblSearchLocationShelf() {
		return lblSearchLocationShelf;
	}

	public JLabel getLblSearchLocationBox() {
		return lblSearchLocationBox;
	}

	public JLabel getLblSearchEmployee() {
		return lblSearchEmployee;
	}

	public JLabel getLblPartId() {
		return lblPartId;
	}

	public JLabel getLblShelf() {
		return lblShelf;
	}

	public JLabel getLblBox() {
		return lblBox;
	}

	public JLabel getLblPartName() {
		return lblPartName;
	}

	public JLabel getLblMake() {
		return lblMake;
	}

	public JLabel getLblDescription() {
		return lblDescription;
	}

	public JLabel getLblCategory() {
		return lblCategory;
	}

	public JLabel getLblNrOfParts() {
		return lblNrOfParts;
	}

	public JLabel getLblShelfNr() {
		return lblShelfNr;
	}

	public JLabel getLblBoxNr() {
		return lblBoxNr;
	}

	public JLabel getLblLocationNrOfParts() {
		return lblLocationNrOfParts;
	}

	public JLabel getLblLocationPartId() {
		return lblLocationPartId;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JLabel getLblSSN() {
		return lblSSN;
	}

	public JLabel getLblPhoneNr() {
		return lblPhoneNr;
	}

	public JLabel getLblMngSSN() {
		return lblMngSSN;
	}

	public JLabel getLblUsername() {
		return lblUsername;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public JButton getBtnDeletePart() {
		return btnDeletePart;
	}


	public JButton getBtnDeleteEmployee() {
		return btnDeleteEmployee;
	}
}
