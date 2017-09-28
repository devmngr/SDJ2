package view;

import controller.BookingController;

public interface IConsole {
	public void newBooking(BookingController controller);
	public void checkBooking(BookingController controller);
	public void deleteBooking(BookingController controller);
	public void getAllBookings(BookingController controller);
}
