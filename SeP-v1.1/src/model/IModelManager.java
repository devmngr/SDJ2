package model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import adaptor.*;

public interface IModelManager<T> {

	public ArrayList<Part> getAllParts() throws IllegalArgumentException, SQLException;

	public ArrayList<Employee> getAllEmployees() throws IllegalArgumentException,
			SQLException;

	public ArrayList<Location> getAllLocations() throws IllegalArgumentException,
			SQLException;

	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException, Exception;

	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception;

	public void addLocation(String shelfNr, String box) throws RemoteException, Exception;

	public void remove(T element);

	public void setLocation(Location location, Part part);

	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException;

	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException;;

	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException;

	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException;

	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException;

	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException;

	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException;
	public Location getLocationByShelfAndBox(int shelfNr, int box)throws IllegalArgumentException, SQLException;

	public Employee getEmployeeBySSN(long ssn) throws IllegalArgumentException,
			SQLException;

	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException;

	public String getLoginInfoOfEmployee(Employee employee);

	public void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException, Exception;
	public void updateLocation(String shelfNr, String box, String nrOfParts, String partId) throws SQLException;

	void buildDatabase();

	void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException, Exception;

	ArrayList<Part> getLowStock() throws SQLException;

}
