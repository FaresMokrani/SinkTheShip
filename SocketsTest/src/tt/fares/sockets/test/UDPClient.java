package tt.fares.sockets.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		int portNumber = 4444;
		
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress address = InetAddress.getLocalHost();
			
			byte[] buffer = new byte[256];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, portNumber);
			socket.send(packet);
			System.out.println("Packet Sent");
			
			packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			System.out.println("Packet Received");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
