package rmi;

import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Location;
import model.Log;
import model.Part;
import adaptor.Adaptor;

/** The interface for the RmiServer.
 * It makes possible the connection of clients with the system.
 * @author Alexandru and Bogdan
 *		
 * @param <T>
 */
public interface ServerInterface<T> extends Remote {

	/**
	 * Creates a new Employee object in factory
	 * 
	 * @param name
	 *            name of the Employee
	 * @param ssn
	 *            ssn of the Employee
	 * @param phoneNr
	 *            phoneNr of the Employee
	 * @param mngrSSN
	 *            mngrSSN of the Employee
	 * @param username
	 *            username of the Employee
	 * @param password
	 *            password of the Employee
	 * @param usr
	 *            usr of the login
	 * @param pass
	 *            usr of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password, String usr,
			String pass) throws RemoteException, Exception;

	/**
	 * Creates a new Part object in factory
	 * 
	 * @param partId
	 *            partId of the part
	 * @param name
	 *            name of the part
	 * @param make
	 *            make of the part
	 * @param description
	 *            description of the part
	 * @param category
	 *            category of the part
	 * @param nrOfParts
	 *            nrOfParts of the part
	 * @param shelfNr
	 *            partId of the part
	 * @param box
	 *            box of the part
	 * @param usr
	 *            usr of the login
	 * @param pass
	 *            pass of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box, String usr, String pass)
			throws RemoteException, Exception;

	/** Creates a new Location object in Factory
	 * @param shelfNr
	 * 		shelft of the Location
	 * @param box
	 * 		box of the Location
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addLocation(String shelfNr, String box, String usr, String pass)
			throws RemoteException, Exception;

	/** Removes an object by Username and Password
	 * @param element
	 * 		element of the object
	 * @param usr
	 * 			usr of the login object
	 * @param pass
	 * 			pass of the login object
	 * @throws RemoteException
	 */
	public void remove(Object element, String usr, String pass)
			throws RemoteException;

	/** Gets ArrayList of all Locations in Factory
	 * @param usr
	 * 		usr of the login object
	 * 	@param pass	
	 * 		pass of the login object
	 * @return
	 * 		ArrayList of Location objects
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public ArrayList<Location> getAllLocations(String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/**	 Gets ArrayList of all Locations in Factory
	 * @param usr
	 * @param pass
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	
	public ArrayList<Employee> getAllEmployees(String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/**  Gets ArrayList of all Parts in factory
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login 
	 * @return
	 * 		ArrayList of all Parts
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public ArrayList<Part> getAllParts(String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/**  Sets location of the Part in Factory
	 * @param location
	 * 		location of the Location object
	 * @param part
	 * 		part of the Part object
	 * @param usr
	 * 		usr of the login object
	 * @param pass
	 * 		pass of the login object
	 * @throws RemoteException
	 */
	public void setLocationOfPart(Location location, Part part, String usr,
			String pass) throws RemoteException;

	/** Returns the part that has searched Id
	 * @param partId
	 * 		partid of the part
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		part object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartById(int partId, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/** Return part that has Searched Name
	 * @param name
	 * 		name of the employee
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		part object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartByName(String name, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

/** Return part that has searched Category
	 * @param category
	 * 		category of the part
	 * @param usr
	 * usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		part object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartByCategory(String category, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/** Return part that searched Location
	 * @param location
	 * 		location of the part
	 * @param usr
	 * usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		part object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Part getPartByLocation(Location location, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/** Returns Location that searched PartId 
	 * @param partId
	 * 		partid id of the part
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		location object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByPartId(int partId, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/** Returns Location that searched part Name
	 * @param name
	 * 		name of the part
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		location object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByPartName(String name, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/** Retuns Location that searched part Category
	 * @param category
	 * 			category of the part
	 * @param usr
	 * 			usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		location object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByPartCategory(String category, String usr,
			String pass) throws IllegalArgumentException, SQLException,
			RemoteException;

	/** Returns Employee that searched SSN
	 * @param ssn
	 * 		ssn of the employee
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		employee object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Employee getEmployeeBySSN(long ssn, String usr, String pass)
			throws IllegalArgumentException, SQLException, RemoteException;

	/**	Returns Employee that searched Username
	 * @param username
	 * 		username of the employee
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		employee object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Employee getEmployeeByUsername(String username, String usr,
			String pass) throws IllegalArgumentException, SQLException,
			RemoteException;

	/** Returns String information of searched employee
	 * @param employee
	 * 		employee of the employee
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		manager of employee object
	 * @throws RemoteException
	 */
	public String getLoginInfoOfEmployee(Employee employee, String usr,
			String pass) throws RemoteException;

	/** Returns either employee or manager
	 * @param checkUser 
	 * 			checkUser of the log
	 * @param checkPassword
	 * 		checkPassword of the log
	 * @return
	 * 		
	 * @throws RemoteException
	 */
	public String login(String checkUser, String checkPassword)
			throws RemoteException;

	/** Returns Location that searched Shelf and Box
	 * @param shelfNr
	 * 		shelfNr of the location
	 * @param box
	 * 		box of the location
	 * @return
	 * 		location object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public Location getLocationByShelfAndBox(int shelfNr, int box)
			throws IllegalArgumentException, SQLException, RemoteException;

	/**
	 * @throws RemoteException
	 */
	public void logOut() throws RemoteException;

	/** Updates employee of searched user
	 * @param name
	 * 		name of the employee
	 * @param ssn
	 * 		ssn of the employee
	 * @param phoneNr
	 * 		phoneNr of the employee
	 * @param mngrSSN
			mngrnSSN of the employee
	 * @param username
	 * 		username of the employee
	 * @param password
	 * 			password of the employee
	 * @param usr
	 * 			usr of the login 
	 * @param pass
	 * 			pass of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password, String usr,
			String pass) throws RemoteException, Exception;

	/** Updates Location of searched location
	 * @param shelfNr
	 * 		shelfNr of the location
	 * @param box	
	 * 			box of the location
	 * @param nrOfParts
	 * 			nrOfParts of the location
	 * @param partId
	 * 			part of the part
	 * @param usr
	 * 			usr of the login
	 * @param pass
	 * 			pass of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	void updateLocation(String shelfNr, String box, String nrOfParts,
			String partId, String usr, String pass) throws RemoteException,
			Exception;

	/** Updates part of searched part
	 * @param partId
	 * 		partId of the part
	 * @param name
	 * 		name of the part
	 * @param make
	 * 		make of the part
	 * @param description
	 * 		description of the part
	 * @param category
	 * 		category of the part
	 * @param nrOfParts
	 * 		nrOfParts of the part
	 * @param shelfNr
	 * 		shelfBox of the part
	 * @param box
	 * 		box of the part
	 * @param checkUser
	 * 		checkUser of the login
	 * @param checkPassword
	 * 		checkPassword of the login
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box, String checkUser, String checkPassword)
			throws RemoteException, Exception;

	/** Return ArrayList of Parts that running low
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		return ArrayList of the Parts
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public ArrayList<Part> getLowStock(String usr, String pass)
			throws RemoteException, SQLException;

	/** Returns  ArrayList of all Logs
	 * @param usr
	 * 		usr of the login
	 * @param pass
	 * 		pass of the login
	 * @return
	 * 		return ArrayList of all Logs
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public ArrayList<Log> getLogAll(String usr, String pass) throws RemoteException,
			SQLException;
}
