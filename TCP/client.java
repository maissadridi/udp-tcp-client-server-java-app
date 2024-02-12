package TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {
        String serverAddress = "localhost";
        int serverPort = 6790;

        Socket clientSocket = new Socket(serverAddress, serverPort);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.print("Enter the first number: ");
        int num1 = Integer.parseInt(inFromUser.readLine());
        System.out.print("Enter the second number: ");
        int num2 = Integer.parseInt(inFromUser.readLine());

        outToServer.writeBytes(num1 + " " + num2 + '\n');

        String serverResponse = inFromServer.readLine();
        System.out.println("Server response: " + serverResponse);

        clientSocket.close();
    }
}
