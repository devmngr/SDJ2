package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.Employee;
import model.Log;
import model.Part;
import rmi.RmiClient;

/**
 * The actions for every button on the interface.
 * 
 * @author Bogdan, Alexandru, Tomas
 *
 */
public class ButtonHandler implements ActionListener {

	private MainGUI gui;
	private RmiClient client;
	private final String MANAGER = "manager";
	private final String EMPLOYEE = "employee";

	/**
	 * Constructor gives access to the guy and to the RmiClient class
	 * 
	 * @param gui
	 * @param client
	 */
	public ButtonHandler(MainGUI gui, RmiClient client) {
		this.gui = gui;
		this.client = client;

	}

	/*
	 * All the actions performed by the buttons Create part, Edit part, Create
	 * employee, Edit employee, Create location, Edit location, Login, Logout,
	 * Search Part, Search Employee, Search Location (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		// /////////////////
		// //CreatePanel////
		// /////////////////
		if (e.getSource() == gui.getCreatePanel().getBtnCreatePart()) {

			if (!gui.getCreatePanel().getTxfPartId().getText().equals("")
					|| !gui.getCreatePanel().getTxfPartName().getText()
							.equals("")
					|| !gui.getCreatePanel().getTxfMake().getText().equals("")
					|| !gui.getCreatePanel().getTxfDescription().getText()
							.equals("")
					|| !gui.getCreatePanel().getTxfCategory().getText()
							.equals("")
					|| !gui.getCreatePanel().getTxfNrOfParts().getText()
							.equals("")
					|| !gui.getCreatePanel().getTxfShelf().getText().equals("")
					|| !gui.getCreatePanel().getTxfBox().getText().equals("")) {
				try {
					client.addPart(gui.getCreatePanel().getTxfPartId()
							.getText(), gui.getCreatePanel().getTxfPartName()
							.getText(), gui.getCreatePanel().getTxfMake()
							.getText(), gui.getCreatePanel()
							.getTxfDescription().getText(), gui
							.getCreatePanel().getTxfCategory().getText(), gui
							.getCreatePanel().getTxfNrOfParts().getText(), gui
							.getCreatePanel().getTxfShelf().getText(), gui
							.getCreatePanel().getTxfBox().getText());

					gui.getCreatePanel().getTxfPartId().setText("");
					gui.getCreatePanel().getTxfPartName().setText("");
					gui.getCreatePanel().getTxfMake().setText("");
					gui.getCreatePanel().getTxfDescription().setText("");
					gui.getCreatePanel().getTxfCategory().setText("");
					gui.getCreatePanel().getTxfNrOfParts().setText("");
					gui.getCreatePanel().getTxfShelf().setText("");
					gui.getCreatePanel().getTxfBox().setText("");

					gui.popUp("Part added successfull");
				} catch (RemoteException e1) {
					e1.printStackTrace();
					gui.popUp("Something went wrong");
				} catch (Exception e2) {
					e2.printStackTrace();
					gui.popUp(e2.getMessage());
				}
			} else
				gui.popUp("Please fill all the part fields");
		}

		else if (e.getSource() == gui.getCreatePanel().getBtnCreateEmployee()) {

			if (DataCheck.CheckSSN(gui.getCreatePanel().getTxfSSN().getText(),
					gui)
					&& DataCheck.CheckSSN(gui.getCreatePanel().getTxfMngSSn()
							.getText(), gui)) {

				try {
					client.addEmployeeWithUser(gui.getCreatePanel()
							.getTxfName().getText(), gui.getCreatePanel()
							.getTxfSSN().getText(), gui.getCreatePanel()
							.getTxfPhoneNr().getText(), gui.getCreatePanel()
							.getTxfMngSSn().getText(), gui.getCreatePanel()
							.getTxfUsername().getText(), gui.getCreatePanel()
							.getTxfPassword().getText());

					gui.getCreatePanel().getTxfName().setText("");
					gui.getCreatePanel().getTxfSSN().setText("");
					gui.getCreatePanel().getTxfPhoneNr().setText("");
					gui.getCreatePanel().getTxfMngSSn().setText("");
					gui.getCreatePanel().getTxfUsername().setText("");
					gui.getCreatePanel().getTxfPassword().setText("");

					gui.popUp("Employee added successfully");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {

					e1.printStackTrace();
					gui.popUp(e1.getMessage());
				}

			}
		}
		// /////////////////
		// //EditPanel/////
		// /////////////////

		// Search Employee
		else if (e.getSource() == gui.getEditPanel().getBtnSearchEmployee()) {

			// needs a check if the ssn is correct or if it is complete
			gui.hideEditPart();
			gui.hideEditLocation();
			String temp = gui.getEditPanel().getTxfSearchEmployee().getText();
			try {
				if (client.getEmployeeBySSN(Long.parseLong(temp)) != null
						&& DataCheck.CheckSSN(temp, gui)) {
					gui.showEditEmployee();
					gui.getEditPanel()
							.getTxfSSN()
							.setText(
									client.getEmployeeBySSN(
											Long.parseLong(temp)).getSsn()
											+ "");
					gui.getEditPanel()
							.getTxfName()
							.setText(
									client.getEmployeeBySSN(
											Long.parseLong(temp)).getName()
											+ "");
					gui.getEditPanel()
							.getTxfPhoneNr()
							.setText(
									client.getEmployeeBySSN(
											Long.parseLong(temp)).getPhoneNr()
											+ "");
					gui.getEditPanel()
							.getTxfMngSSn()
							.setText(
									client.getEmployeeBySSN(
											Long.parseLong(temp)).getMngrSSN()
											+ "");
					gui.getEditPanel()
							.getTxfUsername()
							.setText(
									client.getEmployeeBySSN(
											Long.parseLong(temp)).getUsername()
											+ "");
					gui.getEditPanel()
							.getTxfPassword()
							.setText(
									client.getEmployeeBySSN(
											Long.parseLong(temp)).getPassword()
											+ "");
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException | RemoteException | SQLException e1) {
				e1.printStackTrace();
				gui.popUp("Please insert a valid employee SSN");
			}
			gui.getEditPanel().getTxfSearchEmployee().setText("");

			// /Search Location
		} else if (e.getSource() == gui.getEditPanel().getBtnSearchLocation()) {
			gui.hideEditEmployee();
			gui.hideEditPart();

			try {

				String tempBox = gui.getEditPanel().getTxfSearchLocationBox()
						.getText();
				String tempShelf = gui.getEditPanel()
						.getTxfSearchLocationShelf().getText();

				int tempBoxInt = 0;
				int tempShelfInt = 0;
				try {
					tempBoxInt = Integer.parseInt(tempBox);
					tempShelfInt = Integer.parseInt(tempShelf);
				} catch (Exception e2) {
					throw new Exception(
							"Please fill in the fields with valid data");
				}

				if (client.getLocationByShelfAndBox(tempShelfInt, tempBoxInt) != null) {
					gui.showEditLocation();

					gui.getEditPanel()
							.getTxfShelfNr()
							.setText(
									client.getLocationByShelfAndBox(
											tempShelfInt, tempBoxInt)
											.getShelfNr()
											+ "");
					gui.getEditPanel()
							.getTxfBoxNr()
							.setText(
									client.getLocationByShelfAndBox(
											tempShelfInt, tempBoxInt).getBox()
											+ "");
					Part tempPart = client
							.getPartByLocation(client.getLocationByShelfAndBox(
									tempShelfInt, tempBoxInt));
					gui.getEditPanel().getTxfLocationNrOfParts()
							.setText(tempPart.getNrOfParts() + "");
					gui.getEditPanel().getTxfLocationPartId()
							.setText(tempPart.getPartID() + "");
				} else
					gui.popUp("Specified location does not exist");
			} catch (IllegalArgumentException e1) {

				e1.printStackTrace();
			} catch (RemoteException e1) {

				e1.printStackTrace();
			} catch (SQLException e1) {

				e1.printStackTrace();
			} catch (NullPointerException e1) {
				e1.printStackTrace();
				gui.popUp("Please fill in the location fields");
			} catch (Exception e1) {
				e1.printStackTrace();
				gui.popUp(e1.getMessage());
			}

			gui.getEditPanel().getTxfSearchLocationBox().setText("");
			gui.getEditPanel().getTxfSearchLocationShelf().setText("");

			// //Search part
		} else if (e.getSource() == gui.getEditPanel().getBtnSearchPart()) {

			try {
				gui.hideEditEmployee();
				gui.hideEditLocation();
				int partid = Integer.parseInt(gui.getEditPanel()
						.getTxfSearchPart().getText());
				if (client.getPartById(partid) != null) {
					gui.showEditPart();
					gui.getEditPanel()
							.getTxfPartId()
							.setText(
									client.getPartById(partid).getPartID() + "");
					gui.getEditPanel()
							.getTxfShelf()
							.setText(
									client.getPartById(partid).getShelfNr()
											+ "");
					gui.getEditPanel().getTxfBox()
							.setText(client.getPartById(partid).getBox() + "");
					gui.getEditPanel().getTxfPartName()
							.setText(client.getPartById(partid).getName());
					gui.getEditPanel().getTxfMake()
							.setText(client.getPartById(partid).getMake());
					gui.getEditPanel()
							.getTxfDescription()
							.setText(
									client.getPartById(partid).getDescription());
					gui.getEditPanel().getTxfCategory()
							.setText(client.getPartById(partid).getCategory());
					gui.getEditPanel()
							.getTxfNrOfParts()
							.setText(
									client.getPartById(partid).getNrOfParts()
											+ "");
				} else
					gui.popUp("Searched part does not exist");
			} catch (IllegalArgumentException | RemoteException | SQLException e1) {
				e1.printStackTrace();
				gui.popUp("Please insert a valid part Id");
			}
			gui.getEditPanel().getTxfSearchPart().setText("");

			// ///////Update employee
		} else if (e.getSource() == gui.getEditPanel().getBtnSaveEmployee()) {
			if (DataCheck.CheckSSN(gui.getEditPanel().getTxfSSN().getText(),
					gui)
					&& DataCheck.CheckSSN(gui.getEditPanel().getTxfMngSSn()
							.getText(), gui)) {
				try {
					client.updateEmployeeWithUser(gui.getEditPanel()
							.getTxfName().getText(), gui.getEditPanel()
							.getTxfSSN().getText(), gui.getEditPanel()
							.getTxfPhoneNr().getText(), gui.getEditPanel()
							.getTxfMngSSn().getText(), gui.getEditPanel()
							.getTxfUsername().getText(), gui.getEditPanel()
							.getTxfPassword().getText());

					gui.getEditPanel().getTxfName().setText("");
					gui.getEditPanel().getTxfSSN().setText("");
					gui.getEditPanel().getTxfPhoneNr().setText("");
					gui.getEditPanel().getTxfMngSSn().setText("");
					gui.getEditPanel().getTxfUsername().setText("");
					gui.getEditPanel().getTxfPassword().setText("");

					gui.popUp("Employee updated successfully");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {

					e1.printStackTrace();
					gui.popUp(e1.getMessage());
				}
			}

			// /Update Location
		} else if (e.getSource() == gui.getEditPanel().getBtnSaveLocation()) {

			try {

				DataCheck.CheckLongData(gui.getEditPanel()
						.getTxfLocationNrOfParts().getText(), gui);

				client.updateLocation(gui.getEditPanel().getTxfShelfNr()
						.getText(), gui.getEditPanel().getTxfBoxNr().getText(),
						gui.getEditPanel().getTxfLocationNrOfParts().getText(),
						gui.getEditPanel().getTxfLocationPartId().getText());

				gui.getEditPanel().getTxfShelfNr().setText("");
				gui.getEditPanel().getTxfBoxNr().setText("");
				gui.getEditPanel().getTxfLocationNrOfParts().setText("");
				gui.getEditPanel().getTxfLocationPartId().setText("");

				gui.popUp("Location updated successfully");
			} catch (Exception e1) {

				e1.printStackTrace();
				gui.popUp(e1.getMessage());
			}

			// /// Save part
		} else if (e.getSource() == gui.getEditPanel().getBtnSavePart()) {
			try {

				DataCheck.CheckLongData(gui.getEditPanel().getTxfPartId()
						.getText(), gui);

				DataCheck.CheckLongData(gui.getEditPanel().getTxfShelf()
						.getText(), gui);

				DataCheck.CheckLongData(gui.getEditPanel().getTxfBox()
						.getText(), gui);

				DataCheck.CheckLongData(gui.getEditPanel().getTxfNrOfParts()
						.getText(), gui);

				client.updatePart(gui.getEditPanel().getTxfPartId().getText(),
						gui.getEditPanel().getTxfPartName().getText(), gui
								.getEditPanel().getTxfMake().getText(), gui
								.getEditPanel().getTxfDescription().getText(),
						gui.getEditPanel().getTxfCategory().getText(), gui
								.getEditPanel().getTxfNrOfParts().getText(),
						gui.getEditPanel().getTxfShelf().getText(), gui
								.getEditPanel().getTxfBox().getText());

				gui.getEditPanel().getTxfPartId().setText("");
				gui.getEditPanel().getTxfShelf().setText("");
				gui.getEditPanel().getTxfBox().setText("");
				gui.getEditPanel().getTxfPartName().setText("");
				gui.getEditPanel().getTxfMake().setText("");
				gui.getEditPanel().getTxfDescription().setText("");
				gui.getEditPanel().getTxfCategory().setText("");
				gui.getEditPanel().getTxfNrOfParts().setText("");

				gui.popUp("Part updated successfully");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
				gui.popUp(e1.getMessage());
			}

			// /Delete part
		} else if (e.getSource() == gui.getEditPanel().getBtnDeletePart()) {

			Part tempPart = new Part(
					Integer.parseInt(gui.getEditPanel().getTxfPartId()
							.getText()),
					gui.getEditPanel().getTxfPartName().getText(),
					gui.getEditPanel().getTxfMake().getText(),
					gui.getEditPanel().getTxfDescription().getText(),
					gui.getEditPanel().getTxfCategory().getText(),
					Integer.parseInt(gui.getEditPanel().getTxfNrOfParts()
							.getText()),
					Integer.parseInt(gui.getEditPanel().getTxfShelf().getText()),
					Integer.parseInt(gui.getEditPanel().getTxfBox().getText()));
			try {
				client.remove(tempPart);
			} catch (Exception e2) {
				e2.printStackTrace();
				gui.popUp("Error deleting part");
			}
			gui.getEditPanel().getTxfPartId().setText("");
			gui.getEditPanel().getTxfShelf().setText("");
			gui.getEditPanel().getTxfBox().setText("");
			gui.getEditPanel().getTxfPartName().setText("");
			gui.getEditPanel().getTxfMake().setText("");
			gui.getEditPanel().getTxfDescription().setText("");
			gui.getEditPanel().getTxfCategory().setText("");
			gui.getEditPanel().getTxfNrOfParts().setText("");
			gui.popUp("Part deleted successfully");

			// //Delete employee
		} else if (e.getSource() == gui.getEditPanel().getBtnDeleteEmployee()) {

			Employee tempEmployee = new Employee(
					gui.getEditPanel().getTxfName().getText(),
					Long.parseLong(gui.getEditPanel().getTxfSSN().getText()),
					Integer.parseInt(gui.getEditPanel().getTxfPhoneNr()
							.getText()),
					Long.parseLong(gui.getEditPanel().getTxfMngSSn().getText()),
					gui.getEditPanel().getTxfUsername().getText(), gui
							.getEditPanel().getTxfPassword().getText());

			try {
				client.remove(tempEmployee);
			} catch (Exception e2) {
				e2.printStackTrace();
				gui.popUp("Error deleting employee");
			}
			gui.getEditPanel().getTxfName().setText("");
			gui.getEditPanel().getTxfSSN().setText("");
			gui.getEditPanel().getTxfPhoneNr().setText("");
			gui.getEditPanel().getTxfMngSSn().setText("");
			gui.getEditPanel().getTxfUsername().setText("");
			gui.getEditPanel().getTxfPassword().setText("");
			gui.popUp("Employee deleted successfully");
		}

		// /////////////////
		// //SearchPanel////
		// /////////////////

		else if (e.getSource() == gui.getSearchPanel().getBtnSearch()) {

			if (gui.getSearchPanel().getRadioAll().isSelected()) {
				DefaultListModel<Part> lm = new DefaultListModel<Part>();
				ArrayList<Part> all = new ArrayList<Part>();
				try {
					all = client.getAllParts();
				} catch (IllegalArgumentException | RemoteException
						| SQLException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < all.size(); i++) {
					lm.addElement(all.get(i));
				}
				gui.getSearchPanel().getJlistParts().setModel(lm);
			}

			else if (gui.getSearchPanel().getRadioPartId().isSelected()) {
				DefaultListModel<Part> lm = new DefaultListModel<Part>();
				int partId = 0; // =
								// Integer.parseInt(gui.getSearchPanel().getTxfSearch().getText());
				try {
					partId = Integer.parseInt(gui.getSearchPanel()
							.getTxfSearch().getText());
					if (client.getPartById(partId) != null)
						lm.addElement(client.getPartById(partId));
					else
						throw new IllegalArgumentException();
				} catch (IllegalArgumentException | RemoteException
						| SQLException e1) {
					gui.popUp("Part "
							+ gui.getSearchPanel().getTxfSearch().getText()
							+ " does not exist!");
				}
				gui.getSearchPanel().getJlistParts().setModel(lm);

			} else if (gui.getSearchPanel().getRadioName().isSelected()) {
				DefaultListModel<Part> lm = new DefaultListModel<Part>();
				String name = gui.getSearchPanel().getTxfSearch().getText();
				try {
					if (client.getPartByName(name) != null)
						lm.addElement(client.getPartByName(name));
					else
						throw new IllegalArgumentException();
				} catch (IllegalArgumentException | RemoteException
						| SQLException e1) {
					gui.popUp("Part "
							+ gui.getSearchPanel().getTxfSearch().getText()
							+ " does not exist!");
					e1.printStackTrace();
				}
				gui.getSearchPanel().getJlistParts().setModel(lm);

			} else if (gui.getSearchPanel().getRadioCategory().isSelected()) {

				DefaultListModel<Part> lm = new DefaultListModel<Part>();
				String category = gui.getSearchPanel().getTxfSearch().getText();
				try {
					if (client.getPartByCategory(category) != null)
						lm.addElement(client.getPartByCategory(category));
					else
						throw new IllegalArgumentException();

				} catch (IllegalArgumentException | RemoteException
						| SQLException e1) {
					gui.popUp("Part "
							+ gui.getSearchPanel().getTxfSearch().getText()
							+ " does not exist!");
					e1.printStackTrace();
				}
				gui.getSearchPanel().getJlistParts().setModel(lm);
			}
			gui.getSearchPanel().getTxfSearch().setText("");

		} else if (e.getSource() == gui.getSearchPanel()
				.getBtnRemoveFromStock()) {

			int nrOfPartsToRemove = Integer.parseInt(gui.getSearchPanel()
					.getTxfSearch().getText());
			Part part = (Part) gui.getSearchPanel().getJlistParts()
					.getSelectedValue();
			try {
				if (part.getNrOfParts() >= nrOfPartsToRemove) {
					part.setNrOfParts(part.getNrOfParts() - nrOfPartsToRemove);
					client.updatePart("" + part.getPartID(), part.getName(),
							part.getName(), part.getDescription(),
							part.getCategory(), "" + part.getNrOfParts(), ""
									+ part.getShelfNr(), "" + part.getBox());
					gui.popUp(nrOfPartsToRemove + " " + part.getName()
							+ " removed from stock!");
					gui.getSearchPanel().getBtnSearch().doClick();
				} else if (part.getNrOfParts() == 0)
					gui.popUp("Part out of Stock");
				else
					throw new IllegalArgumentException();
			} catch (Exception e1) {
				gui.popUp("Amount to large");
			}
		}

		// /////////////////
		// //ViewEmployeesPanel////
		// /////////////////
		else if (e.getSource() == gui.getViewEmployees().getBtnRefresh()) {

			DefaultListModel<Employee> lm = new DefaultListModel<Employee>();
			ArrayList<Employee> arr = new ArrayList<Employee>();
			try {
				arr = client.getAllEmployees();

			} catch (IllegalArgumentException | RemoteException | SQLException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < arr.size(); i++)
				lm.addElement(arr.get(i));
			gui.getViewEmployees().getJlistEmployee().setModel(lm);

		}

		// /////////////////
		// //ViewLowStockPanel/////
		// /////////////////
		else if (e.getSource() == gui.getViewLowStock().getBtnRefresh()) {
			DefaultListModel<Part> lm = new DefaultListModel<Part>();
			ArrayList<Part> arr = new ArrayList<Part>();
			try {
				arr = client.getLowStock();
			} catch (IllegalArgumentException | RemoteException | SQLException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < arr.size(); i++)
				lm.addElement(arr.get(i));
			gui.getViewLowStock().getJlistLowStock().setModel(lm);

		} else if (e.getSource() == gui.getViewLowStock().getBtnUpdateStock()) {

			try {
				int updatedNrOfParts = Integer.parseInt(gui.getViewLowStock()
						.getTxfStockField().getText());
				Part part = gui.getViewLowStock().getJlistLowStock()
						.getSelectedValue();

				if (updatedNrOfParts >= 0) {
					part.setNrOfParts(updatedNrOfParts);
					client.updatePart(part.getPartID() + "", part.getName(),
							part.getMake(), part.getDescription(),
							part.getCategory(), part.getNrOfParts() + "",
							part.getShelfNr() + "", part.getBox() + "");
					gui.popUp("Stock updated to " + updatedNrOfParts
							+ " for Part Id " + part.getPartID());
					gui.getViewLowStock().getTxfStockField().setText("");
					gui.getViewLowStock().getBtnRefresh().doClick();
				} else
					throw new IllegalArgumentException();
			} catch (Exception e1) {
				gui.popUp("Invalid number of parts");
				e1.printStackTrace();
			}
		}

		// /////////////////
		// //LogInPanel/////
		// /////////////////
		else if (e.getSource() == gui.getLogInPanel().getBtnd()) {
			try {
				if (client.login(
						gui.getLogInPanel().getTxfUserName().getText(),
						gui.getLogInPanel().getTxfPassword().getText()).equals(
						MANAGER)) {
					gui.showAllPanels();
					gui.changeTab(1);
					gui.hideLoginTab();
				} else if (client.login(
						gui.getLogInPanel().getTxfUserName().getText(),
						gui.getLogInPanel().getTxfPassword().getText()).equals(
						EMPLOYEE)) {
					gui.hideAllPanels();
					gui.showEmployeePanels();
					gui.hideLoginTab();
				} else {
					gui.popUp("Username or password incorect");
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}

			// /////////////////
			// / GET LOG BUTTON/////
			// /////////////////
		} else if (e.getSource() == gui.getViewLogPanel().getBtnViewLog()) {
			DefaultListModel<Log> lm = new DefaultListModel<Log>();
			ArrayList<Log> arr = new ArrayList<Log>();
			try {
				arr = client.getLogAll();
			} catch (IllegalArgumentException | RemoteException | SQLException e1) {
				e1.printStackTrace();
			}
			for (int i = arr.size() - 1; i >= 0; i--) {
				lm.addElement(arr.get(i));
			}
			gui.getViewLogPanel().getJListLog().setModel(lm);
		}

		// /////////////////
		// /LogOutButton////
		// /////////////////
		else if (e.getSource() == gui.getCreatePanel().getBtnLogOut()
				|| e.getSource() == gui.getEditPanel().getBtnLogOut()
				|| e.getSource() == gui.getSearchPanel().getBtnLogOut()
				|| e.getSource() == gui.getViewLogPanel().getBtnLogOut()
				|| e.getSource() == gui.getViewEmployees().getBtnLogOut()
				|| e.getSource() == gui.getViewLowStock().getBtnLogOut()) {
			gui.hideAllPanels();
			gui.showLoginTab();
			gui.getLogInPanel().getTxfUserName().setText("");
			gui.getLogInPanel().getTxfPassword().setText("");
			try {
				client.logOut();
				System.out.println("Access securized");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			// /////Log out all

		}

	}
}
