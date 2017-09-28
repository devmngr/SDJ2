package adaptor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Location;
import model.Part;

/**
 * The interface for the Adaptor. The Adaptor allows reading and writing to the database
 * @author Bogdan and Tomas
 *
 * @param <T>
 * Generic Type T
 */
public interface IAdaptor<T> {
	/**
	 * Inserts an element of general type into the database
	 * @param element the element that is inserted
	 * @throws IllegalArgumentException
	 * @throws Exception 
	 */
	public void insert(T element) throws IllegalArgumentException, Exception;

	/**
	 * Removes an element of general type from the database
	 * @param element the element that is removed
	 * @return
	 * @throws IllegalArgumentException
	 */
	public T remove(T element) throws IllegalArgumentException;

	/**
	 * Updates the information of an element of general type in the database
	 * @param element the element that is being updated
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public void update(T element) throws IllegalArgumentException, SQLException;

	/**
	 * Returns the employee that has the searched social security number 
	 * @param ssn the social serial number of an employee
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Employee getEmployeeById(long ssn) throws IllegalArgumentException,
			SQLException;

	/**
	 * Return the employee that has the searched username
	 * @param username the username of an employee
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException;

	/**
	 * Returns the location of a part in the warehouse
	 * @param shelfnr the shelf number of a part
	 * @param box the box number of a part
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Location getLocation(int shelfnr, int box)
			throws IllegalArgumentException, SQLException;

	/**
	 * Returns the part that has the searched id
	 * @param partID the part id
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartById(int partID) throws IllegalArgumentException,
			SQLException;


	/**
	 * Returns the parts by number of parts
	 * @param nrOfParts the number of parts
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartByNrOfParts(int nrOfParts) throws IllegalArgumentException,
			SQLException;

	/**
	 * Returns the part by searched name
	 * @param name the name of the part
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException;

	/**
	 * Returns the parts by category name
	 * @param name the name of the category
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartByCategory(String name) throws IllegalArgumentException,
			SQLException;

	/**
	 * Returns the part at the searched location
	 * @param location the location of the part
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public Part getPartAtLocation(Location location)
			throws IllegalArgumentException, SQLException;

	/**
	 * Updates the location of the searched part
	 * @param element the part 
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public void updateLocation(Part element) throws IllegalArgumentException,
			SQLException;

	/**
	 * Returns a ResultSet of searched elements
	 * @param elements The name of the elements
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public ResultSet getAll(String elements) throws IllegalArgumentException,
			SQLException;

	void updateNrOfPartsAtLocation(Location location, int nrOfParts, int partId) throws SQLException;

	void buildDatabase();

	ResultSet getLowStock() throws SQLException;

	ResultSet getLogAll() throws SQLException;

}
