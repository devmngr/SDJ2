package model;

public class Customer {
	
	private String name;
	private int ssn;
	private int age;
	private int phoneNr;
	private	int driverLicenseNr;	
	private	String address;
	private	String email; 
	
	public Customer(String name, int ssn, int age, int phoneNr,int driverLicenseNr, String address, String email)
	{
		this.name =name;
		this.ssn =ssn;
		this.age = age;
		this.phoneNr =phoneNr;
		this.driverLicenseNr =driverLicenseNr;
		this.address =address;
		this.email =email;
	}
	public int getSsn() {
		return ssn;
	}
	
	
	public String toString()
	{
	return "Name: " + name + "\nSSN: " +ssn + "\nAge: " + age + "\nPhone nr: "+ phoneNr + 
			"\nDriver License: "+ driverLicenseNr + "\nAddress: " + address + "\nEmail: " + email;
	}
}
