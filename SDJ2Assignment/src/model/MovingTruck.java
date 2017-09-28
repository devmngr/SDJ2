package model;


/**
 * A class containing a Vehicle object the type MovingTruck which extends the
 * Vehicle class and implements Serializable.
 * 
 * @author Bogdan Mitrache
 * @version 1.0
 */
public class MovingTruck extends Vehicle{
	private String tonnage;
	private int fuelCapacity;
	private static final String TYPE= "Truck";

	/**
	 * Constructor initializing the MovingTruck .
	 * 
	 * @param type
	 *            the type of the Vehicle object (MovingTruck).
	 * @param model
	 *            the model of the MovingTruck.
	 * @param make
	 *            the make of the MovingTruck.
	 * @param pricePerDay
	 *            the price per day of the MovingTruck.
	 * @param numberPlates
	 *            the number plates (registration number) of the MovingTruck.
	 * @param fuelCapacity
	 *            the maxim tank fuel capacity of the MovingTruck.
	 * @param tonage
	 *            the tonnage of the MovingTruck.
	 */
	public MovingTruck( String make, String model, int pricePerDay,
			String numberPlates, String tonnage, int fuelCapacity) {
		
		super(TYPE, make, model, pricePerDay, numberPlates);

		this.fuelCapacity = fuelCapacity;
		this.tonnage = tonnage;
	}

	/**
	 * Indicates whether some other MovingTruck object is "equal to" this one.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof MovingTruck)) {
			return false;
		}

		MovingTruck other = (MovingTruck) obj;
		return super.equals(obj) && fuelCapacity == other.fuelCapacity
				&& other.tonnage == tonnage;
	}

	/**
	 * Returns a string representation of the MovingTruck object.
	 */
	public String toString()
   {
      return super.toString()+ "\nFuel tank capacity: " + fuelCapacity+ "\nTonnage: " + tonnage;
   }
}
