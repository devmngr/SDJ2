package sockets;

import java.util.*;


public class MessageBroadcast {

	private List<ServerConnection> conns;
	private int size;
	
	public MessageBroadcast()
	{
		conns = new ArrayList<>();
		size =0;
	}
	
	public void addConnection(ServerConnection conn)
	{
		conns.add(conn);
		size++;
	}

	public List<ServerConnection> getConns() {
		return conns;
	}
	public ServerConnection getAtIndex(int i )
	{
		return conns.get(i);
	}
	

	public int getSize() {
	return size;
}
	
	
	
	
}
