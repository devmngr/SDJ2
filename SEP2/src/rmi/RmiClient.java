package rmi;

import java.io.Serializable;
import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class RmiClient  {
	private ServerInterface server;

	public RmiClient() throws RemoteException {
		super();
		try {

			server = (ServerInterface) Naming
					.lookup("rmi://localhost:1099/toUpperCase");
			System.out.println("server connected");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addLocation(String shelfNr, String box) throws RemoteException {
		server.addLocation(shelfNr, box);

	}

	public void addEmployee(String name, String ssn, String phoneNr,
			String mngrSSN) throws RemoteException {
		server.addEmployee(name, ssn, phoneNr, mngrSSN);
	}

	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException {
		server.addEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password);
	}

	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException {
		server.addPart(partId, name, make, description, category, nrOfParts,
				shelfNr, box);

	}

	public void remove(Object element) throws RemoteException {
		server.remove(element);
	}

	public ArrayList<Location> getAllLocations()
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getAllLocations();
	}

	public ArrayList<Employee> getAllEmployees()
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getAllEmployees();
	}

	public ArrayList<Part> getAllParts() throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getAllParts();
	}

	public void setLocationOfPart(Location location, Part part)
			throws RemoteException {
		server.setLocationOfPart(location, part);
	}

	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getPartById(partId);
	}

	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException, RemoteException {

		return server.getPartByName(name);
	}

	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getPartByCategory(category);
	}

	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getPartByLocation(location);
	}

	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartId(partId);
	}

	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartName(name);
	}

	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartCategory(category);
	}

	public Employee getEmployeeBySSN(int ssn) throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getEmployeeBySSN(ssn);
	}

	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getEmployeeByUsername(username);
	}

	public String getLoginInfoOfEmployee(Employee employee)
			throws RemoteException {
		return server.getLoginInfoOfEmployee(employee);
	}

	/*
	 * public void createEmployee() throws RemoteException {
	 * System.out.println("Enter name: "); String name = Cin.readString();
	 * System.out.println("Enter ssn"); String ssn = Cin.readString();
	 * System.out.println("Enter phone nr: "); String phoneNr =
	 * Cin.readString(); System.out.println("Enter mngrssn"); String mngrSSN =
	 * Cin.readString();
	 * 
	 * server.addEmployee(name, ssn, phoneNr, mngrSSN);
	 * System.out.println("Employee added"); }
	 */
	public static void main(String[] args) throws RemoteException {
		RmiClient client = new RmiClient();
	}
}
