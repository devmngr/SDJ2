package model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import factory.*;
import adaptor.*;

/**	This class is used to  allows communication between database and model classes. 
 * @author  Bogdan and Marian
 *
 */
public class ModelManager implements IModelManager {
	Adaptor<Part> part;
	Adaptor<Employee> emp;
	Adaptor<Location> loc;
	Adaptor<Log> log;
	Factory factory;

	/**
	 * Constructor initiates the model classes if they don't exist
	 * @throws ClassNotFoundException
	 */
	public ModelManager() throws ClassNotFoundException {
		part = new Adaptor<Part>();
		emp = new Adaptor<Employee>();
		loc = new Adaptor<Location>();
		log= new Adaptor<Log>();
		factory = new Factory();
	}
	/* (non-Javadoc)
	 * @see model.IModelManager#buildDatabase()
	 */
	@Override
	public void buildDatabase(){
		emp.buildDatabase();
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#addLocation(java.lang.String, java.lang.String)
	 */
	@Override
	public void addLocation(String shelfNr, String box) throws RemoteException,
			Exception {

		Location temp = factory.createLocation(shelfNr, box);
		loc.insert(temp);

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#addEmployeeWithUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException, Exception {

		Employee temp = factory.createEmployeeWithUser(name, ssn, phoneNr,
				mngrSSN, username, password);
		emp.insert(temp);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#addPart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception {
		Part temp = factory.createPart(partId, name, make, description,
				category, nrOfParts, shelfNr, box);

		part.insert(temp);

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#updateEmployeeWithUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException, Exception {

		Employee temp = factory.createEmployeeWithUser(name, ssn, phoneNr,
				mngrSSN, username, password);
		emp.update(temp);

	}
	/* (non-Javadoc)
	 * @see model.IModelManager#updatePart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception {
		Part temp = factory.createPart(partId, name, make, description,
				category, nrOfParts, shelfNr, box);

		part.update(temp);

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#updateLocation(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateLocation(String shelfNr, String box, String nrOfParts,
			String partId) throws SQLException {
		Location location = factory.createLocation(shelfNr, box);
		int nrParts = Integer.parseInt(nrOfParts);
		int idPart = Integer.parseInt(partId);

		loc.updateNrOfPartsAtLocation(location, nrParts, idPart);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#remove(java.lang.Object)
	 */
	@Override
	public void remove(Object element) {

		if (element instanceof Part)
			part.remove((Part) element);
		else if (element instanceof Employee)
			emp.remove((Employee) element);
		else if (element instanceof Location)
			loc.remove((Location) element);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getPartById(int)
	 */
	@Override
	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException {

		return part.getPartById(partId);

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getPartByName(java.lang.String)
	 */
	@Override
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException {
		return part.getPartByName(name);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getPartByCategory(java.lang.String)
	 */
	@Override
	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException {
		return part.getPartByCategory(category);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getPartByLocation(model.Location)
	 */
	@Override
	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException {

		return part.getPartAtLocation(location);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getLocationByPartId(int)
	 */
	@Override
	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException {

		return getPartById(partId).getLocation();
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getLocationByPartName(java.lang.String)
	 */
	@Override
	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException {

		return getPartByName(name).getLocation();
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getLocationByPartCategory(java.lang.String)
	 */
	@Override
	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException {
		return getPartByCategory(category).getLocation();
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getEmployeeBySSN(long)
	 */
	@Override
	public Employee getEmployeeBySSN(long ssn) throws IllegalArgumentException,
			SQLException {

		return emp.getEmployeeById(ssn);

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getEmployeeByUsername(java.lang.String)
	 */
	@Override
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException {
		return emp.getEmployeeByUsername(username);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getLoginInfoOfEmployee(model.Employee)
	 */
	@Override
	public String getLoginInfoOfEmployee(Employee employee) {
		return employee.getEmployeeLoginInfo();
	}

	// //Changes the location of a specific part
	/* (non-Javadoc)
	 * @see model.IModelManager#setLocation(model.Location, model.Part)
	 */
	@Override
	public void setLocation(Location location, Part part) {
		part.setLocation(location);
	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getAllEmployees()
	 */
	@Override
	public ArrayList<Employee> getAllEmployees()
			throws IllegalArgumentException, SQLException {
		ArrayList<Employee> result = new ArrayList<Employee>();
		ResultSet rs = emp.getAll("employee");

		String ssn = "", name = "", phoneNr = "", mngrSSN = "", username = "", password = "";

		while (rs.next()) {

			ssn = rs.getString(1);
			name = rs.getString(2);
			phoneNr = rs.getString(3);
			mngrSSN = rs.getString(4);
			username = rs.getString(5);
			password = rs.getString(6);
			result.add(factory.createEmployeeWithUser(name, ssn, phoneNr,
					mngrSSN, username, password));
		}
		return result;

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getAllParts()
	 */
	@Override
	public ArrayList<Part> getAllParts() throws IllegalArgumentException,
			SQLException {
		ArrayList<Part> result = new ArrayList<Part>();
		ResultSet rs = part.getAll("part");

		String partId = "", name = "", make = "", description = "", category = "", nrOfParts = "", shelfNr = "", box = "";
		;

		while (rs.next()) {

			partId = rs.getString(1);
			name = rs.getString(2);
			make = rs.getString(3);
			description = rs.getString(4);
			category = rs.getString(5);
			nrOfParts = rs.getString(6);
			shelfNr = rs.getString(7);
			box = rs.getString(8);
			result.add(factory.createPart(partId, name, make, description,
					category, nrOfParts, shelfNr, box));
		}
		return result;

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getAllLocations()
	 */
	@Override
	public ArrayList<Location> getAllLocations()
			throws IllegalArgumentException, SQLException {
		ArrayList<Location> result = new ArrayList<Location>();
		ResultSet rs = loc.getAll("location");

		String shelfNr = "", box = "";

		while (rs.next()) {

			shelfNr = rs.getString(1);
			box = rs.getString(2);
			result.add(factory.createLocation(shelfNr, box));
		}
		return result;

	}

	/* (non-Javadoc)
	 * @see model.IModelManager#getLocationByShelfAndBox(int, int)
	 */
	@Override
	public Location getLocationByShelfAndBox(int shelfNr, int box)
			throws IllegalArgumentException, SQLException {
		return loc.getLocation(shelfNr, box);
	}
	/* (non-Javadoc)
	 * @see model.IModelManager#getLowStock()
	 */
	@Override
	public ArrayList<Part> getLowStock() throws SQLException
	{
		ArrayList<Part> result = new ArrayList<Part>();
		ResultSet rs = part.getLowStock();

		String partId = "", name = "", make = "", description = "", category = "", nrOfParts = "", shelfNr = "", box = "";
		;

		while (rs.next()) {

			partId = rs.getString(1);
			name = rs.getString(2);
			make = rs.getString(3);
			description = rs.getString(4);
			category = rs.getString(5);
			nrOfParts = rs.getString(6);
			shelfNr = rs.getString(7);
			box = rs.getString(8);
			result.add(factory.createPart(partId, name, make, description,
					category, nrOfParts, shelfNr, box));
		}
		return result;
	}


	
	/* (non-Javadoc)
	 * @see model.IModelManager#getLogAll()
	 */
	@Override
	public ArrayList<Log> getLogAll() throws SQLException
	{
		ArrayList<Log> result = new ArrayList<Log>();
		ResultSet rs = log.getLogAll();

		String log_id = "", log_time="", description = "";

		while (rs.next()) {
			
			log_id = rs.getString(1);
			log_time = rs.getString(2);
			description = rs.getString(3);

			result.add(factory.createLog(log_id, log_time, description));
		}
		return result;
	}
	
}
