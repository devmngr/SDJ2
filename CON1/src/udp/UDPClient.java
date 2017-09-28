package udp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] recieveData = new byte[1024];

		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacket);

		DatagramPacket recievePacket = new DatagramPacket(recieveData,
				recieveData.length);
		clientSocket.receive(recievePacket);

		String modifiedSentence = new String(recievePacket.getData()).trim();
		System.out.println("From Server: " + modifiedSentence);

		clientSocket.close();

	}
}
