package rmi;

import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.sql.SQLException;
import java.util.ArrayList;

import singleton.Login;
import utill.Cin;
import model.*;

public class RmiServer extends UnicastRemoteObject implements ServerInterface {

	private ModelManager manager;
	private String securityCheck="denied";
	private final String MANAGER="manager";
	private final String EMPLOYEE="employee";


	public RmiServer() throws RemoteException, ClassNotFoundException {
		super();
		manager = new ModelManager();
		Registry reg = LocateRegistry.createRegistry(1099);
		manager.buildDatabase();
	}

	public static void main(String[] args) {
		try {

			ServerInterface rmiServer = new RmiServer();
			Naming.rebind("serv", rmiServer);
			System.out.println("Server started");
			// rmiServer.addEmployee();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public synchronized void addLocation(String shelfNr, String box,String usr, String pass) throws RemoteException, Exception {
		if(login(usr, pass).equals(MANAGER))
		manager.addLocation(shelfNr, box);

	}

	@Override
	public synchronized void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password, String usr, String pass)
			throws RemoteException, Exception {
		if(login(usr, pass).equals(MANAGER))
		manager.addEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password);

	}
	@Override
	public synchronized void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password, String usr, String pass)
			throws RemoteException, Exception {
		if(login(usr, pass).equals(MANAGER))
		manager.updateEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password);

	}
	

	@Override
	public synchronized void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box, String usr, String pass) throws RemoteException, Exception {
		
		if(login(usr, pass).equals(MANAGER))
		manager.addPart(partId, name, make, description, category, nrOfParts,
				shelfNr, box);

	}

	
	@Override
	public synchronized void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box, String usr, String pass) throws RemoteException, Exception {
		
		if(login(usr, pass).equals(MANAGER))
			manager.updatePart(partId, name, make, description, category, nrOfParts,
					shelfNr, box);
	}
	
	@Override
	public synchronized void remove(Object element, String usr, String pass) throws RemoteException{
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		manager.remove(element);
	}

	@Override
	public synchronized void setLocationOfPart(Location location, Part part, String usr, String pass)throws RemoteException {
		if(login(usr, pass).equals(MANAGER))
		manager.setLocation(location, part);
	}
	
	@Override
	public synchronized void updateLocation(String shelfNr, String box, String nrOfParts, String partId, String usr, String pass) throws RemoteException, Exception {
	if(login(usr, pass).equals(MANAGER))
	manager.updateLocation(shelfNr, box, nrOfParts, partId);
	}

	@Override
	public synchronized Part getPartById(int partId,String usr, String pass) throws IllegalArgumentException,
			SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getPartById(partId);
		else return null;
	}

	@Override
	public synchronized Part getPartByName(String name, String usr, String pass) throws IllegalArgumentException,
			SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getPartByName(name);
		else return null;
	}

	@Override
	public synchronized Part getPartByCategory(String category, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getPartByCategory(category);
		else return null;
	}

	@Override
	public synchronized Part getPartByLocation(Location location, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getPartByLocation(location);
		else return null;
	}

	@Override
	public synchronized Location getLocationByPartId(int partId, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getLocationByPartId(partId);
		else return null;
	}

	@Override
	public synchronized Location getLocationByPartName(String name, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getLocationByPartName(name);
		else return null;
	}

	@Override
	public synchronized Location getLocationByShelfAndBox(int shelfNr, int box)
			throws IllegalArgumentException, SQLException, RemoteException {
		return manager.getLocationByShelfAndBox(shelfNr, box);
	}
	
	@Override
	public synchronized Location getLocationByPartCategory(String category,String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getLocationByPartCategory(category);
		else return null;
	}

	@Override
	public synchronized Employee getEmployeeBySSN(long ssn, String usr, String pass) throws IllegalArgumentException,
			SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER))
		return manager.getEmployeeBySSN(ssn);
		else return null;
	}

	@Override
	public synchronized Employee getEmployeeByUsername(String username, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER))
		return manager.getEmployeeByUsername(username);
		else return null;
	}

	@Override
	public synchronized String getLoginInfoOfEmployee(Employee employee, String usr, String pass) throws RemoteException {
		if(login(usr, pass).equals(MANAGER))
		return manager.getLoginInfoOfEmployee(employee);
		else return null;
	}

	@Override
	public synchronized ArrayList<Part> getAllParts(String usr, String pass) throws IllegalArgumentException, SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getAllParts();
		else return null;
	}

	@Override
	public synchronized ArrayList<Employee> getAllEmployees(String usr, String pass) throws IllegalArgumentException,
			SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER))
		return manager.getAllEmployees();
		else return null;
	}

	@Override
	public synchronized ArrayList<Location> getAllLocations(String usr, String pass) throws IllegalArgumentException,
			SQLException, RemoteException {
		if(login(usr, pass).equals(MANAGER)||login(usr, pass).equals(EMPLOYEE))
		return manager.getAllLocations();
		else return null;
	}

	@Override
	public synchronized String login(String checkUser, String checkPassword)
			throws RemoteException {
		try {
			String temp="denied";
			temp= Login.CheckEmployeeLogin(checkUser, checkPassword);
			securityCheck=temp;
			return temp;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "denied";
	}
	
	
	public synchronized void logOut()throws RemoteException{
		securityCheck="denied";
	}
	@Override
	public synchronized ArrayList<Part> getLowStock(String usr, String pass) throws RemoteException, SQLException
	{
		if(login(usr, pass).equals(MANAGER))
			return manager.getLowStock();
	
		return null;
	}


	
}