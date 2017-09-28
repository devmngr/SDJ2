package rmi;

import java.rmi.RemoteException;

public class HACK {

	public void hack() throws RemoteException{
		RmiClient client= new RmiClient();
		System.out.println("Run hack");
		String id="";
		int i=0;
		while(true){
		try {
			id=i+"";
			client.addPart(id, "554", "554", "554", "554", "554", "554", "554","al", "al");
			i++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End hack");
		}
	}
	
	public static void main(String args[]){
		HACK hack= new HACK();
		try {
			hack.hack();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
