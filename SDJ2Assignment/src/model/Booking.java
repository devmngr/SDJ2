package model;

import java.util.Date;

public class Booking {

	private Customer customer;
	private int bookingId;
	private double totalPrice;
	private Date startDate;
	private Date endDate;
	private String pickUpLocation;
	private String dropLocation;
	private Vehicle vehicle;

	public Booking(Customer customer, double totalPrice, Date startDate, Date endDate,String pickUpLocation, String dropLocation, Vehicle vehicle){
		
		this.customer = customer;
		this.bookingId = customer.getSsn();
		this.totalPrice = totalPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pickUpLocation = pickUpLocation;
		this.dropLocation = dropLocation;
		this.vehicle = vehicle;	
	}
	
	public int getBookingId(){
		return bookingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Vehicle getVehicle()
	{
		return vehicle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	
	public String toString(){
		
		return "\n\tBooking\n" + customer + "\nBooking ID: " + bookingId +
				"\nTotal price: " + totalPrice + "\nStart date: " + startDate + "\nEnd date: " + endDate +
				"\nPick up location: " + pickUpLocation + "\nDrop location: " + dropLocation  + vehicle + "\n";
		
	}
	
}
