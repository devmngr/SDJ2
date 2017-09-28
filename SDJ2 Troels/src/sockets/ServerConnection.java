package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class ServerConnection implements Runnable {
	private Socket clientSocket;
	private ObjectOutputStream outToClient;
	private ObjectInputStream inFromClient;
	private MessageBroadcast mb;

	public ServerConnection(Socket connectionSocket, MessageBroadcast mb)
			throws IOException {
		clientSocket = connectionSocket;

		// create output stream attached to the socket
		outToClient = new ObjectOutputStream(clientSocket.getOutputStream());

		// create input stream attached to the socket
		inFromClient = new ObjectInputStream((clientSocket.getInputStream()));
		this.mb = mb;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// read message from client.
				Message message = (Message) inFromClient.readObject();
				System.out.println("Message from Client: " + message);

				// Send reply to client.
				Message replyMessage = new Message(message.getId(), message
						.getBody().toUpperCase());
				System.out.println("Server reply: " + replyMessage);

				for (int i = 0; i < mb.getSize(); i++) {

					mb.getAtIndex(i).outToClient.writeObject(replyMessage);
				}
			} catch (IOException e) {

			} catch (ClassNotFoundException e) {

			}

			// loop back and wait for another client connection.
		}
	}
}
