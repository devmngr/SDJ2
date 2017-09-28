package factory;

import model.*;

public class Factory {

	public Factory() {
	}
	
	public Part createPart(String partId, String name, String make,
			String description, String category, String nrOfParts, String shelfNr, String box) throws IllegalArgumentException {
		int part = Integer.parseInt(partId);
		int nrParts = Integer.parseInt(nrOfParts);
		int shelf = Integer.parseInt(shelfNr);
		int b = Integer.parseInt(box);

			return new Part(part, name, make, description, category, nrParts, shelf, b);
	
	}

	public Employee createEmployeeWithUser (String name, String ssn,
			String phoneNr, String mngrSSN, String username, String password) throws IllegalArgumentException {
		int SSN = Integer.parseInt(ssn);
		int phone = Integer.parseInt(phoneNr);
		int mngr = Integer.parseInt(mngrSSN);

		return new Employee(name, SSN, phone, mngr, username, password);

	}

	public Employee createEmployeeNoUser(String name, String ssn,
			String phoneNr, String mngrSSN) throws IllegalArgumentException {
		int SSN = Integer.parseInt(ssn);
		int phone = Integer.parseInt(phoneNr);
		int mngr = Integer.parseInt(mngrSSN);

		return new Employee(name, SSN, phone, mngr);
	}

	public Location createLocation(String shelfNr, String box)throws IllegalArgumentException  {
		int shelf = Integer.parseInt(shelfNr);
		int b = Integer.parseInt(box);

		return new Location(shelf, b);

	}

}
