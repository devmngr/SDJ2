package adaptor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Employee;
import model.Location;
import model.Part;
import utill.*;

public interface IAdaptor<T> {
	public void insert(T element) throws IllegalArgumentException;

	public T remove(T element) throws IllegalArgumentException;

	public void update(T element) throws IllegalArgumentException, SQLException;

	public Employee getEmployeeById(int ssn) throws IllegalArgumentException,
			SQLException;
	public Employee getEmployeeByUsername(String username) throws IllegalArgumentException,
	SQLException ;

	public Location getLocation(int shelfnr, int box)
			throws IllegalArgumentException, SQLException;
	public Part getPartById(int partID) throws IllegalArgumentException,
	SQLException;
	public Part getPartByNrOfParts(int partID) throws IllegalArgumentException,
	SQLException;
	public Part getPartByName(String name) throws IllegalArgumentException,
	SQLException;
	public Part getPartByCategory(String name) throws IllegalArgumentException,
	SQLException;
	public Part getPartAtLocation(Location location)throws IllegalArgumentException, SQLException;
	public void updateLocation(Part element) throws IllegalArgumentException, SQLException;
	public ResultSet getAll(String elements)throws IllegalArgumentException,SQLException;
}
