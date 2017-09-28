package model;



/**
 * A class containing a Vehicle object the type Van which extends the Vehicle
 * class and implements Serializable.
 * 
 * @author Bogdan Mitrache
 * @version 1.0
 */
public class Van extends Vehicle {
	private int loadCapacity;
	private boolean autoPilot;
	private final static String TYPE = "Van";

	/**
	 * Constructor initializing the Van .
	 * 
	 * @param type
	 *            the type of the Vehicle object (Van).
	 * @param make
	 *            the make of the Van.s
	 * @param model
	 *            the model of the Van.
	 * @param pricePerDay
	 *            the price per day of the Van.
	 * @param numberPlates
	 *            the number plates (registration number) of the Van.
	 * @param loadCapacity
	 *            the maxim load size of the Van.
	 * @param autopilot
	 *            the Van has or does not have autopilot.
	 */
	public Van( String make, String model, int pricePerDay,
			String numberPlates, int loadCapacity,
			boolean autoPilot) 
	{
		super(TYPE, make, model, pricePerDay, numberPlates);
		this.loadCapacity = loadCapacity;
		this.autoPilot = autoPilot;
	}

	/**
	 * Indicates whether some other Van object is "equal to" this one.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Van)) {
			return false;
		}

		Van other = (Van) obj;
		return super.equals(obj) && loadCapacity == other.loadCapacity
				&& other.autoPilot == autoPilot;
	}

	/**
	 * Returns a string representation of the Van object.
	 */
	public String toString() {
		return super.toString() + "\nLoad capacity: " + loadCapacity
				+ "\nAutopilot: " + autoPilot;
	}

}
