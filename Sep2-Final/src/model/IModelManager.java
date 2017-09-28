package model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import adaptor.*;

/**
 * @author  Bogdan and Marian
 * The interface for the ModelManager.
 * The ModelManager allows communication between database and model classes. 
 * @param <T>
 */
public interface IModelManager<T> {

	/** Returns ArrayList of all Parts from database
	 * @return ArrayList of all Part from database
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public ArrayList<Part> getAllParts() throws IllegalArgumentException, SQLException;

	/** Return ArrayList of all Employees from database
	 * @return  ArrayList of all Employees from database
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public ArrayList<Employee> getAllEmployees() throws IllegalArgumentException,
			SQLException;

	/** Return ArrayList of all Locations from database
	 * @return  ArrayList of all Location from database
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public ArrayList<Location> getAllLocations() throws IllegalArgumentException,
			SQLException;

	/** Creates an Employee Object into database
	 * @param name 
	 * 		the name of an Employee Object 
	 * @param ssn 
	 * 		the ssn of an Employee Object
	 * @param phoneNr
	 * 		the phoneNr of an Employee Object 
	 * @param mngrSSN
	 * 		the mngrSSN of an Employee Object
	 * @param username
	 * 		the username of an Employee Object 
	 * @param password
	 * 		the password of an Employee Object
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException, Exception;

	/** Creates a Part object into database
	 * @param partId
	 * 		the partId of an Part Object 
	 * @param name
	 * 		the name of an Part Object 
	 * @param make
	 * 		the make of an Part Object 
	 * @param description
	 * 		the description of an Part Object 
	 * @param category
	 * 		the category of an Part Object 
	 * @param nrOfParts
	 * 		the nrOfParts of an Part Object 
	 * @param shelfNr
	 * 		the shelfNr of an Part Object 
	 * @param box
	 * 		the box of an Part Object 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception;

	/** Creates Location object into database
	 * @param shelfNr
	 * 		the shelfNr of an Part Object 
	 * @param box
	 * 		the box of an Part Object 
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void addLocation(String shelfNr, String box) throws RemoteException, Exception;

	/** Removes an element of general type from the database
	 * @param element element 
	 * 		the element that is removed
	 */
	public void remove(T element);

	/** Sets Location of  of a part
	 * @param location
	 * 			location of  of a part
	 * @param part
	 * 			specific part
	 * 	
	 */
	public void setLocation(Location location, Part part);

	/** Returns the part that has the searched id
	 * @param partId
	 * 			the part  of a part
	 * @return 
	 * 		a part by specific par id
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException;

	/**	Returns the part that has the searched name
	 * @param name
	 * 		name of a part
	 * @return
	 * 		a part 
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException;;

	/** Returns the part that has the searched category
	 * @param category
	 * 		category of a part
	 * @return
	 * 		part by specific category
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException;

	/** Returns the part that has the searched location
	 * @param location
	 * 		location of the part
	 * @return
	 * 		part by specific location
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException;

	/**	Returns the location that has the searched part id
	 * @param partId
	 * 		part id of the location
	 * @return
	 * 		location that has been searched
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException;

	/** Returns the location that has the searched by part id
	 * @param name
	 * 		name of the part
	 * @return
	 * 	location of the part
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException;

	/**  Returns the location that has the searched by part category
	 * @param category
	 * 		category of the part
	 * @return
	 * 		location of the part
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException;
	/** Returns the location that has the searched by shelf and box
	 * @param shelfNr
	 * 		shelfNumber of the location
	 * @param box
	 * 			box of the location
	 * @return
	 * 		location object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Location getLocationByShelfAndBox(int shelfNr, int box)throws IllegalArgumentException, SQLException;

	/** Return the employee that has searched by SSN
	 * @param ssn
	 * 		ssn of the Employee
	 * @return
	 * 		Employee object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Employee getEmployeeBySSN(long ssn) throws IllegalArgumentException,
			SQLException;

	/**	 Returns the location that has the searched by part name
	 * @param username
	 * 		username of the Employee
	 * @return
	 * 			Employee object
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException;

	/**	Return log in information of the Employee
	 * @param employee
	 * 		employee 
	 * @return
	 */
	public String getLoginInfoOfEmployee(Employee employee);

	/** Updates the Employee of the searched
	 * @param name
	 * 		name of the employee
	 * @param ssn
	 * 		ssn of the employee
	 * @param phoneNr
	 * 		phoneNr of the employee
	 * @param mngrSSN
	 * 		mngrSSN of the employee
	 * @param username
	 * 		username of the employee
	 * @param password
	 * 		password of the employee
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException, Exception;
	/**	Updates Location 
	 * @param shelfNr
	 * 		shelfNr of the location
	 * @param box
	 * 		box of the location
	 * @param nrOfParts
	 * 		nrOfPats of the location
	 * @param partId
	 * 		partId of the location
	 * @throws SQLException
	 */
	public void updateLocation(String shelfNr, String box, String nrOfParts, String partId) throws SQLException;

	/**	Creates Database
	 * 
	 */
	void buildDatabase();

	/**	Updates Part
	 * @param partId
	 * 		partid of the Part
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
	 * @throws RemoteException
	 * @throws Exception
	 */
	void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception;

	/**	Return ArrayList of the Part that runing low
	 * @return
	 * 		ArrayList of Parts
	 * @throws SQLException
	 */
	ArrayList<Part> getLowStock() throws SQLException;

	/**		Return ArrayList of Logs
	 * @return
	 * 		ArrayList of Logs
	 * @throws SQLException
	 */
	ArrayList<Log> getLogAll() throws SQLException;

}
