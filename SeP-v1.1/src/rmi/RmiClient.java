package rmi;

import java.io.Serializable;
import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class RmiClient  {
	private ServerInterface server;
	private String checkUser;
	private String checkPassword;

	public RmiClient() throws RemoteException {
		super();
		try {

			server = (ServerInterface) Naming
					.lookup("rmi://localhost:1099/serv");
			System.out.println("server connected");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addLocation(String shelfNr, String box) throws RemoteException, Exception {
		server.addLocation(shelfNr, box, checkUser, checkPassword);
	}

	
	public void updateLocation(String shelfNr, String box, String nrOfParts, String partId) throws RemoteException, Exception {
		server.updateLocation(shelfNr, box, nrOfParts, partId, checkUser, checkPassword);

	}
	

	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException , Exception{
		server.addEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password,checkUser,checkPassword);
	}
	
	public void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException , Exception{
		server.updateEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password,checkUser,checkPassword);
	}

	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception {
		server.addPart(partId, name, make, description, category, nrOfParts,
				shelfNr, box,checkUser,checkPassword);

	}
	
	
	public void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception {
		server.updatePart(partId, name, make, description, category, nrOfParts,
				shelfNr, box,checkUser,checkPassword);

	}
	
	
	
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box, String checkUser, String checkPassword) throws RemoteException, Exception {
		server.addPart(partId, name, make, description, category, nrOfParts,
				shelfNr, box,checkUser,checkPassword);

	}

	public void remove(Object element) throws RemoteException {
		server.remove(element,checkUser,checkPassword);
	}

	public ArrayList<Location> getAllLocations()
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getAllLocations(checkUser,checkPassword);
	}

	public ArrayList<Employee> getAllEmployees()
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getAllEmployees(checkUser,checkPassword);
	}

	public ArrayList<Part> getAllParts() throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getAllParts(checkUser,checkPassword);
	}

	public void setLocationOfPart(Location location, Part part)
			throws RemoteException {
		server.setLocationOfPart(location, part,checkUser,checkPassword);
	}

	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getPartById(partId,checkUser,checkPassword);
	}

	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException, RemoteException {

		return server.getPartByName(name,checkUser,checkPassword);
	}

	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getPartByCategory(category,checkUser,checkPassword);
	}

	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getPartByLocation(location,checkUser,checkPassword);
	}

	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartId(partId,checkUser,checkPassword);
	}

	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartName(name,checkUser,checkPassword);
	}

	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartCategory(category,checkUser,checkPassword);
	}

	public Employee getEmployeeBySSN(long ssn) throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getEmployeeBySSN(ssn,checkUser,checkPassword);
	}

	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getEmployeeByUsername(username,checkUser,checkPassword);
	}

	public String getLoginInfoOfEmployee(Employee employee)
			throws RemoteException {
		return server.getLoginInfoOfEmployee(employee,checkUser,checkPassword);
	}
	
	public String login(String checkUser, String checkPassword)
			throws RemoteException {
		this.checkUser= checkUser;
		this.checkPassword= checkPassword;
		return server.login(checkUser, checkPassword);
	}
	
	public void logOut()throws RemoteException {
		server.logOut();
		checkUser="";
		checkPassword="";
	}

	public Location getLocationByShelfAndBox(int shelfNr, int box)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByShelfAndBox(shelfNr, box);
	}
	public ArrayList<Part> getLowStock() throws RemoteException, SQLException
	{
		return server.getLowStock(checkUser, checkPassword);
	}





//	public static void main(String[] args) throws RemoteException {
//		RmiClient client = new RmiClient();
//	}
	
	
}
