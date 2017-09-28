package rmi;

import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.sql.SQLException;
import java.util.ArrayList;

import utill.Cin;
import model.*;

public class RmiServer extends UnicastRemoteObject implements ServerInterface {

	private ModelManager manager;

	public RmiServer() throws RemoteException, ClassNotFoundException {
		super();
		manager = new ModelManager();
		Registry reg = LocateRegistry.createRegistry(1099);
	}

	public static void main(String[] args) {
		try {

			ServerInterface rmiServer = new RmiServer();
			Naming.rebind("toUpperCase", rmiServer);
			System.out.println("Starting server...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void addLocation(String shelfNr, String box) throws RemoteException {

		manager.addLocation(shelfNr, box);

	}

	@Override
	public void addEmployee(String name, String ssn, String phoneNr,
			String mngrSSN) throws RemoteException {

		manager.addEmployee(name, ssn, phoneNr, mngrSSN);

	}

	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException {

		manager.addEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password);

	}

	@Override
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException {
		manager.addPart(partId, name, make, description, category, nrOfParts,
				shelfNr, box);

	}

	@Override
	public void remove(Object element) {
		manager.remove(element);
	}

	@Override
	public void setLocationOfPart(Location location, Part part) {
		manager.setLocation(location, part);
	}

	@Override
	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException {
		return manager.getPartById(partId);
	}

	@Override
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException {
		return manager.getPartByName(name);
	}

	@Override
	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException {
		return manager.getPartByCategory(category);
	}

	@Override
	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException {
		return manager.getPartByLocation(location);
	}

	@Override
	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException {
		return manager.getLocationByPartId(partId);
	}

	@Override
	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException {
		return manager.getLocationByPartName(name);
	}

	@Override
	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException {
		return manager.getLocationByPartCategory(category);
	}

	@Override
	public Employee getEmployeeBySSN(int ssn) throws IllegalArgumentException,
			SQLException {
		return manager.getEmployeeBySSN(ssn);
	}

	@Override
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException {
		return manager.getEmployeeByUsername(username);
	}

	@Override
	public String getLoginInfoOfEmployee(Employee employee) {
		return manager.getLoginInfoOfEmployee(employee);
	}

	@Override
	public ArrayList<Part> getAllParts() throws IllegalArgumentException, SQLException {
		return manager.getAllParts();
	}

	@Override
	public ArrayList<Employee> getAllEmployees() throws IllegalArgumentException,
			SQLException {
		return manager.getAllEmployees();
	}

	@Override
	public ArrayList<Location> getAllLocations() throws IllegalArgumentException,
			SQLException {
		return manager.getAllLocations();
	}
}