package otherCode;

import controller.BookingController;
import util.Cin;
import model.BookingManager;

public class CheckBooking {

	private BookingController controller;

	public CheckBooking(BookingController controller) {
		this.controller = controller;
		boolean exit = false;
		while (!exit) {
			System.out.println("Choose: \n1.Search with customer ID\n"
					+ "2. Search with number plates\n" + "0.Back");
			String string = "";
			int choice = Cin.readInt();
			switch (choice) {
			case 0:
				exit=true;
				break;
			case 1:

				System.out.println("Enter customer ID :");
				int ID = Cin.readInt();
				System.out.println("Requested booking: ");
				System.out.println(controller.getBooking(ID));
				break;

			case 2:
				System.out.println("Enter vehicle number plates");
				String plates = Cin.readString();
				System.out.println("Requested booking: ");
				System.out.println(controller.getBookingByNumberPlates(plates));
				break;

			}
		}

	}
}
