package tt.fares.sockets.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int portNumber = 4444;
		String hostName = "localhost";

		try {
			Socket clientSocket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));

			String userInput, serverEcho, fromServer;

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);

				if ((userInput = stdIn.readLine()) != null) {
					out.println(userInput);
					System.out.println("Client:" + userInput);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
