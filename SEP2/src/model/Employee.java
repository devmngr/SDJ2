package model;

import java.io.Serializable;

public class Employee implements Serializable {

	private String name;
	private int ssn;
	private int phoneNr;
	private int mngrSSN;
	private String username;
	private String password;

	public Employee(String name, int ssn, int phoneNr, int mngrSSN,
			String username, String password) {
		this.name = name;
		this.ssn = ssn;
		this.phoneNr = phoneNr;
		this.mngrSSN = mngrSSN;
		this.username = username;
		this.password = password;
	}

	public Employee(String name, int ssn, int phoneNr, int mngrSSN) {
		this.name = name;
		this.ssn = ssn;
		this.phoneNr = phoneNr;
		this.mngrSSN = mngrSSN;
		this.username = null;
		this.password = null;

	}

	public void setMngrSSN(int mngrSSN) {
		this.mngrSSN = mngrSSN;
	}

	public void setPhoneNr(int phoneNr) {
		this.phoneNr = phoneNr;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public int getSsn() {
		return ssn;
	}

	public int getPhoneNr() {
		return phoneNr;
	}

	public int getMngrSSN() {
		return mngrSSN;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getEmployeeLoginInfo() {
		return "\nUsername: " + username + "\nPassword: " + password;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Employee))
			return false;

		Employee other = (Employee) obj;

		return name.equals(other.name) && ssn == other.ssn
				&& phoneNr == other.phoneNr && mngrSSN == other.mngrSSN
				&& username.equals(other.username)
				&& password.equals(other.password);
	}

	public String toString() {
		String str = "";
		String value = "";
		int size = 40;
		str += name;
		for (int i = 0; i < size-name.length(); i++) {
			str += " ";
		}
		
		str += ssn;
		value = ""+ssn;
		for (int i = 0; i < size- value.length(); i++) {
			str += " ";
		}
		str += phoneNr;
		value = ""+phoneNr;
		for (int i = 0; i < size-value.length(); i++) {
			str += " ";
		}
		str +=  mngrSSN;
		value=""+mngrSSN;
		for (int i = 0; i < size-value.length(); i++) {
			str += " ";
		}
		str += username;
		for (int i = 0; i < size-username.length(); i++) {
			str += " ";
		}
		str += password;
		for (int i = 0; i < size-password.length(); i++) {
			str += " ";
		}
		return str + "\n";
	}
}
