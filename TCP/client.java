package TCP;

import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {
        String sentence = "Hello, server!";
        Socket clientSocket = new Socket("localhost", 6789);

        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
        outToServer.println(sentence);

        clientSocket.close();
    }

}
