package ServerWithSockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import adaptor.Adaptor;
import model.Booking;
import model.BookingManager;
import model.Customer;
import model.Vehicle;

public class ServerController {

	Date s;
	Date e;
	ObjectOutputStream outToClient;
	ObjectInputStream inFromClient;
	BookingManager manager;
	Customer customer;
	Vehicle vehicle;

	public ServerController() {

		manager = new BookingManager();
		
	}

	public void readDates() {
		try {
			outToClient
					.writeBytes("Enter desired pick up date! \n(YYYY-MM-DD): ");
			String start = inFromClient.readLine();
			int sYear = Integer.parseInt(start.substring(0, 3));
			int sMonth = Integer.parseInt(start.substring(5, 7));
			int sDay = Integer.parseInt(start.substring(8, 10));
			s = new Date(sYear, sMonth, sDay);

			outToClient
					.writeBytes("\nEnter desired drop date! \n(YYYY-MM-DD): ");
			String end = inFromClient.readLine();
			int eYear = Integer.parseInt(start.substring(0, 3));
			int eMonth = Integer.parseInt(start.substring(5, 7));
			int eDay = Integer.parseInt(start.substring(8, 10));
			e = new Date(eYear, eMonth, eDay);
			outToClient.writeBytes("\nChoose: \n1.Family Car\n" + "2.Van\n"
					+ "3.Moving Truck\n" + "0.Back");
		} catch (IOException e) {

		}
	}

	public Vehicle chooseVehicle(String vehicleType) {
		try {
			outToClient.writeBytes("Available "
					+ "Family Car"
					+ "s on chosen dates: "
					+ manager.getAvailableVehiclesInPeriodByType(vehicleType,
							s, e));

			outToClient.writeBytes("Choose desired " + vehicleType
					+ " by writing the number plates of the car: ");
			String numberPlates = inFromClient.readLine();
			Vehicle temp = manager.getVehicleByNumberPlates(numberPlates);
			return temp;
		} catch (IOException e) {

		}
		return null;
	}

	public Customer createCustomer() {
		try {
			outToClient.writeBytes("Enter customer details: \nFull name");
			String name = inFromClient.readLine();
			outToClient.writeBytes("SSN: ");
			int ssn = inFromClient.readInt();
			outToClient.writeBytes("Age: ");
			int age = inFromClient.readInt();
			outToClient.writeBytes("Phone nr: ");
			int phoneNr = inFromClient.readInt();
			outToClient.writeBytes("Driver license nr: ");
			int driverLicenseNr = inFromClient.readInt();
			outToClient.writeBytes("Address: ");
			String address = inFromClient.readLine();
			outToClient.writeBytes("Email: ");
			String email = inFromClient.readLine();

			Customer customer = new Customer(name, ssn, age, phoneNr,
					driverLicenseNr, address, email);
			return customer;
		} catch (IOException e) {

		}
		return null;
	}

	public void book(String vehicleType) {
		try {
			this.vehicle = chooseVehicle(vehicleType);
			this.customer = createCustomer();
			outToClient.writeBytes("Enter Pick-Up Location: ");
			String pickUp = inFromClient.readLine();
			outToClient.writeBytes("Enter Drop Location: ");
			String drop = inFromClient.readLine();
			outToClient.writeBytes("Enter total price: ");
			double price = inFromClient.readDouble();
			Booking booking = new Booking(customer, price, s, e, pickUp, drop,
					vehicle);
			manager.addBooking(booking);
			outToClient.writeBytes("Booking done!");
		} catch (IOException e) {

		}
	}

	public Booking getBookingById(int bookingId) {
		return manager.getBooking(bookingId);
	}

	public Booking getBookingByNumberPlates(String numberPlates) {
		return manager.getBookingByNumberPlates(numberPlates);
	}
	public void removeBooking(Booking booking) {
		manager.removeBooking(booking);
	}
	public Adaptor getAllBookings() {
		return manager.getAllBookings();
	}
	public int numberOfBookings() {
		return manager.numberOfBookings();
	}

}
