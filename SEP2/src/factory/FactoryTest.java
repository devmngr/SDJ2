package factory;

import model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FactoryTest {

	private Factory factory;

	@Before
	public void setUp() throws Exception {
		factory = new Factory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void createPart() {
		String partId = "123";
		String name = "Part1";
		String make = "B";
		String description = "C";
		String category = "D";
		//factory.createPart(partId, name, make, description, category);

		String id = "AAA";
		//factory.createPart(id, name, make, description, category);

	}

	@Test(expected = IllegalArgumentException.class)
	public void createcreateEmployeeWithUser() {
		String name = "Bogdan";
		String ssn = "111";
		String phoneNr = "99999999";
		String mngrSSN = "13456";
		String username = "BGD";
		String password = "PSWD";
		factory.createEmployeeWithUser(name, ssn, phoneNr, mngrSSN, username,
				password);

		String id = "AAA";
		factory.createEmployeeWithUser(name, id, phoneNr, mngrSSN, username,
				password);

	}

	@Test(expected = IllegalArgumentException.class)
	public void createEmployeeNoUser() {
		String name = "Bogdan";
		String ssn = "111";
		String phoneNr = "99999999";
		String mngrSSN = "13456";
		factory.createEmployeeNoUser(name, ssn, phoneNr, mngrSSN);

		String id = "AAA";
		factory.createEmployeeNoUser(name, id, phoneNr, mngrSSN);

	}

	@Test(expected = IllegalArgumentException.class)
	public void createLocation()
	{
		String shelfNr= "123";
		String box="1";
		
		factory.createLocation(shelfNr, box);
		
		String s = "AAA";
		String b = "BBB";
		factory.createLocation(s, b);
		
	}

}
