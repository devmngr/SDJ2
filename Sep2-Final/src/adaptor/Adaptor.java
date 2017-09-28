package adaptor;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.*;

/**
 * This class is used to transfer data from and to the database
 * 
 * @author Bogdan and Tomas
 *
 * @param <T>
 */
public class Adaptor<T> implements IAdaptor<T> {

	private Adaptee adaptee;

	/**
	 * Constructor initiates the database schema and tables if they don't exist
	 * already
	 * 
	 * @throws ClassNotFoundException
	 */
	public Adaptor() throws ClassNotFoundException {
		adaptee = new Adaptee();
	}
	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#insert(java.lang.Object)
	 */
	@Override
	public void insert(T element) throws IllegalArgumentException, Exception {

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

					String sql = "INSERT INTO \"workshop\".part (partId, name, make, description, category, nrOfParts, shelfNr, box)"
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
					String sql = "INSERT INTO \"workshop\".part (partId, name, make, description, category, nrOfParts, shelfNr, box)"
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
				String sql = "";
				// if (getLocation(temp.getShelfNr(), temp.getBox()) == null){
				sql = "INSERT INTO \"workshop\".location (shelfnr, box) "
						+ "values (" + temp.getShelfNr() + "," + temp.getBox()
						+ ");";
				// }
				System.out.println(sql);
				adaptee.update(sql);

			}

		} catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG WHEN ADDING!!!");
			throw new Exception("Cannot add duplicate");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#remove(java.lang.Object)
	 */
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
			throw new IllegalArgumentException();
		}
		return element;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#update(java.lang.Object)
	 */
	@Override
	public void update(T element) throws IllegalArgumentException, SQLException {

		if (element instanceof Employee) {
			Employee temp = (Employee) element;
			long ssn = temp.getSsn();

			if (getEmployeeById(ssn) != null) {
				String sql = "UPDATE \"workshop\".employee set name = '"
						+ temp.getName() + "', phoneNr = " + temp.getPhoneNr()
						+ ", mngrssn = " + temp.getMngrSSN() + ", username = '"
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
				String sql = "UPDATE \"workshop\".part set name = '"
						+ temp.getName() + "', make = '" + temp.getMake()
						+ "', description = '" + temp.getDescription()
						+ "', category = '" + temp.getCategory()
						+ "', shelfNr = " + temp.getShelfNr() + ", box = "
						+ temp.getBox() + ", nrOfParts = "
						+ temp.getNrOfParts() + " where partId = "
						+ temp.getPartID() + ";";
				adaptee.update(sql);

			}
		} else if (element instanceof Location) {

			Location temp = (Location) element;
			int shelf = temp.getShelfNr();
			int box = temp.getBox();

			if (getLocation(shelf, box) != null) {
				String sql = "UPDATE \"workshop\".part set shelfNr = "
						+ temp.getShelfNr() + " and box = " + temp.getBox()
						+ "where shelfnr =" + shelf + "and box = " + box + ";";
				adaptee.update(sql);
			}

		}
	}

	@Override
	public void updateNrOfPartsAtLocation(Location location, int nrOfParts,
			int partId) throws SQLException {
		if (location != null) {
			String sql = "UPDATE \"workshop\".part set nrOfParts = "
					+ nrOfParts + "where shelfnr =" + location.getShelfNr()
					+ "and box = " + location.getBox() + "and partId = "
					+ partId + ";";
			adaptee.update(sql);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getEmployeeById(int)
	 */
	@Override
	public Employee getEmployeeById(long ssn) throws IllegalArgumentException,
			SQLException {

		String sql = "Select * from \"workshop\".employee where ssn = " + ssn
				+ ";";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			String name = rs.getString("name");
			int phonenr = rs.getInt("phonenr");
			long mngrSSN = rs.getLong("mngrssn");
			String username = rs.getString("username");
			String password = rs.getString("password");
			return new Employee(name, ssn, phonenr, mngrSSN, username, password);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getEmployeeByUsername(java.lang.String)
	 */
	@Override
	public Employee getEmployeeByUsername(String username)
			throws IllegalArgumentException, SQLException {

		String sql = "Select * from \"workshop\".employee where username = '"
				+ username + "' order by name;";
		ResultSet rs = adaptee.query(sql);
		while (rs.next()) {
			long ssn = rs.getInt("ssn");
			String name = rs.getString("name");
			int phonenr = rs.getInt("phonenr");
			long mngrSSN = rs.getInt("mngrssn");
			String password = rs.getString("password");
			return new Employee(name, ssn, phonenr, mngrSSN, username, password);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getLocation(int, int)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getPartById(int)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getPartByNrOfParts(int)
	 */
	@Override
	public Part getPartByNrOfParts(int nrOfParts)
			throws IllegalArgumentException, SQLException {

		String sql = "Select * from \"workshop\".part where nrOfParts = "
				+ nrOfParts + " order by nrOfParts;";
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getPartByName(java.lang.String)
	 */
	@Override
	public Part getPartByName(String name) throws IllegalArgumentException,
			SQLException {
		String sql = "Select * from \"workshop\".part where name = '" + name
				+ "' order by name;";
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getPartByCategory(java.lang.String)
	 */
	@Override
	public Part getPartByCategory(String category)
			throws IllegalArgumentException, SQLException {
		String sql = "Select * from \"workshop\".part where category = '"
				+ category + "' order by name;";
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getPartAtLocation(model.Location)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#updateLocation(model.Part)
	 */
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
	 * (non-Javadoc)
	 * 
	 * @see adaptor.IAdaptor#getAll(java.lang.String)
	 */
	@Override
	public ResultSet getAll(String element) throws IllegalArgumentException,
			SQLException {
		String sql = "";
		if (element.equals("employee") || element.equals("part"))
		 sql = "select * from workshop." + element + " order by name;";
		else if (element.equals("location"))
			 sql = "select * from workshop." + element + " order by shelfNr;";
		return adaptee.query(sql);

	}
	@Override
	public ResultSet getLowStock() throws SQLException
	{
		
		String sql = "select * from workshop.part where nrOfParts <=3 ORDER BY name;";
		
		return adaptee.query(sql);
		
		
	}
	
	
	@Override
	public ResultSet getLogAll() throws SQLException
	{
		
		String sql = "select * from workshop.log ORDER BY log_time;";
		
		return adaptee.query(sql);
		
		
	}

	
	@Override
	public void buildDatabase(){
		String sql = "CREATE SCHEMA IF NOT EXISTS workshop;";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("CREATE SCHEMA IF NOT EXISTS (workshop) FAILED");
		}
		sql="CREATE TABLE IF NOT EXISTS workshop.location(shelfNr int, box int, nrOfParts int, partId int, PRIMARY KEY (shelfNr, box));";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("CREATE TABLE IF NOT EXISTS (location) FAILED");
		}
		
		sql="CREATE TABLE IF NOT EXISTS workshop.part(partId int PRIMARY KEY, name varchar NOT NULL, make varchar NOT NULL, description varchar, category varchar NOT NULL, nrOfParts int, shelfNr int, box int);";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("CREATE TABLE IF NOT EXISTS (part) FAILED");
		}
		
		
		sql="CREATE TABLE IF NOT EXISTS workshop.employee(ssn numeric PRIMARY KEY, name varchar NOT NULL, phoneNr int NOT NULL, mngrSsn numeric NOT NULL, username varchar, password varchar);";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("CREATE TABLE IF NOT EXISTS (employee) FAILED");
		}

		////////// TRIGGERS
		sql="CREATE TABLE IF NOT EXISTS workshop.log ( log_id serial NOT NULL, log_time time with time zone, description varchar(200), CONSTRAINT log_pkey PRIMARY KEY (log_id) );";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CREATE TABLE LOG FAILED");
		}
		

		sql="CREATE OR REPLACE FUNCTION set_log_order () RETURNS trigger AS $BODY$ BEGIN IF (TG_OP = 'INSERT') THEN INSERT INTO workshop.log (log_id, log_time, description ) VALUES (DEFAULT, now(), 'INSERT PART: '||new.nrofparts || ' parts with id '|| new.partid || ' added at shelf '||new.shelfnr||', box '||new.box); ELSIF (TG_OP = 'UPDATE') THEN IF (NEW.nrofparts != OLD.nrofparts and NEW.box = OLD.box and NEW.category = OLD.category and NEW.description = OLD.description and NEW.make = OLD.make and NEW.name = OLD.name and NEW.partid = OLD.partid and NEW.shelfnr = OLD.shelfnr) THEN INSERT INTO workshop.log (log_id, log_time, description ) VALUES (DEFAULT, now(), 'UPDATE NR OF PARTS: '||'Number of parts '||new.nrofparts || ' updated for ' || new.name || ', id ' || new.partid); ELSIF (NEW.box != OLD.box or NEW.category != OLD.category or NEW.description != OLD.description or NEW.make != OLD.make or NEW.name != OLD.name or NEW.partid != OLD.partid or NEW.shelfnr != OLD.shelfnr) THEN INSERT INTO workshop.log (log_id, log_time, description ) VALUES (DEFAULT, now(), 'UPDATE PART: Part id '||new.partid|| ', Name: ' || new.name || ', Make: ' || new.make|| ', Category: '||new.category|| ', Shelf: '||NEW.shelfnr||', Box: '||NEW.box||', Nr of parts: '||NEW.nrofparts||' updated.'); END IF; ELSEIF (TG_OP = 'DELETE') THEN INSERT INTO workshop.log (log_id, log_time, description ) VALUES (DEFAULT, now(), 'PART DELETED: Part Id '|| old.partid || ' from shelf '||old.shelfnr||', box '||old.box); END IF; RETURN New; END; $BODY$ LANGUAGE plpgsql;";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CREATE FUNCTION PART LOG FAILED");
		}
		
		sql="DROP TRIGGER IF EXISTS log_orders_trigger ON workshop.part CASCADE; CREATE TRIGGER log_orders_trigger BEFORE INSERT OR UPDATE ON workshop.part FOR EACH ROW EXECUTE PROCEDURE set_log_order (); DROP TRIGGER IF EXISTS log_orders_trigger_delete ON workshop.part CASCADE; CREATE TRIGGER log_orders_trigger_delete AFTER DELETE ON workshop.part FOR EACH ROW EXECUTE PROCEDURE set_log_order ();";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CREATE BIND TRIGGER PART LOG FAILED");
		}
		
		sql="CREATE OR REPLACE FUNCTION set_log_employee () RETURNS trigger AS $BODY$ BEGIN IF (TG_OP = 'INSERT') THEN INSERT INTO workshop.log (log_id, log_time, description ) VALUES (DEFAULT, now(), 'INSERT EMPLOYEE: SSN: '|| new.ssn || ' Name: '|| new.name || ' Phone nr: '||new.phonenr||' Manager: '||new.mngrssn||' added.'); ELSIF (TG_OP = 'UPDATE') THEN IF (NEW.ssn != OLD.ssn or NEW.name != OLD.name or NEW.mngrssn != OLD.mngrssn or NEW.phonenr != OLD.phonenr or NEW.username != OLD.username or NEW.password != OLD.password) THEN INSERT INTO workshop.log (log_id, log_time, description ) VALUES (DEFAULT, now(), 'UPDATE EMPLOYEE: SSN: '|| new.ssn || ' Name: '|| new.name || ' Phone nr: '||new.phonenr||' Manager: '||new.mngrssn||' edited.'); END IF; ELSEIF (TG_OP = 'DELETE') THEN INSERT INTO workshop.log (log_id, log_time, description ) VALUES (DEFAULT, now(), 'EMPLOYEE DELETED: SSN: '|| old.ssn || ' Name: '|| old.name || ' Phone nr: '||old.phonenr||' Manager: '||old.mngrssn); END IF; RETURN New; END; $BODY$ LANGUAGE plpgsql;";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CREATE FUNCTION EMPLOYEE LOG FAILED");
		}
		
		sql="DROP TRIGGER IF EXISTS log_employee_trigger ON workshop.employee CASCADE; CREATE TRIGGER log_employee_trigger BEFORE INSERT OR UPDATE ON workshop.employee FOR EACH ROW EXECUTE PROCEDURE set_log_employee (); DROP TRIGGER IF EXISTS log_employee_trigger_delete ON workshop.employee CASCADE; CREATE TRIGGER log_employee_trigger_delete AFTER DELETE ON workshop.employee FOR EACH ROW EXECUTE PROCEDURE set_log_employee ();";
		try {
			adaptee.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CREATE BIND TRIGGER EMPLOYEE LOG FAILED");
		}
		
		}
	
}
