package factory;

import model.*;

/**
 * This class generates request objects of necessary types.(Employee, Part, Location)
 * @author Bogdan and Tomas
 *
 */
public class Factory {

	
	/**
	 * Creates a new part using the parameters.
	 * @param partId the part id
	 * @param name the part name
	 * @param make the maker name
	 * @param description the part description
	 * @param category the category
	 * @param nrOfParts the number of parts available
	 * @param shelfNr the shelf number
	 * @param box the box number
	 * @return 
	 * @throws IllegalArgumentException
	 */
	public Part createPart(String partId, String name, String make,
			String description, String category, String nrOfParts,
			String shelfNr, String box) throws IllegalArgumentException {
		int part = Integer.parseInt(partId);
		int nrParts = Integer.parseInt(nrOfParts);
		int shelf = Integer.parseInt(shelfNr);
		int b = Integer.parseInt(box);

		return new Part(part, name, make, description, category, nrParts,
				shelf, b);
	
	}

	/**
	 * Creates an employee using the parameters
	 * @param name the name of the employee
	 * @param ssn the social security number of the employee
	 * @param phoneNr the phone number
	 * @param mngrSSN the manager social security number
	 * @param username the username of the employee
	 * @param password the password of the employee
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Employee createEmployeeWithUser (String name, String ssn,
			String phoneNr, String mngrSSN, String username, String password) throws IllegalArgumentException {
		long SSN = Long.parseLong(ssn);
		int phone = Integer.parseInt(phoneNr);
		long mngr = Long.parseLong(mngrSSN);

		return new Employee(name, SSN, phone, mngr, username, password);

	}



	/**
	 * Creates a new location to store parts
	 * @param shelfNr the shelf number
	 * @param box the box number
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Location createLocation(String shelfNr, String box)throws IllegalArgumentException  {
		int shelf = Integer.parseInt(shelfNr);
		int b = Integer.parseInt(box);

		return new Location(shelf, b);

	}
	
	
	
	public Log createLog(String log_id, String log_time, String description)throws IllegalArgumentException{
		return new Log(log_id, log_time, description);
	}
	
	
}
