package tt.fares.sockets.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	Socket clientSocket;
	
	public ServerThread(Socket clientSocket){
		this.clientSocket = clientSocket;
	}
	
	public void run(){
		try {
			PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			System.out.println("the client address"+ this.clientSocket.getInetAddress() + " thread number:" + this.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
