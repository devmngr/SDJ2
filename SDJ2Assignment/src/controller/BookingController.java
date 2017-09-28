package controller;

import java.util.Date;

import util.Cin;
import model.Booking;
import model.BookingManager;
import model.Customer;
import model.Vehicle;
import adaptor.Adaptor;

public class BookingController {

	private BookingManager manager;
	private Date s;
	private Date e;
	private Vehicle vehicle;
	private Customer customer;
	private String pickUp;
	private String drop;
	private double price;

	public BookingController() {
		manager = new BookingManager();
	}

	public void addBooking(Booking booking) {
		manager.addBooking(booking);
	}

	public void removeBooking(Booking booking) {
		manager.removeBooking(booking);
	}

	public Booking getBooking(int bookingId) {
		return manager.getBooking(bookingId);
	}

	public Booking getBookingByNumberPlates(String numberPlates) {
		return manager.getBookingByNumberPlates(numberPlates);
	}

	public Adaptor getAllBookings() {
		return manager.getAllBookings();
	}

	public Customer createCustomer() {
		System.out.println("Enter customer details: \nFull name");
		String name = Cin.readString();
		System.out.println("SSN: ");
		int ssn = Cin.readInt();
		System.out.println("Age: ");
		int age = Cin.readInt();
		System.out.println("Phone nr: ");
		int phoneNr = Cin.readInt();
		System.out.println("Driver license nr: ");
		int driverLicenseNr = Cin.readInt();
		System.out.println("Address: ");
		String address = Cin.readString();
		System.out.println("Email: ");
		String email = Cin.readString();

		Customer temp = new Customer(name, ssn, age, phoneNr, driverLicenseNr,
				address, email);

		return temp;
	}

	public void book(String vehicleType) {

		this.vehicle = chosenVehicle(vehicleType);
		this.customer = createCustomer();
		System.out.println("Enter Pick-Up Location: ");
		this.pickUp = Cin.readString();
		System.out.println("Enter Drop Location: ");
		this.drop = Cin.readString();
		System.out.println("Enter total price: ");
		this.price = Cin.readDouble();
		Booking booking = new Booking(customer, price, s, e, pickUp, drop,
				vehicle);
		manager.addBooking(booking);
		System.out.println("Booking done!");

	}

	public Vehicle chosenVehicle(String vehicleType) {
		System.out.println("Available " + vehicleType + "s on chosen dates: ");
		System.out.println(manager.getAvailableVehiclesInPeriodByType(
				vehicleType, s, e));
		System.out.println("Choose desired " + vehicleType
				+ " by writing the number plates of the car: ");
		String numberPlates = Cin.readString();
		Vehicle temp = manager.getVehicleByNumberPlates(numberPlates);

		return temp;
	}

	public void enterDates() {
		System.out.println("Enter desired pick up date! \n(YYYY-MM-DD): ");
		String start = Cin.readString();
		int sYear = Integer.parseInt(start.substring(0, 3));
		int sMonth = Integer.parseInt(start.substring(5, 7));
		int sDay = Integer.parseInt(start.substring(8, 10));
		System.out.println("\nEnter desired drop date! \n(YYYY-MM-DD): ");
		String end = Cin.readString();
		int eYear = Integer.parseInt(start.substring(0, 3));
		int eMonth = Integer.parseInt(start.substring(5, 7));
		int eDay = Integer.parseInt(start.substring(8, 10));

		s = new Date(sYear, sMonth, sDay);
		e = new Date(eYear, eMonth, eDay);
		System.out.println("\nChoose: \n1.Family Car\n" + "2.Van\n"
				+ "3.Moving Truck\n" + "0.Back");

	}

	public int numberOfBookings() {
		return manager.numberOfBookings();
	}
}
