package rmi;

import java.rmi.*;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Location;
import model.Part;
import adaptor.Adaptor;

public interface ServerInterface<T> extends Remote{

	public void addEmployee(String name, String ssn, String phoneNr,
			String mngrSSN) throws RemoteException;

	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException;

	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts, String shelfNr, String box) throws RemoteException;

	public void addLocation(String shelfNr, String box) throws RemoteException;

	public void remove(Object element)throws RemoteException;

	public ArrayList<Location> getAllLocations() throws IllegalArgumentException,
			SQLException,RemoteException;

	public ArrayList<Employee> getAllEmployees() throws IllegalArgumentException,
			SQLException,RemoteException;

	public ArrayList<Part> getAllParts() throws IllegalArgumentException, SQLException,RemoteException;

	public void setLocationOfPart(Location location, Part part)throws RemoteException;

	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException,RemoteException;

	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException,RemoteException;

	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException,RemoteException;

	public Employee getEmployeeBySSN(int ssn) throws IllegalArgumentException, SQLException,RemoteException;

	public Employee getEmployeeByUsername(String username) throws IllegalArgumentException, SQLException,RemoteException;

	public String getLoginInfoOfEmployee(Employee employee)throws RemoteException;
}
