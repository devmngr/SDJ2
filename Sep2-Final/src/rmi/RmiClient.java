package rmi;

import java.io.Serializable;
import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

/** The client connects to the server which grants him access to the system.
 * @author Alexandru and Bogdan
 *	
 */
public class RmiClient  {
	private ServerInterface server;
	private String checkUser;
	private String checkPassword;

	/**Constructor
	 * 
	 * @throws RemoteException
	 */
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

	/** Sends Location details to Server
	 * @param shelfNr
	 * 		shelf of the Location
	 * @param box
	 * 		shelf of the Location
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addLocation(String shelfNr, String box) throws RemoteException, Exception {
		server.addLocation(shelfNr, box, checkUser, checkPassword);
	}

	
	/**	Sends updaited Location details to Server
	 * @param shelfNr
	 * 		shelfNr of the Location
	 * @param box
	 * 		box of the Location
	 * @param nrOfParts
	 * 		nrOfParts of the location
	 * @param partId
	 * 		partId of the location
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void updateLocation(String shelfNr, String box, String nrOfParts, String partId) throws RemoteException, Exception {
		server.updateLocation(shelfNr, box, nrOfParts, partId, checkUser, checkPassword);

	}
	

	/** Send Employee details to the Server
	 * @param name
	 * 		name of the Employee
	 * @param ssn
	 * 		ssn of the employee
	 * @param phoneNr
	 * 		phoneNr of the employee
	 * @param mngrSSN
	 * 		SSN of the manager
	 * @param username
	 * 		username of the login
	 * @param password
	 * 		password of the lpgin
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException , Exception{
		server.addEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password,checkUser,checkPassword);
	}
	
	/** Send updated Employee details to the Server 
	 * @param name
	 * 		name of the employee
	 * @param ssn
	 * 		ssn of the employee
	 * @param phoneNr
	 * 		phoneNr of the employee
	 * @param mngrSSN
	 * 		SSN of the employee
	 * @param username
	 * 		username of the login
	 * @param password
	 * 		password of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException , Exception{
		server.updateEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password,checkUser,checkPassword);
	}

	/** Send Part details to the Server
	 * @param partId
	 * 		partId of the Part
	 * @param name
	 * 		 name of the Part
	 * @param make
	 * 		make of the Part
	 * @param description
	 * 		description of the Part
	 * @param category
	 * 		category of the Part
	 * @param nrOfParts
	 * 		nrOfParts of the Part
	 * @param shelfNr
	 * 		shelfNr of the Part
	 * @param box
	 * 		box of the Part
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception {
		server.addPart(partId, name, make, description, category, nrOfParts,
				shelfNr, box,checkUser,checkPassword);

	}
	
	
	/** Send updated part information to the Server
	 * @param partId
	 * 		partdId of the Part
	 * @param name
	 * 		name of the Part
	 * @param make
	 * 		make of the Part
	 * @param description
	 * 		description of the Part
	 * @param category
	 * 		category of the Part
	 * @param nrOfParts
	 * 		nrOfParts of the Part
	 * @param shelfNr
	 * 		ShelfNr of the Part
	 * @param box
	 * 		box of the Part
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception {
		server.updatePart(partId, name, make, description, category, nrOfParts,
				shelfNr, box,checkUser,checkPassword);

	}
	
	
	/**  Send Part details to the Server
	 * @param partId
	 * 		partId of the Part
	 * @param name
	 * 		name of the Part
	 * @param make
	 * 		make of the Part
	 * @param description
	 * 		description of the Part
	 * @param category
	 * 		category of the Part
	 * @param nrOfParts
	 * 		nrOfParts of the Part
	 * @param shelfNr
	 * 		shelfNr of the Part
	 * @param box
	 * 		box of the Part
	 * @param checkUser	
	 * 		checkUser of the login
	 * @param checkPassword
	 * 		checkPassword of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box, String checkUser, String checkPassword) throws RemoteException, Exception {
		server.addPart(partId, name, make, description, category, nrOfParts,
				shelfNr, box,checkUser,checkPassword);

	}

	/**	Send request to delete object that is taken as object parameter
	 * @param element
	 * 		element of the Object
	 * @throws RemoteException
	 */
	public void remove(Object element) throws RemoteException {
		server.remove(element,checkUser,checkPassword);
	}

	/**	Sends request to get list of  All location to server
	 * @return
	 * 		ArrayList of All Location
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public ArrayList<Location> getAllLocations()
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getAllLocations(checkUser,checkPassword);
	}

	/** Sends request to get list of All Employee to server
	 * @return 
	 * 		ArrayList of all Employee
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public ArrayList<Employee> getAllEmployees()
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getAllEmployees(checkUser,checkPassword);
	}

	/**	Sends request to get list of all Parts to server
	 * @return
	 * 		ArrayList of all Parts
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public ArrayList<Part> getAllParts() throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getAllParts(checkUser,checkPassword);
	}

	/** Sends request to change location of the part to Server
	 * @param location
	 * 		location of the Part
	 * @param part
	 * 		part of the Part
	 * @throws RemoteException
	 */
	public void setLocationOfPart(Location location, Part part)
			throws RemoteException {
		server.setLocationOfPart(location, part,checkUser,checkPassword);
	}

	/** Sends request to get Part by Id to Server
	 * @param partId
	 * 		partId of the Part
	 * @return
	 * 		part Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getPartById(partId,checkUser,checkPassword);
	}

	/**	Sends request to get Part by Name to Server
	 * @param name
	 * 		name of the Part
	 * @return
	 * 		part Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException, RemoteException {

		return server.getPartByName(name,checkUser,checkPassword);
	}

	/** Sends request to get Part by Category to Server
	 * @param category
	 * 		categor of the Part
	 * @return
	 * 		part Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getPartByCategory(category,checkUser,checkPassword);
	}

	/** Sends request to get Part by Location to Server
	 * @param location
	 * 		location of the PArt
	 * @return
	 * 		part Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getPartByLocation(location,checkUser,checkPassword);
	}

	/** Sends request to get Location by Part Id to Server
	 * @param partId
	 * 		partId of the Part
	 * @return
	 * 		location Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartId(partId,checkUser,checkPassword);
	}

	/**	Sends request to get Location by Name to Server
	 * @param name
	 * 		name of the Part
	 * @return
	 * 		location Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartName(name,checkUser,checkPassword);
	}

	/** Sends request to get Location by Part Category to Server
	 * @param category
	 * 		category of the Part
	 * @return
	 * 		location Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByPartCategory(category,checkUser,checkPassword);
	}

	/** Sends request to get Employee by SSN to Server
	 * @param ssn
	 * 		ssn of the employee
	 * @return
	 * 		employee Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Employee getEmployeeBySSN(long ssn) throws IllegalArgumentException,
			SQLException, RemoteException {
		return server.getEmployeeBySSN(ssn,checkUser,checkPassword);
	}

	/** Sends request to get Employee by Username to Server
	 * @param username
	 * 		username of the employee
	 * @return
	 * 		employee Object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getEmployeeByUsername(username,checkUser,checkPassword);
	}

	/** Sends request to get Log Info by Employee to Server
	 * @param employee
	 * 	employee of the employee
	 * @return
	 * 		log of the Login
	 * @throws RemoteException
	 */
	public String getLoginInfoOfEmployee(Employee employee)
			throws RemoteException {
		return server.getLoginInfoOfEmployee(employee,checkUser,checkPassword);
	}
	
	/** Checks login and passwords credentials 
	 * @param checkUser
	 * 		checkUser of the login
	 * @param checkPassword
	 * 		checkPassword of the login
	 * @return
	 * 		Employee or manager or access denied
	 * @throws RemoteException
	 */
	public String login(String checkUser, String checkPassword)
			throws RemoteException {
		this.checkUser= checkUser;
		this.checkPassword= checkPassword;
		return server.login(checkUser, checkPassword);
	}
	
	/** End the session of the User with the system
	 * @throws RemoteException
	 */
	public void logOut()throws RemoteException {
		server.logOut();
		checkUser="";
		checkPassword="";
	}

	/** Send request to get Location by Shelf and Box to the Server
	 * @param shelfNr
	 * 		shelfNr of the Location
	 * @param box
	 * 		box of the Location
	 * @return
	 * 		Location Object;
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByShelfAndBox(int shelfNr, int box)
			throws IllegalArgumentException, SQLException, RemoteException {
		return server.getLocationByShelfAndBox(shelfNr, box);
	}
	/**  Sends request to get ArrayList of Part which are running low to the Server
	 * @return
	 * 		ArrayList of Parts with nrOfParts smaller then 4
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public ArrayList<Part> getLowStock() throws RemoteException, SQLException
	{
		return server.getLowStock(checkUser, checkPassword);
	}

	/** Sends request to get ArrayList of all Logs to the Server
	 * @return
	 * 		ArrayList of all Logs
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public ArrayList<Log> getLogAll() throws RemoteException, SQLException{			
		return server.getLogAll(checkUser, checkPassword);
	}
	


	
}
