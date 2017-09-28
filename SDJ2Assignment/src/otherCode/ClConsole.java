package otherCode;

import java.util.Date;

import controller.BookingController;
import util.Cin;
import view.LoadInitialData;
import model.Booking;
import model.BookingManager;
import model.Customer;
import model.FamilyCar;
import model.Vehicle;

public class ClConsole {
	public static void main(String[] args) {

	
		BookingController controller = new BookingController();
		new LoadInitialData(controller);

		boolean exit = false;
		while (!exit) {
			System.out.println("Choose: \n1.Make a new booking\n"
					+ "2.Check a booking\n" + "3.Delete booking\n"
					+ "4.All bookings\n" + "0.Exit");
			String string = "";
			int choice = Cin.readInt();
			switch (choice) {
			case 0:
				exit = true;
				break;
			case 1:
				new NewBooking(controller);
				break;
			case 2:
				new CheckBooking(controller);
				break;
			case 3:
				new DeleteBooking(controller);
				break;
			case 4:
				new AllBookings(controller);
				break;

		
			}

		}
	}

}
