package tt.fares.sockets.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class StartCommunication {

	public static void main(String[] args) {

		int portNumber = 1500;

		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while (true) {
				Socket clientSocket;
				clientSocket = serverSocket.accept();

				PrintWriter out = new PrintWriter(
						clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				System.out.println("server-side: client connected");
				
				
				//Protocol Start:
				MyProtocol myProtocol = new MyProtocol();
				
				
				out.println(myProtocol.firstContact());

				String userInput;
				while ((userInput = in.readLine()) != null) {
					System.out.println("Client: " + userInput);
					out.println(myProtocol.processMessage(userInput));
					if(myProtocol.processMessage(userInput).startsWith("What a pity")){
						break;
					}
				}
				clientSocket.close();
				serverSocket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
