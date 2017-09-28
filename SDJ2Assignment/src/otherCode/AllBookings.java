package otherCode;

import controller.BookingController;
import model.BookingManager;

public class AllBookings {

	private BookingController controller;
	
	public AllBookings(BookingController controller)
	{
		this.controller =controller;	
		System.out.println(controller.getAllBookings());	
		System.out.println("Number of bookings: " + controller.numberOfBookings());
		System.out.println();
	}
}
