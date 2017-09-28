package view;

import otherCode.AllBookings;
import otherCode.CheckBooking;
import otherCode.DeleteBooking;
import otherCode.NewBooking;
import util.Cin;
import controller.BookingController;

public class ClientConsole implements IConsole {
	private BookingController controller;

	public ClientConsole() {
		controller = new BookingController();
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

	@Override
	public void newBooking(BookingController controller) {

		this.controller = controller;

		boolean exit = false;
		while (!exit) {
			controller.enterDates();
			int choice = Cin.readInt();
			switch (choice) {

			case 1:
				controller.book("Family Car");
				exit = true;
				break;

			case 2:
				controller.book("Van");
				exit = true;
				break;

			case 3:
				controller.book("Moving Truck");
				exit = true;
				break;

			case 0:
				exit = true;
				break;
			}
		}
	}

	@Override
	public void checkBooking(BookingController controller) {
		this.controller = controller;
		boolean exit = false;
		while (!exit) {
			System.out.println("Choose: \n1.Search with customer ID\n"
					+ "2. Search with number plates\n" + "0.Back");
			String string = "";
			int choice = Cin.readInt();
			switch (choice) {
			case 0:
				exit = true;
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

	@Override
	public void deleteBooking(BookingController controller) {
		this.controller = controller;
		boolean back = false;
		while (!back) {
			System.out.println("Delete Booking\n" + "0.Back\n"
					+ "Enter booking id to delete: ");

			int bookingId = Cin.readInt();
			if (bookingId != 0) {
				controller.removeBooking(controller.getBooking(bookingId));
				System.out.println("Booking removed!");
				break;
			} else
				back = true;

		}
	}

	@Override
	public void getAllBookings(BookingController controller) {
		this.controller = controller;
		System.out.println(controller.getAllBookings());
		System.out.println("Number of bookings: "
				+ controller.numberOfBookings());
		System.out.println();
	}

}
