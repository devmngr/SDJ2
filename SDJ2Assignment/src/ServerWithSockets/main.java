package ServerWithSockets;

import java.io.IOException;

public class main {

	public static void main(String[] args) {
		try {
			ServerConsole cons = new ServerConsole();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
