package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class http {
	public static void main(String[] args) throws Exception {
		String host = null;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Enter hostname of Server: ");
		host = inFromUser.readLine();
		Socket httpClientSocket = new Socket(host, 80);
		DataOutputStream httpRequest = new DataOutputStream(
				httpClientSocket.getOutputStream());
		BufferedReader httpResponse = new BufferedReader(new InputStreamReader(
				httpClientSocket.getInputStream()));

		httpRequest.writeBytes("GET / HTTP/1.0\r\nHost: " + host + "\r\n\r\n");

		System.out.println(httpResponse.readLine());
		while (httpResponse.ready()) {
			System.out.println(httpResponse.readLine());
		}
		httpClientSocket.close();
	}

}
