package atmNetwork;

import java.io.*;
import java.net.*;

public class Bank {

	public static void main(String[] args) throws Exception {

		String registerRequest = "REG_ME\n";
		String response = "NAME?";
		String bankName = "NAME: dott[.]";

		Socket clientSocket = new Socket("10.52.236.67", 53000);

		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		outToServer.writeBytes(registerRequest);
		String a = inFromServer.readLine();
		if (a.equalsIgnoreCase(response))
		{
			outToServer.writeBytes(bankName);
			
		}
		System.out.println(inFromServer.readLine());

		clientSocket.close();

		/*
		 * 
		 * 
		 * 
		 * 
		 * ServerSocket serverSocket = new ServerSocket(53001); while (true) {
		 * Socket directoryConnection = serverSocket.accept(); BufferedReader
		 * inFromClient = new BufferedReader(new
		 * InputStreamReader(connectionSocket.getInputStream()));
		 * DataOutputStream outToClient = new
		 * DataOutputStream(connectionSocket.getOutputStream()); clientSentence
		 * = inFromClient.readLine(); capitalizedSentence =
		 * clientSentence.toUpperCase() + "\n";
		 * outToClient.writeBytes(capitalizedSentence); }
		 */

	}

}
