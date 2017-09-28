package model;

import java.io.Serializable;

public class Location implements Serializable{

	private int shelfNr;
	private int box;
	

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
	public void setShelfNr(int shelfNr) {
		this.shelfNr = shelfNr;
	}

	public void setBox(int box) {
		this.box = box;
	}


	public int getShelfNr() {
		return shelfNr;
	}

	public int getBox() {
		return box;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Location))
			return false;

		Location other = (Location) obj;

		return shelfNr == other.shelfNr && box == other.box;
	}

	public String toString() {
		return "\nLocation: \nShelf: " + shelfNr + "\nBox: " + box;
	}
}
