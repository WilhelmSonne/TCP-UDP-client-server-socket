
// P2aClient.java
import java.io.*;
import java.net.Socket;

public class P2aClient {
	private Socket socket;
	private BufferedReader inFromServer;
	private BufferedReader inFromUser;
	String answer;
	private PrintWriter out;

	public void connectToServer() throws IOException {
		String serverAddress = "140.112.18.178";
		// serverAddress = "140.112.18.178";
		Socket socket = new Socket(serverAddress, 9090);
		this.socket = socket;
		inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("Connect to server at " + serverAddress + "..");
	}

	public void start() throws Exception {
		System.out.println(inFromServer.readLine());
		while (true) {
			System.out.println(inFromServer.readLine());
			inFromUser = new BufferedReader(new InputStreamReader(System.in));
			answer = inFromUser.readLine();
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println(answer);
		}
	}

	/**
	 * Runs the client application.
	 */
	public static void main(String[] args) throws Exception {
		P2aClient client = new P2aClient();
		client.connectToServer();
		client.start();
		client.socket.close();
	}
}
