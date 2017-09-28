package model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import factory.*;
import utill.*;
import adaptor.*;

public class ModelManager implements IModelManager {
	Adaptor<Part> part;
	Adaptor<Employee> emp;
	Adaptor<Location> loc;
	Factory factory;

	public ModelManager() throws ClassNotFoundException {
		part = new Adaptor<Part>();
		emp = new Adaptor<Employee>();
		loc = new Adaptor<Location>();
		factory = new Factory();
	}

	@Override
	public void addLocation(String shelfNr, String box) throws RemoteException {

		Location temp = factory.createLocation(shelfNr, box);
		loc.insert(temp);

	}

	@Override
	public void addEmployee(String name, String ssn, String phoneNr,
			String mngrSSN) throws RemoteException {

		Employee temp = factory.createEmployeeNoUser(name, ssn, phoneNr,
				mngrSSN);
		emp.insert(temp);

	}
	@Override
	public void addEmployeeWithUser(String name, String ssn, String phoneNr,
			String mngrSSN, String username, String password)
			throws RemoteException {

		Employee temp = factory.createEmployeeWithUser(name, ssn, phoneNr,
				mngrSSN, username, password);
		emp.insert(temp);

	}

	@Override
	public void addPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws RemoteException {
		Part temp = factory.createPart(partId, name, make, description,
				category, nrOfParts, shelfNr, box);

		part.insert(temp);

	}

	@Override
	public void remove(Object element) {

		if (element instanceof Part)
			part.remove((Part) element);
		else if (element instanceof Employee)
			emp.remove((Employee) element);
		else if (element instanceof Location)
			loc.remove((Location) element);
	}

	@Override
	public Part getPartById(int partId) throws IllegalArgumentException,
			SQLException {

		return part.getPartById(partId);

	}

	@Override
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException {
		return part.getPartByName(name);
	}

	@Override
	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException {
		return part.getPartByCategory(category);
	}

	@Override
	public Part getPartByLocation(Location location)
			throws IllegalArgumentException, SQLException {

		return part.getPartAtLocation(location);
	}

	@Override
	public Location getLocationByPartId(int partId)
			throws IllegalArgumentException, SQLException {

		return getPartById(partId).getLocation();
	}

	@Override
	public Location getLocationByPartName(String name)
			throws IllegalArgumentException, SQLException {

		return getPartByName(name).getLocation();
	}

	@Override
	public Location getLocationByPartCategory(String category)
			throws IllegalArgumentException, SQLException {
		return getPartByCategory(category).getLocation();
	}

	@Override
	public Employee getEmployeeBySSN(int ssn) throws IllegalArgumentException,
			SQLException {

		return emp.getEmployeeById(ssn);

	}

	@Override
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException {
		return emp.getEmployeeByUsername(username);
	}

	@Override
	public String getLoginInfoOfEmployee(Employee employee) {
		return employee.getEmployeeLoginInfo();
	}

	// //Changes the location of a specific part
	@Override
	public void setLocation(Location location, Part part) {
		part.setLocation(location);
	}
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
	@Override
	public ArrayList<Location> getAllLocations()
			throws IllegalArgumentException, SQLException {
		ArrayList<Location> result = new ArrayList<Location>();
		ResultSet rs = loc.getAll("location");

		String shelfNr = "", box = "";
		;

		while (rs.next()) {

			shelfNr = rs.getString(1);
			box = rs.getString(2);
			result.add(factory.createLocation(shelfNr, box));
		}
		return result;

	}

}
