package model;

import java.util.Date;

import adaptor.Adaptor;

public interface IBookingManager {

	public void addBooking(Booking booking);
	public Booking getBooking(int bookingId);
	public void removeBooking(Booking bookingId);
	public int numberOfBookings();
	public Booking getBookingByNumberPlates(String numberPlates);
	public Vehicle getVehicleByNumberPlates(String numberPlates);
	public Customer getCustomerByID(int bookingId);
	public Customer getCustomerOfCar(String vehicleId);
	public Adaptor getAllBookings();
	public Adaptor getListOfBookingsInPeriod(Date start, Date end);
	public Adaptor getBookedVehiclesInPeriod(Date start, Date end);
	public Adaptor getAvailableVehiclesInPeriodByType(String type,Date start, Date end);
	
	
	
}
