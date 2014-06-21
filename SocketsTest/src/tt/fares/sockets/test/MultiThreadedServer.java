package tt.fares.sockets.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int portNumber = 4444;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(portNumber);
			while(true){
				Socket clientSocket = serverSocket.accept();
				new ServerThread(clientSocket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
