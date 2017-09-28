package model;

import java.io.Serializable;

/**
 * @author  Bogdan and Marian
 *	A Class containing Location object class
 *	implements Serializable
 */

public class Location implements Serializable{

	private int shelfNr;
	private int box;
	

	/** 	Constructor initializing the Location object
	 * @param shelfNr
	 * 		the shelfNr of Location object
	 * @param box
	 * 		box  of Location object
	 */
	public Location(int shelfNr, int box) {
		this.shelfNr = shelfNr;
		this.box = box;
	}

/*
 * Location will be assigned in Part
 * 
	public Location(int shelfNr, int box, int partId, int nrOfParts) {
		this.shelfNr = shelfNr;
		this.box = box;
		
	}
*/
	/**	Sets  ShelfNr of a Location object
	 * @param shelfNr
	 */
	public void setShelfNr(int shelfNr) {
		this.shelfNr = shelfNr;
	}

	/** Sets box of a Location object
	 * @param box
	 */
	public void setBox(int box) {
		this.box = box;
	}


	/**	Gets shelfNr of the Location object
	 * @return
	 * 		returns shelfNr
	 */
	public int getShelfNr() {
		return shelfNr;
	}

	
	/** Gets box of the location object
	 * @return
	 * 		returns box
	 */
	public int getBox() {
		return box;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Location))
			return false;

		Location other = (Location) obj;

		return shelfNr == other.shelfNr && box == other.box;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "";
		String value = "";
		int size = 5;
		
		str += "  "+shelfNr;
		value = ""+shelfNr;
		for (int i = 0; i < size-value.length(); i++) {
			str += " ";
		}	
		str += "  "+box;
		value = ""+box;
		for (int i = 0; i < size- value.length(); i++) {
			str += " ";
		}
		return str;
	}
}
