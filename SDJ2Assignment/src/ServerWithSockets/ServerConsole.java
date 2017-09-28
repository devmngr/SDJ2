package ServerWithSockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



import otherCode.NewBooking;
import view.LoadInitialData;

public class ServerConsole implements IServer {

	private ServerController serverController;
	private ObjectOutputStream outToClient;
	private ObjectInputStream inFromClient;
	private boolean exit;

	public ServerConsole() throws IOException {
	
		serverController = new ServerController();
		boolean isConnected = true;
		final int PORT = 6789;
		ServerSocket welcomeSocket = new ServerSocket(PORT);
		Socket connectionSocket = welcomeSocket.accept();
		outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
		inFromClient = new ObjectInputStream(
				(connectionSocket.getInputStream()));
		System.out.println("Starting Server...");
		System.out.println("Waiting for a client...");

		// new LoadInitialData(serverController);

		while (isConnected) {
			boolean exit = false;
			while (!exit) {
				outToClient.writeBytes("Choose: \n1.Make a new booking\n"
						+ "2.Check a booking\n" + "3.Delete booking\n"
						+ "4.All bookings\n" + "0.Exit");
				int choice = inFromClient.readInt();
				System.out.println(choice);
				switch (choice) {
				case 0:
					exit = true;
					break;
				case 1:
					 newBooking(serverController);
					break;
				case 2:
					  checkBooking(serverController);
					break;
				case 3:
					deleteBooking(serverController);
					break;
				case 4:
					  getAllBookings(serverController);
					break;
				}
			}
		}
		welcomeSocket.close();
	}

	@Override
	public void newBooking(ServerController controller) {
		this.serverController = controller;
		try{
		while (!exit) {

			controller.readDates();			
			int choice = inFromClient.readInt();
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
		catch (IOException e) {

		}
	}

	@Override
	public void checkBooking(ServerController controller) {
		this.serverController = controller;
		try {
			outToClient.writeBytes("Choose: \n1.Search with customer ID\n"
					+ "2. Search with number plates\n" + "0.Back");
			int subChoice2 = inFromClient.readInt();
			switch (subChoice2) {
			case 0:
				exit = true;
				break;
			case 1:

				int bookingId = inFromClient.readInt();
				outToClient.writeBytes("\n"
						+ serverController.getBookingById(bookingId));

			case 2:
				String numberPlates = inFromClient.readLine();
				outToClient.writeBytes("\n"
						+ serverController
								.getBookingByNumberPlates(numberPlates));

			}
		} catch (IOException e) {

		}
	}

	@Override
	public void deleteBooking(ServerController controller) {
		try {
			this.serverController = controller;
			outToClient.writeBytes("Delete Booking\n" + "0.Back\n"
					+ "Enter booking id to delete: ");
			int bookingid = inFromClient.readInt();
			serverController.removeBooking(serverController
					.getBookingById(bookingid));
			outToClient.writeBytes("Booking Deleted!");
		} catch (IOException e) {

		}

	}

	@Override
	public void getAllBookings(ServerController controller) {
		this.serverController = controller;
		try {
			outToClient.writeBytes(serverController.getAllBookings()
					+ "\nNumber of bookings: "
					+ serverController.numberOfBookings());
		} catch (IOException e) {

		}
	}

}
