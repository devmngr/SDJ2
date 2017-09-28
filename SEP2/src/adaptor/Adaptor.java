package adaptor;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.*;
import utill.*;

public class Adaptor<T> implements IAdaptor<T> {

	private Adaptee adaptee;

	public Adaptor() throws ClassNotFoundException {
		adaptee = new Adaptee();
	}

	@Override
	public void insert(T element) throws IllegalArgumentException {
		try {

			if (element instanceof Employee) {

				Employee temp = (Employee) element;

				String sql = "INSERT INTO \"workshop\".employee (ssn, name, phoneNr,mngrSsn,username,password)"
						+ "values("
						+ temp.getSsn()
						+ ","
						+ "'"
						+ temp.getName()
						+ "',"
						+ temp.getPhoneNr()
						+ ","
						+ temp.getMngrSSN()
						+ ","
						+ "'"
						+ temp.getUsername()
						+ "','" + temp.getPassword() + "');";
				adaptee.update(sql);

			} else if (element instanceof Part) {

				Part temp = (Part) element;
				if (getLocation(temp.getShelfNr(), temp.getBox()) == null) {
					T newLoc = (T) new Location(temp.getShelfNr(),
							temp.getBox());

					insert(newLoc);

					String sql = "INSERT INTO workshop.part (partId, name, make, description, category, nrOfParts, shelfNr, box)"
							+ "values ("
							+ temp.getPartID()
							+ ","
							+ "'"
							+ temp.getName()
							+ "',"
							+ "'"
							+ temp.getMake()
							+ "',"
							+ "'"
							+ temp.getDescription()
							+ "',"
							+ "'"
							+ temp.getCategory()
							+ "',"
							+ temp.getNrOfParts()
							+ ","
							+ temp.getLocation().getShelfNr()
							+ ","
							+ temp.getLocation().getBox() + ");";

					adaptee.update(sql);
					updateLocation(temp);
				} else {
					String sql = "INSERT INTO workshop.part (partId, name, make, description, category, nrOfParts, shelfNr, box)"
							+ "values ("
							+ temp.getPartID()
							+ ","
							+ "'"
							+ temp.getName()
							+ "',"
							+ "'"
							+ temp.getMake()
							+ "',"
							+ "'"
							+ temp.getDescription()
							+ "',"
							+ "'"
							+ temp.getCategory()
							+ "',"
							+ temp.getNrOfParts()
							+ ","
							+ temp.getLocation().getShelfNr()
							+ ","
							+ temp.getLocation().getBox() + ");";

					adaptee.update(sql);
					updateLocation(temp);

				}

			} else if (element instanceof Location) {

				Location temp = (Location) element;
				String sql = "INSERT INTO \"workshop\".location (shelfnr, box) "
						+ "values ("
						+ temp.getShelfNr()
						+ ","
						+ temp.getBox()
						+ ");";

				adaptee.update(sql);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T remove(T element) {
		try {

			if (element instanceof Employee) {
				Employee temp = (Employee) element;
				String sql = "DELETE FROM \"workshop\".employee WHERE ssn = "
						+ temp.getSsn() + ";";
				adaptee.update(sql);

			} else if (element instanceof Part) {
				Part temp = (Part) element;
				String sql = "DELETE FROM \"workshop\".part WHERE partId = "
						+ temp.getPartID() + ";";
				adaptee.update(sql);

			} else if (element instanceof Location) {
				Location temp = (Location) element;
				String sql = "DELETE FROM \"workshop\".location WHERE shelfNr = "
						+ temp.getShelfNr()
						+ "and box = "
						+ temp.getBox()
						+ ";";
				adaptee.update(sql);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;

	}

	@Override
	public void update(T element) throws IllegalArgumentException, SQLException {

		if (element instanceof Employee) {
			Employee temp = (Employee) element;
			int ssn = temp.getSsn();

			if (getEmployeeById(ssn) != null) {
				String sql = "UPDATE \"workshop\".employee set username = '"
						+ temp.getUsername() + "', password = '"
						+ temp.getPassword() + "' where ssn = " + temp.getSsn()
						+ ";";
				adaptee.update(sql);
			}

		}

		else if (element instanceof Part) {

			Part temp = (Part) element;
			int partid = temp.getPartID();
			if (getPartById(partid) != null) {
				String sql = "UPDATE \"workshop\".part set nrOfParts = "
						+ temp.getNrOfParts() + " where partId = "
						+ temp.getPartID() + ";";
				adaptee.update(sql);

			}

		}

		/*
		 * else if (element instanceof Location) { Location temp = (Location)
		 * element;
		 * 
		 * if (temp.getPart() != null) { String sql =
		 * "UPDATE \"workshop\".location set nrOfParts = " +
		 * temp.getPart().getNrOfParts() + ", partId = " +
		 * temp.getPart().getPartID() + " where shelfNr = " + temp.getShelfNr()
		 * + "and box = "+ temp.getBox() +";";
		 * 
		 * adaptee.update(sql);
		 * 
		 * }
		 * 
		 * }
		 */

	}

	@Override
	public Employee getEmployeeById(int ssn) throws IllegalArgumentException,
			SQLException {

		String sql = "Select * from \"workshop\".employee where ssn = " + ssn
				+ ";";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			String name = rs.getString("name");
			int phonenr = rs.getInt("phonenr");
			int mngrSSN = rs.getInt("mngrssn");
			String username = rs.getString("username");
			String password = rs.getString("password");
			return new Employee(name, ssn, phonenr, mngrSSN, username, password);
		}
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException {

		String sql = "Select * from \"workshop\".employee where username = '"
				+ username + "';";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			int ssn = rs.getInt("ssn");
			String name = rs.getString("name");
			int phonenr = rs.getInt("phonenr");
			int mngrSSN = rs.getInt("mngrssn");
			String password = rs.getString("password");
			return new Employee(name, ssn, phonenr, mngrSSN, username, password);
		}
		return null;
	}

	@Override
	public Location getLocation(int shelfNr, int box)
			throws IllegalArgumentException, SQLException {

		String sql = "Select * from \"workshop\".location where shelfnr = "
				+ shelfNr + " and box =" + box + ";";
		ResultSet rs = adaptee.query(sql);

		while (rs.next()) {
			int partId = rs.getInt("partid");

			if (partId != 0) {
				Location temp = new Location(shelfNr, box);
				return temp;

			}
			return new Location(shelfNr, box);
		}

		return null;
	}

	@Override
	public Part getPartById(int partID) throws IllegalArgumentException,
			SQLException {

		String sql = "Select * from \"workshop\".part where partId = " + partID
				+ ";";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			String name = rs.getString("name");
			String make = rs.getString("make");
			String description = rs.getString("description");
			String category = rs.getString("category");
			int nrOfParts = rs.getInt("nrOfParts");
			int shelfNr = rs.getInt("shelfNr");
			int box = rs.getInt("box");

			return new Part(partID, name, make, description, category,
					nrOfParts, shelfNr, box);
		}
		return null;
	}

	@Override
	public Part getPartByNrOfParts(int nrOfParts)
			throws IllegalArgumentException, SQLException {

		String sql = "Select * from \"workshop\".part where nrOfParts = "
				+ nrOfParts + ";";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			int partId = rs.getInt("partId");
			String name = rs.getString("name");
			String make = rs.getString("make");
			String description = rs.getString("description");
			String category = rs.getString("category");
			int shelfNr = rs.getInt("shelfNr");
			int box = rs.getInt("box");
			return new Part(partId, name, make, description, category,
					nrOfParts, shelfNr, box);

		}

		return null;
	}

	@Override
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException {
		String sql = "Select * from \"workshop\".part where name = '" + name
				+ "';";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			int partId = rs.getInt("partId");
			String make = rs.getString("make");
			String description = rs.getString("description");
			String category = rs.getString("category");
			int nrOfParts = rs.getInt("nrOfParts");
			int shelfNr = rs.getInt("shelfNr");
			int box = rs.getInt("box");

			return new Part(partId, name, make, description, category,
					nrOfParts, shelfNr, box);

		}
		return null;
	}

	@Override
	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException {
		String sql = "Select * from \"workshop\".part where category = '"
				+ category + "';";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			int partId = rs.getInt("partId");
			String name = rs.getString("name");
			String make = rs.getString("make");
			String description = rs.getString("description");
			int nrOfParts = rs.getInt("nrOfParts");
			int shelfNr = rs.getInt("shelfNr");
			int box = rs.getInt("box");

			return new Part(partId, name, make, description, category,
					nrOfParts, shelfNr, box);
		}
		return null;
	}

	@Override
	public Part getPartAtLocation(Location location)
			throws IllegalArgumentException, SQLException {
		int shelfNr = location.getShelfNr();
		int box = location.getBox();
		if (getLocation(shelfNr, box) != null) {

			String sql = "Select * from workshop.part where shelfNr = "
					+ shelfNr + " and box = " + box + ";";
			ResultSet rs = adaptee.query(sql);
			while (rs.next()) {
				int partId = rs.getInt("partId");
				String name = rs.getString("name");
				String make = rs.getString("make");
				String description = rs.getString("description");
				String category = rs.getString("category");
				int nrOfParts = rs.getInt("nrOfParts");

				return new Part(partId, name, make, description, category,
						nrOfParts, shelfNr, box);

			}
		}
		return null;

	}

	@Override
	public void updateLocation(Part element) throws IllegalArgumentException,
			SQLException {

		if (element instanceof Part) {
			Part temp = (Part) element;

			String s = "update workshop.location set nrOfParts = "
					+ temp.getNrOfParts() + ", partid = " + temp.getPartID()
					+ "where shelfNr = " + temp.getShelfNr() + " and box = "
					+ temp.getShelfNr() + ";";

			adaptee.update(s);
		}
	}

	/*
	 * @Override public ArrayList<String> getAll(String element) throws
	 * IllegalArgumentException, SQLException {
	 * 
	 * String sql = "select * from workshop." + element + ";"; ArrayList<String>
	 * arr = new ArrayList<String>(); ResultSet rs = adaptee.query(sql); int
	 * numberColumns = 0; if
	 * (element.toUpperCase().equals("employee".toUpperCase())) numberColumns =
	 * 6; else if (element.toUpperCase().equals("part".toUpperCase()))
	 * numberColumns = 8; else if
	 * (element.toUpperCase().equals("location".toUpperCase())) numberColumns =
	 * 4; String result = ""; while (rs.next()) for (int i = 1; i <=
	 * numberColumns; i++) arr.add(rs.getString(i));
	 * 
	 * return arr;
	 * 
	 * }
	 */

	public ResultSet getAll(String element) throws IllegalArgumentException,
			SQLException {

		String sql = "select * from workshop." + element + ";";

		return adaptee.query(sql);

	}

}
