package model;

/**
 * A class containing a Vehicle object
 * 
 * @author Bogdan Mitrache
 * @version 1.0
 */
public class Vehicle {
	private String type;
	private String make;
	private String model;
	private int pricePerDay;
	private String numberPlates;

	/**
	 * Constructor initializing the Vehicle object .
	 * 
	 * @param type
	 *            the type of the Vehicle.
	 * @param make
	 *            the make of the Vehicle.
	 * @param model
	 *            the model of the Vehicle.
	 * @param pricePerDay
	 *            the price per day of the Vehicle.
	 * @param numberPlates
	 *            the number plates (registration number) of the Vehicle.
	 */
	public Vehicle(String type, String make, String model, int pricePerDay,
			String numberPlates) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.pricePerDay = pricePerDay;
		this.numberPlates = numberPlates;
	}

	/**
	 * * Gets the price per day of the Vehicle object.
	 * 
	 * @return the price per one day.
	 */
	public int getPricePerDay() {
		return pricePerDay;
	}

	/**
	 * * Gets the number plates/registration number of the Vehicle object.
	 * 
	 * @return the number plates.
	 */
	public String getNumberPlates() {
		return numberPlates;
	}
	public String getType() {
		return type;
	}

	/**
	 * Indicates whether some other Vehicle object is "equal to" this one.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Vehicle)) {
			return false;
		}

		Vehicle other = (Vehicle) obj;
		return type.equals(other.type) && model.equals(other.model)
				&& pricePerDay == other.pricePerDay
				&& numberPlates.equals(other.numberPlates);

	}

	/**
	 * Returns a string representation of the Vehicle object.
	 */
	public String toString() {
		return "\nVehicle: " + type + "\nMake: " + make + "\nModel: " + model
				+ "\nNumberplates: " + numberPlates + "\nPrice per day: "
				+ pricePerDay;
	}
}
