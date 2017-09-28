package ServerWithSockets;

import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.UnknownHostException;

public class Client {
	public static void main(String args[]) throws IOException,
			UnknownHostException, ClassNotFoundException {
		final int PORT = 6789;
		final String HOST = "localhost";

		// create client socket, connect to server.
		Socket clientSocket = new Socket(HOST, PORT);
		System.out.println("Client> connected to server");

		ObjectOutputStream outToServer = new ObjectOutputStream(
				clientSocket.getOutputStream());
		ObjectInputStream inFromServer = new ObjectInputStream(
				clientSocket.getInputStream());

		while (true)
		{
			
		System.out.println(inFromServer.readLine());
		outToServer.writeInt(4);
		System.out.println(inFromServer.readLine());
		}
		
		/*
		 * // Read line from keyboard. Scanner keyboard = new
		 * Scanner(System.in);
		 * System.out.print("Write a line for the server: "); String inputLine =
		 * keyboard.nextLine(); keyboard.close();
		 */
		/*
		 * // Send message to server Message message = new Message(inputLine);
		 * System.out.println("Client> " + message);
		 * outToServer.writeObject(message);
		 * 
		 * // Read message from Server. Message replyMessage = (Message)
		 * inFromServer.readObject(); System.out.println("Server> " +
		 * replyMessage);
		 */
		
		
		// Close connection.
		//clientSocket.close();
	}
}
