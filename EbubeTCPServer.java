/**
 * @author (Ebube Abara) 
 */
import java.io.*;
import java.net.*;
public class EbubeTCPServer
{
    public static void main(String argv[]) throws Exception 
    {
		String clientInput;		// Stores sentence sent by client.
		String inputToUpperCase;	// Uppercase sentence.
		
		// Creates a server socket, which waits for clients 
		// to initiate connection.
		ServerSocket welcomeConnectionServerSocket = new ServerSocket(20002);
		
		while (!false) 
		{
			System.out.println("Waiting for clients to connect to Ebube's TCP server....");
			
			// Creates a new socket when a client contacts server for the first time
			Socket connectionSocket = welcomeConnectionServerSocket.accept();
			
			System.out.println("Client Connected to Ebube's TCP server.");
			
			//read and send connection through the TCP input/output stream
			BufferedReader fromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream toClient = new DataOutputStream(
					connectionSocket.getOutputStream());
			
	
			clientInput = fromClient.readLine();
			System.out.println("Client sent: " + clientInput);
			
			//updating client input to upper case
			inputToUpperCase = clientInput.toUpperCase() + '\n';
			
			//sending updated input back to client
			toClient.writeBytes(inputToUpperCase);
		}
	}
}
