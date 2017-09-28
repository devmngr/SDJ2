package model;

import java.util.Date;
import java.util.Iterator;

import storage.IIterator;
import adaptor.Adaptor;

public class BookingManager implements IBookingManager {

	private Adaptor<Booking> adaptor;

	public BookingManager() {
		adaptor = new Adaptor<Booking>();
	}

	@Override
	public void addBooking(Booking booking) {

		adaptor.add(booking);

	}

	@Override
	public void removeBooking(Booking bookingId) {
		adaptor.remove(bookingId);
	}

	@Override
	public Booking getBooking(int bookingId) {
		IIterator<Booking> it = adaptor.getIterator();
		Booking temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getBookingId() == bookingId) {
				return temp;
			}
		}
		return null;
	}
	@Override
	public Booking getBookingByNumberPlates(String numberPlates)
	{
		IIterator<Booking> it = adaptor.getIterator();
		Booking temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getVehicle().getNumberPlates().toUpperCase()
					.equals(numberPlates.toUpperCase())) {
				return temp;
			}
		}
		return null;
	}
	@Override
	public Adaptor getAllBookings()
	{
		Adaptor<Booking> temp=new Adaptor<Booking>();
		IIterator<Booking> it = adaptor.getIterator();
		while(it.hasNext())
			temp.add(it.next());
		
		return temp;
	}
	@Override
	public Vehicle getVehicleByNumberPlates(String numberPlates)
	{
		IIterator<Booking> it = adaptor.getIterator();
		Booking temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getVehicle().getNumberPlates().toUpperCase()
					.equals(numberPlates.toUpperCase())) {
				return temp.getVehicle();
			}
		}
		return null;
	}

	@Override
	public Customer getCustomerByID(int bookingId) {
		return getBooking(bookingId).getCustomer();
	}

	@Override
	public Customer getCustomerOfCar(String vehicleId) {
		IIterator<Booking> it = adaptor.getIterator();
		Booking temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getVehicle().getNumberPlates().toUpperCase()
					.equals(vehicleId.toUpperCase())) {
				return temp.getCustomer();
			}
		}
		return null;
	}

	@Override
	public Adaptor getListOfBookingsInPeriod(Date start, Date end) {

		Adaptor<Booking> ad = new Adaptor<Booking>();
		IIterator<Booking> it = adaptor.getIterator();
		Booking temp;

		while (it.hasNext()) {
			temp = it.next();
			if (start.compareTo(temp.getStartDate()) <= 0
					&& end.compareTo(temp.getStartDate()) >= 0
					|| start.compareTo(temp.getStartDate()) >= 0
					&& start.compareTo(temp.getEndDate()) <= 0) {
				ad.add(temp);

			}
		}
		return ad;

	}
	@Override
	public Adaptor getBookedVehiclesInPeriod(Date start, Date end) {
		Adaptor<Vehicle> ad = new Adaptor<Vehicle>();
		IIterator<Booking> it = adaptor.getIterator();
		Booking temp;

		while (it.hasNext()) {
			temp = it.next();
			if (start.compareTo(temp.getStartDate()) <= 0
					&& end.compareTo(temp.getStartDate()) >= 0
					|| start.compareTo(temp.getStartDate()) >= 0
					&& start.compareTo(temp.getEndDate()) <= 0) {
				ad.add(temp.getVehicle());

			}
		}
		return ad;
	}

	@Override
	public Adaptor getAvailableVehiclesInPeriodByType(String type,Date start, Date end) {
		Adaptor<Vehicle> ad = new Adaptor<Vehicle>();
		IIterator<Booking> it = adaptor.getIterator();
		Booking temp;

		while (it.hasNext()) {
			temp = it.next();
			if (temp.getVehicle().getType().equals(type))
			{
			if (start.compareTo(temp.getStartDate()) < 0
					&& end.compareTo(temp.getStartDate()) < 0
					|| start.compareTo(temp.getEndDate()) > 0
					&& start.compareTo(temp.getEndDate()) > 0) {
				ad.add(temp.getVehicle());

			}
			}
		}
		return ad;
	}
	@Override
	public int numberOfBookings()
	{
		return adaptor.size();
	}

	public String toString() {
		String str = "";
		for (IIterator<Booking> it = adaptor.getIterator(); it.hasNext(); it
				.next()) {
			str += it.toString();
		}
		return str;
	}

}
