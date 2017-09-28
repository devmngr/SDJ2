package ServerWithSockets;

import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.net.*;
import java.util.Date;

import model.Booking;
import model.BookingManager;
import model.Customer;
import model.Vehicle;
import util.Cin;

public class Server {
	public static void main(String args[]) throws IOException,
			ClassNotFoundException {
		ServerController manager = new ServerController();

		boolean isConnected = true;
		final int PORT = 6789;
		System.out.println("Starting Server...");

		// create welcoming socket at port 6789
		ServerSocket welcomeSocket = new ServerSocket(PORT);
		while (isConnected) {
			System.out.println("Waiting for a client...");
			Socket connectionSocket = welcomeSocket.accept();
			ObjectOutputStream outToClient = new ObjectOutputStream(
					connectionSocket.getOutputStream());
			ObjectInputStream inFromClient = new ObjectInputStream(
					(connectionSocket.getInputStream()));
			outToClient.writeBytes("Choose: \n1.Make a new booking\n"
					+ "2.Check a booking\n" + "3.Delete booking\n"
					+ "4.All bookings\n" + "0.Exit");
			;
			boolean exit = false;
			int choice = inFromClient.readInt();
			while (!exit) {
				switch (choice) {
				case 0:
					exit = true;
					break;
				case 1:
					

				case 2:
					
				case 3:
					

				case 4:
					outToClient.writeBytes(manager.getAllBookings()
							+ "\nNumber of bookings: "
							+ manager.numberOfBookings());
				}

			}
			/*
			 * System.out.println("Message from Client: " + message);
			 * 
			 * // Send reply to client. // Message replyMessage = new
			 * Message(message.getId(), message.getBody().toUpperCase());
			 * System.out.println("Server reply: " + replyMessage);
			 * outToClient.writeObject(replyMessage);
			 * 
			 * // loop back and wait for another client connection.
			 */
		}
		welcomeSocket.close();

	}

}
