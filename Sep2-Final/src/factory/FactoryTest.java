package factory;

import static org.junit.Assert.*;
import model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Bogdan and Tomas
 *  A class containing JUnit test of Factory class
 * 
 */


public class FactoryTest {

	private Factory factory;

	@Before
	public void setUp() throws Exception {
		factory = new Factory();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @author 245491
	 *	A method that creates a new Part Object with assign values
	 *	compares using AssertEquals method if Part object has same values as assigned values
	 *	It takes values as String and cast (Longs) into needed fields.
	 */
	
	@Test
	public void createPart() {
		String partId = "123";
		String name = "Part1";
		String make = "B";
		String description = "C";
		String category = "D";
		String nrOfParts = "10";
		String shelfNr = "1";
		String box = "1";

		Part part = factory.createPart(partId, name, make, description,
				category, nrOfParts, shelfNr, box);

		assertEquals(123, part.getPartID());
		assertEquals("Part1", part.getName());
		assertEquals("B", part.getMake());
		assertEquals("C", part.getDescription());
		assertEquals("D", part.getCategory());
		assertEquals(10, part.getNrOfParts());
		assertEquals(1, part.getShelfNr());
		assertEquals(1, part.getBox());

	}

	/**
	 * A method that creates a new Employee Object with assigned  values
	 * compares using AssertEquals method if Employee object has same values as assigned values
	 *	It takes values as String and cast (Longs) into needed fields.
	 */
	@Test
	public void createcreateEmployeeWithUser() {
		String name = "Bogdan";
		String ssn = "111";
		String phoneNr = "99999999";
		String mngrSSN = "13456";
		String username = "BGD";
		String password = "PSWD";

		Employee employee = factory.createEmployeeWithUser(name, ssn, phoneNr,
				mngrSSN, username, password);

		assertEquals("Bogdan", employee.getName());
		assertEquals(111, employee.getSsn());
		assertEquals(99999999, employee.getPhoneNr());
		assertEquals(13456, employee.getMngrSSN());
		assertEquals("BGD", employee.getUsername());
		assertEquals("PSWD", employee.getPassword());

	}

	/**
	 * @author 245491
	 * A method that creates a new Location Object with assigned  values
	 * compares using AssertEquals method if Location object has same values as assigned values
	 *	It takes values as String and cast (Longs) into needed fields.
	 */
	
	@Test
	public void createLocation() {
		String shelfNr = "123";
		String box = "1";

		Location location = factory.createLocation(shelfNr, box);

		assertEquals(123, location.getShelfNr());
		assertEquals(1, location.getBox());

	}

}
