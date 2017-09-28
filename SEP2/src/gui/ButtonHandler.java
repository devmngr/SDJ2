package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import model.Employee;
import rmi.RmiClient;

public class ButtonHandler implements ActionListener {

	private MainGUI gui;
	private RmiClient client;

	public ButtonHandler(MainGUI gui, RmiClient client) {
		this.gui = gui;
		this.client = client;

	}

	public void actionPerformed(ActionEvent e) {

		// /////////////////
		// //CreatePanel////
		// /////////////////
		if (e.getSource() == gui.getCreatePanel().getBtnCreatePart()) {
			try {
				client.addPart(gui.getCreatePanel().getTxfPartId().getText(),
						gui.getCreatePanel().getTxfPartName().getText(), gui
								.getCreatePanel().getTxfMake().getText(),
						gui.getCreatePanel().getTxfDescription().getText(), gui
								.getCreatePanel().getTxfCategory().getText(),
						gui.getCreatePanel().getTxfNrOfParts().getText(), gui
								.getCreatePanel().getTxfShelf().getText(), gui
								.getCreatePanel().getTxfBox().getText());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == gui.getCreatePanel().getBtnCreateEmployee()) {
			try {
				client.addEmployeeWithUser(gui.getCreatePanel().getTxfName()
						.getText(), gui.getCreatePanel().getTxfSSN().getText(),
						gui.getCreatePanel().getTxfPhoneNr().getText(), gui
								.getCreatePanel().getTxfMngSSn().getText(), gui
								.getCreatePanel().getTxfUsername().getText(),
						gui.getCreatePanel().getTxfPassword().getText());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

		else if (e.getSource() == gui.getCreatePanel().getBtnCreateLocation()) {

			try {
				client.addLocation(gui.getCreatePanel().getTxfShelfNr()
						.getText(), gui.getCreatePanel().getTxfBoxNr()
						.getText());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}

		}
		// /////////////////
		// //EditPanel/////
		// /////////////////
		else if (e.getSource() == gui.getEditPanel().getBtnSearchEmployee()) {

			gui.getEditPanel().getLblName().setVisible(true);
			gui.getEditPanel().getTxfName().setVisible(true);
			gui.getEditPanel().getLblSSN().setVisible(true);
			gui.getEditPanel().getTxfSSN().setVisible(true);
			gui.getEditPanel().getLblPhoneNr().setVisible(true);
			gui.getEditPanel().getTxfPhoneNr().setVisible(true);
			gui.getEditPanel().getLblMngSSN().setVisible(true);
			gui.getEditPanel().getTxfMngSSn().setVisible(true);
			gui.getEditPanel().getLblUsername().setVisible(true);
			gui.getEditPanel().getTxfUsername().setVisible(true);
			gui.getEditPanel().getLblPassword().setVisible(true);
			gui.getEditPanel().getTxfPassword().setVisible(true);

			gui.getEditPanel().getBtnSaveEmployee().setVisible(true);

		} else if (e.getSource() == gui.getEditPanel().getBtnSearchLocation()) {

			gui.getEditPanel().getLblShelfNr().setVisible(true);
			gui.getEditPanel().getTxfShelfNr().setVisible(true);
			gui.getEditPanel().getLblBoxNr().setVisible(true);
			gui.getEditPanel().getTxfBoxNr().setVisible(true);
			gui.getEditPanel().getLblLocationNrOfParts().setVisible(true);
			gui.getEditPanel().getTxfLocationNrOfParts().setVisible(true);
			gui.getEditPanel().getLblLocationPartId().setVisible(true);
			gui.getEditPanel().getTxfLocationPartId().setVisible(true);

			gui.getEditPanel().getBtnSaveLocation().setVisible(true);

		} else if (e.getSource() == gui.getEditPanel().getBtnSearchPart()) {
			int partid =  Integer.parseInt(gui.getEditPanel().getTxfSearchPart().getText());
			try {
				if(client.getPartById(partid)!= null){
				gui.getEditPanel().getLblPartId().setVisible(true);
				gui.getEditPanel().getTxfPartId().setVisible(true);
				gui.getEditPanel().getLblShelf().setVisible(true);
				gui.getEditPanel().getTxfShelf().setVisible(true);
				gui.getEditPanel().getLblBox().setVisible(true);
				gui.getEditPanel().getTxfBox().setVisible(true);
				gui.getEditPanel().getLblPartName().setVisible(true);
				gui.getEditPanel().getTxfPartName().setVisible(true);
				gui.getEditPanel().getLblMake().setVisible(true);
				gui.getEditPanel().getTxfMake().setVisible(true);
				gui.getEditPanel().getLblDescription().setVisible(true);
				gui.getEditPanel().getTxfDescription().setVisible(true);
				gui.getEditPanel().getLblCategory().setVisible(true);
				gui.getEditPanel().getTxfCategory().setVisible(true);
				gui.getEditPanel().getLblNrOfParts().setVisible(true);
				gui.getEditPanel().getTxfNrOfParts().setVisible(true);

				gui.getEditPanel().getBtnSavePart().setVisible(true);
				
				gui.getEditPanel().getTxfPartId().setText(client.getPartById(partid).getPartID()+"");
				gui.getEditPanel().getTxfShelf().setText(client.getPartById(partid).getShelfNr()+"");
				gui.getEditPanel().getTxfBox().setText(client.getPartById(partid).getBox()+"");
				gui.getEditPanel().getTxfPartName().setText(client.getPartById(partid).getName());
				gui.getEditPanel().getTxfMake().setText(client.getPartById(partid).getMake());
				gui.getEditPanel().getTxfDescription().setText(client.getPartById(partid).getDescription());
				gui.getEditPanel().getTxfCategory().setText(client.getPartById(partid).getCategory());
				gui.getEditPanel().getTxfNrOfParts().setText(client.getPartById(partid).getNrOfParts()+"");
				}
			} catch (IllegalArgumentException | RemoteException | SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == gui.getEditPanel().getBtnSaveEmployee()) {

		} else if (e.getSource() == gui.getEditPanel().getBtnSaveLocation()) {

		} else if (e.getSource() == gui.getEditPanel().getBtnSaveLocation()) {

		}
		// /////////////////
		// //SearchPanel////
		// /////////////////

		else if (e.getSource() == gui.getSearchPanel().getBtnSearch()) {

		} else if (e.getSource() == gui.getSearchPanel().getBtnDelete()) {

		}
		// /////////////////
		// //ViewLogPanel///
		// /////////////////
		else if (e.getSource() == gui.getViewLogPanel().getBtnGetLogs()) {

		}

		// /////////////////
		// //ViewPanel////
		// /////////////////
		else if (e.getSource() == gui.getViewPanel().getBtnView()) {

			if (gui.getViewPanel().getRadioEmployee().isSelected()) {

				try {
					gui.getViewPanel().getTxfView().setText(client.getAllEmployees()+"");
				} catch (IllegalArgumentException | RemoteException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (gui.getViewPanel().getRadioLocation().isSelected()) {

				gui.getViewPanel().getTxfView().setText("Locations");

			} else if (gui.getViewPanel().getRadioParts().isSelected()) {
				gui.getViewPanel().getTxfView().setText("Parts");
			}

		}

		// /////////////////
		// //LogInPanel/////
		// /////////////////
		else if (e.getSource() == gui.getLogInPanel().getBtnd()) {
			if (gui.getLogInPanel().getTxfUserName().getText().equals("")
					&& gui.getLogInPanel().getTxfPassword().getText()
							.equals("")) {

				gui.showAllPanels();
				gui.changeTab(1);
			}

		}

		// /////////////////
		// /LogOutButton////
		// /////////////////
		else if (e.getSource() == gui.getCreatePanel().getBtnLogOut()
				|| e.getSource() == gui.getEditPanel().getBtnLogOut()
				|| e.getSource() == gui.getSearchPanel().getBtnLogOut()
				|| e.getSource() == gui.getViewLogPanel().getBtnLogOut()
				|| e.getSource() == gui.getViewPanel().getBtnLogOut()) {

			// /////Log out all

		}

	}
}
