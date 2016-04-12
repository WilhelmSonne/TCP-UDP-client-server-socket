package practice;

import java.net.*;
import java.io.*;

public class UDP_client {
	static String sentence;

	public static void main(String[] args) throws Exception {
		InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
		for (int i = 0; i < 1000; i++) {
			sentence = +i + "th packet";
			byte buffer[] = sentence.getBytes();

			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, IPAddress, 7790);
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
			socket.close();
		}

	}

}
