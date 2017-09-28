package otherCode;

import controller.BookingController;
import util.Cin;

public class NewBooking {
	private BookingController controller;
	
	

	public NewBooking(BookingController controller) {
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



}
