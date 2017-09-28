package rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

import model.Booking;
import controller.BookingController;
import storage.IIterator;
import adaptor.*;

public class RmiServer extends UnicastRemoteObject implements ServerInterface {

	private IAdaptor adaptor = new Adaptor();

	public RmiServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) {

		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			ServerInterface rmiServer = new RmiServer();
			Naming.rebind("toUpperCase", rmiServer);
			Naming.rebind("add", rmiServer);
			Naming.rebind("remove", rmiServer);
			Naming.rebind("getAllStrings", rmiServer);
			System.out.println("Starting server...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toUpperCase(String msg, Object client) throws RemoteException {
		System.out.println("toUpperCase: client = " + client);
		return msg.toUpperCase();
	}

	@Override
	public void add(String element, Object client) throws RemoteException {
		adaptor.add(element);
	}

	@Override
	public void remove(String element, Object client) throws RemoteException {
		adaptor.remove(element);
	}

	@Override
	public boolean contains(int bookingid,Object client) throws RemoteException {
		return adaptor.contains(bookingid);
	}

	@Override
	public int sizeStringList() throws RemoteException {
		return 0;
	}

	@Override
	public ArrayList<String> getAllStrings() throws RemoteException {
		ArrayList<String> stringList = new ArrayList<String>();
		for (IIterator it = adaptor.getIterator(); it.hasNext(); it.next())
			stringList.add(it.toString());
		System.out.println("Size: " + stringList.size());
		return stringList;
	}

}