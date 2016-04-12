package practice;

import java.io.*;
import java.net.*;

public class UDP_Server {
	int port;

	public static void main(String[] args) throws Exception {
		byte buffer[] = new byte[1024];
		for (int count = 0;; count++) {
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			DatagramSocket socket = new DatagramSocket(7790);
			socket.receive(packet);
			String receive = new String(buffer, 0, packet.getLength());
			System.out.println(count + ":receive:" + receive);
			socket.close();
		}

	}

}
