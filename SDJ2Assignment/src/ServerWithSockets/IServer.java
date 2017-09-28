package ServerWithSockets;

import controller.BookingController;

public interface IServer {

	public void newBooking(ServerController controller);
	public void checkBooking(ServerController controller);
	public void deleteBooking(ServerController controller);
	public void getAllBookings(ServerController controller);
	
}
