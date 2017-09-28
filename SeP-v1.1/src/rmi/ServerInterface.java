package rmi;

import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Location;
import model.Part;
import adaptor.Adaptor;

public interface ServerInterface<T> extends Remote{

	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password, String usr, String pass)
			throws RemoteException, Exception;

	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts, String shelfNr, String box, String usr, String pass) throws RemoteException, Exception;

	public void addLocation(String shelfNr, String box, String usr, String pass) throws RemoteException, Exception;

	public void remove(Object element, String usr, String pass)throws RemoteException;

	public ArrayList<Location> getAllLocations(String usr, String pass) throws IllegalArgumentException,
			SQLException,RemoteException;

	public ArrayList<Employee> getAllEmployees(String usr, String pass) throws IllegalArgumentException,
			SQLException,RemoteException;

	public ArrayList<Part> getAllParts(String usr, String pass) throws IllegalArgumentException, SQLException,RemoteException;

	public void setLocationOfPart(Location location, Part part,String usr, String pass)throws RemoteException;

	public Part getPartById(int partId,String usr, String pass) throws IllegalArgumentException,
			SQLException,RemoteException;

	public Part getPartByName(String name, String usr, String pass) throws IllegalArgumentException,
			SQLException,RemoteException;

	public Part getPartByCategory(String category, String usr, String pass)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Part getPartByLocation(Location location, String usr, String pass)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Location getLocationByPartId(int partId, String usr, String pass)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Location getLocationByPartName(String name, String usr, String pass)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Location getLocationByPartCategory(String category, String usr, String pass)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Employee getEmployeeBySSN(long ssn, String usr, String pass) throws IllegalArgumentException, SQLException,RemoteException;

	public Employee getEmployeeByUsername(String username, String usr, String pass) throws IllegalArgumentException, SQLException,RemoteException;

	public String getLoginInfoOfEmployee(Employee employee, String usr, String pass)throws RemoteException;
	
	public String login(String checkUser, String checkPassword)throws RemoteException;
	
	public Location getLocationByShelfAndBox(int shelfNr, int box)
			throws IllegalArgumentException, SQLException, RemoteException; 
	
	public void logOut()throws RemoteException;

	void updateEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password, String usr,
			String pass) throws RemoteException, Exception;

	void updateLocation(String shelfNr, String box, String nrOfParts,
			String partId, String usr, String pass) throws RemoteException, Exception;

	public void updatePart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box, String checkUser, String checkPassword) throws RemoteException, Exception;

	ArrayList<Part> getLowStock(String usr, String pass)
			throws RemoteException, SQLException;
}
