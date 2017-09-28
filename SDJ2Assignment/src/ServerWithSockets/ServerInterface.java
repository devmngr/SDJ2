package ServerWithSockets;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.Booking;

public interface ServerInterface<T> extends Remote
{
    String toUpperCase(String msg, Object client) 
                                      throws RemoteException;
    public void add(Booking element,Object client) throws RemoteException;
	public T remove(int element,Object client) throws RemoteException;
	//public boolean contains(T element) throws RemoteException;
	//following 2 methods should be implemented for every tipe of data
	public int sizeStringList() throws RemoteException;
	public ArrayList<String> getAllStrings()throws RemoteException;
}

