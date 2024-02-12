package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = serverSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            String clientSentence = inFromClient.readLine();
            System.out.println("Received: " + clientSentence);
        }
    }
}
