package model;

import java.io.Serializable;

/**
 * @author Bogdan and Marian 
 * A class containing a Employee object class 
 * and implements Serializable.
 */

public class Employee implements Serializable {

	private String name;
	private long ssn;
	private int phoneNr;
	private long mngrSSN;
	private String username;
	private String password;

	/**
	 * Constructor initializing the Employee object.
	 * 
	 * @param name
	 *            the name of the Employee object.
	 * @param ssn
	 *            the ssn of the Employee object.
	 * @param phoneNr
	 *            the phoneNr of the Employee object.
	 * @param mngrSSN
	 *            the mngrSSN of the Employee object.
	 * @param username
	 *            the username of the Employee object.
	 * @param password
	 * 				the password of the Employee object.
	 */

	public Employee(String name, long ssn, int phoneNr, long mngrSSN,
			String username, String password) {
		this.name = name;
		this.ssn = ssn;
		this.phoneNr = phoneNr;
		this.mngrSSN = mngrSSN;
		this.username = username;
		this.password = password;
	}

	  /**
	    * Sets the MngrSSN of a Employee object.
	    * 
	    * @param mngrSSN
	    *           
	    */
	public void setMngrSSN(int mngrSSN) {
		this.mngrSSN = mngrSSN;
	}
	  /**
	    * Sets the phoneNr of a Employee object.
	    * 
	    * @param phoneNr
	    *           the phoneNr that the Employee has
	    */

	public void setPhoneNr(int phoneNr) {
		this.phoneNr = phoneNr;
	}
	  /**
	    * Sets the username of a Employee object.
	    * 
	    * @param username
	    *           the username that the Employee has
	    */

	public void setUsername(String username) {
		this.username = username;
	}
	  /**
	    * Sets the password of a Employee object.
	    * 
	    * @param password
	    *           the password that the Employee has
	    */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * * Gets the name of the Employee object.
	 * 
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * * Gets the ssn of the Employee object.
	 * 
	 * @return the ssn.
	 */
	public long getSsn() {
		return ssn;
	}

	/**
	 * * Gets the type of the Employee object.
	 * 
	 * @return the type.
	 */
	public int getPhoneNr() {
		return phoneNr;
	}

	/**
	 * * Gets the type of the Employee object.
	 * 
	 * @return the type.
	 */
	public long getMngrSSN() {
		return mngrSSN;
	}

	/**
	 * * Gets the type of the Employee object.
	 * 
	 * @return the type.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * * Gets the type of the Employee object.
	 * 
	 * @return the type.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * * Gets the username and password of the Employee object.
	 * 
	 * @return the username and password.
	 */
	public String getEmployeeLoginInfo() {
		return "\nUsername: " + username + "\nPassword: " + password;
	}

	
	/* (non-Javadoc)
	 * Indicates whether some other Employee object is "equal to" this one.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Employee))
			return false;

		Employee other = (Employee) obj;

		return name.equals(other.name) && ssn == other.ssn
				&& phoneNr == other.phoneNr && mngrSSN == other.mngrSSN
				&& username.equals(other.username)
				&& password.equals(other.password);
	}

	
	/* (non-Javadoc)
	 * Returns a string representation of the Employee object.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "";
		String value = "";
		int size = 20;

		str += ssn;
		value = "" + ssn;
		for (int i = 0; i < size - value.length(); i++) {
			str += " ";
		}
		str += name;
		for (int i = 0; i < size - name.length(); i++) {
			str += " ";
		}
		str += mngrSSN;
		value = "" + mngrSSN;
		for (int i = 0; i < size - value.length(); i++) {
			str += " ";
		}

		str += phoneNr;
		value = "" + phoneNr;
		for (int i = 0; i < size - value.length(); i++) {
			str += " ";
		}

		str += username;
		for (int i = 0; i < size - username.length(); i++) {
			str += " ";
		}
		str += password;
		for (int i = 0; i < size - password.length(); i++) {
			str += " ";
		}
		return str + "\n";
	}
}
