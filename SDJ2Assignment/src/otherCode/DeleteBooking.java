package otherCode;

import controller.BookingController;
import util.Cin;
import model.BookingManager;

public class DeleteBooking {
	private BookingController controller;

	public DeleteBooking(BookingController controller)
	{
		this.controller = controller;
		boolean back = false;
		while(!back)
		{
		System.out.println("Delete Booking");
		System.out.println("Enter booking id to delete");
		System.out.println("0.Back");		
		
		int bookingId = Cin.readInt();
	if(bookingId!=0)
	{
		controller.removeBooking(controller.getBooking(bookingId));
		System.out.println("Booking removed!");
		break;
	}
	else back =true;		
		
		}
	}

}
