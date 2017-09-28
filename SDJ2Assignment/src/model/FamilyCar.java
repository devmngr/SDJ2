package model;

import java.io.Serializable;

/**
 * A class containing a Vehicle object the type FamilyCar which extends the
 * Vehicle class and implements Serializable.
 * 
 * @author Bogdan Mitrache
 * @version 1.0
 */
public class FamilyCar extends Vehicle {

	private static final String TYPE = "Family Car";

	/**
	 * Constructor initializing the FamilyCar .
	 *
	 * @param model
	 *            the model of the FamilyCar.
	 * @param pricePerDay
	 *            the price per day of the FamilyCar.
	 * 
	 * @param numberPlates
	 *            the number plates (registration number) of the FamilyCar.
	 */
	public FamilyCar(String make, String model, int pricePerDay,
			String numberPlates) {
		super(TYPE, make, model, pricePerDay, numberPlates);
	}

	/**
	 * Indicates whether some other FamilyCar object is "equal to" this one.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof FamilyCar)) {
			return false;
		}

		FamilyCar other = (FamilyCar) obj;
		return super.equals(obj);
	}

	/**
	 * Returns a string representation of the FamilyCar object.
	 */
	public String toString() {
		return super.toString();
	}
}
