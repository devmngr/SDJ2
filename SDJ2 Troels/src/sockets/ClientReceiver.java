package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientReceiver implements Runnable {

	private ObjectInputStream inFromServer;
	private ChatView view;

	public ClientReceiver(ObjectInputStream inFromServer, ChatView _view) {
		System.out.println("Created client receiver");
		this.inFromServer = inFromServer;
		view = _view;
	}

	public void run(){
		while (true) {
			try{
			Message message = (Message) inFromServer.readObject();
			System.out.println("Reciever: " + message);
			view.updateMessages(message.getBody());
			}
			
			catch(IOException | ClassNotFoundException e)
			{
				
			}
			if (inFromServer == null) {
				System.out.println("inFromServer was null");
				break;
			}

		}
	}
	}


