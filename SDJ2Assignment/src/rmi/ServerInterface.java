package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.Booking;

public interface ServerInterface<T> extends Remote
{
    String toUpperCase(String msg, Object client) 
                                      throws RemoteException;
    public void add(String element,Object client) throws RemoteException;
	public void remove(String element,Object client) throws RemoteException;
	public boolean contains(int bookingID,Object client) throws RemoteException;
	//public boolean contains(T element) throws RemoteException;
	//following 2 methods should be implemented for every tipe of data
	public int sizeStringList() throws RemoteException;
	public ArrayList<String> getAllStrings()throws RemoteException;
}

