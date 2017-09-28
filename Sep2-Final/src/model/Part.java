package model;

import java.io.Serializable;

/** A class containing a Part object class
 * Implements Serializable
 * @author  Bogdan, Tomas and Marian
 *
 */
public class Part implements Serializable{

	private int partID;
	private int nrOfParts;
	private String name;
	private String make;
	private String description;
	private String category;
	private Location location;
	/**	Constructor initializing the Part object
	 * @param partID
	 * 		the partID of the Part object
	 * @param name
	 * 		the name of the Part object
	 * @param make
	 * 		the name of the Part object
	 * @param description
	 * 		the description of the Part object
	 * @param category
	 * 		the category of the Part object
	 * @param nrOfParts
	 * 		the nrOfParts of the Part object
	 * @param shelfNr
	 * 		the shelfNr of the Part object
	 * @param box
	 * 		the box of the Part object
	 */
	public Part(int partID,  String name, String make, String description,
			String category, int nrOfParts, int shelfNr, int box) {
		this.partID = partID;
		this.name = name;
		this.make = make;
		this.description = description;
		this.category = category;
		this.nrOfParts = nrOfParts;
		//this.location = new Location(shelfNr, box, partID, nrOfParts);
		this.location = new Location(shelfNr, box);
		
	}

	/** Sets partId of the Part Object
	 * @param partID
	 * 		partID of the Part Object
	 */
	public void setPartID(int partID) {
		this.partID = partID;
	}
	/**	Sets nrOfParts of the Part Object
	 * @param nrOfParts
	 * 		nrOfParts of the Part Object
	 */
	
	
	public void setNrOfParts(int nrOfParts) {
		this.nrOfParts = nrOfParts;
	}

	/** Sets name of the Part Object
	 * @param name
	 * 		name of the Part Object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Sets make of the Part Object
	 * @param make
	 * 		make of the PArt Object
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/** Sets description of the Part Object
	 * @param description
	 * 		description of the Part object
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Sets category of the Part Object
	 * @param category
	 * 		category of the Part object
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/** Sets location of the Part Object
	 * @param location
	 * 		location of the partObject
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**	Gets the partId of the Part object.
	 * @return
	 * 		the PartID
	 */
	public int getPartID() {
		return partID;
	}
	/**	Gets the nrOfParts of the Part object.
	 * @return
	 * 		the nrOfParts
	 */
	public int getNrOfParts() {
		return nrOfParts;
	}

	/**Gets the name of the Part object.
	 * @return
	 * 	the name
	 */
	public String getName() {
		return name;
	}

	/**Gets the make of the Part object.
	 * @return
	 * 		the make
	 */
	public String getMake() {
		return make;
	}

	/** Gets the description of the Part object.
	 * @return
	 * 		the description
	 */
	public String getDescription() {
		return description;
	}

	/** Gets the category of the Part object.
	 * @return
	 * 		the category
	 */
	public String getCategory() {
		return category;
	}

	/** Gets the location of the Part object.
	 * @return
	 * 		the location
	 */
	public Location getLocation() {
		return location;
	}
	/** Gets the ShelfNr of the Part object.
	 * @return
	 * 	the shelfNr
	 */
	public int getShelfNr()
	{
		return location.getShelfNr();
	}
	/**Gets the box of the Part object.
	 * @return
	 * 	the box
	 */
	public int getBox()
	{
		return location.getBox();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "";
		String value = "";
		int size = 20;
		
		str += partID;
		value = ""+partID;
		for (int i = 0; i < size-value.length(); i++) {
			str += " ";
		}
		
		str += "  "+name;
		for (int i = 0; i < size- name.length(); i++) {
			str += " ";
		}
		str += "  "+make;
		for (int i = 0; i < 10-make.length(); i++) {
			str += " ";
		}
		str +=  "  "+description;
		for (int i = 0; i < size-description.length(); i++) {
			str += " ";
		}
		str += "  "+category;
		for (int i = 0; i < 15-category.length(); i++) {
			str += " ";
		}
		str +="  "+ nrOfParts;
		value=""+nrOfParts;
		for (int i = 0; i < 11-value.length(); i++) {
			str += " ";
		}
		
		return str + location +"\n";
	}
}
