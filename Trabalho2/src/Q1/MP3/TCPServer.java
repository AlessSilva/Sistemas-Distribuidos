package Q1.MP3;

import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main (String args[])
    {
        try
        {
            System.out.println("Servidor MP3 Q1");
            int serverPort = 6768; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while(true)
            {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        }
        catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }

}

class Connection extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    MP3 mp3;

    public Connection(Socket aClientSocket) {
        try {
            this.clientSocket = aClientSocket;
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.mp3 = new MP3();
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        try {
            String request;
            request = getRequest();
            sendResponse( serialize( mp3.musicaMP3(request) ) );

        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {/*close failed*/}
        }
    }

    public String getRequest() throws IOException {
        String s = in.readUTF();
        return s;
    }

    public void sendResponse(byte[] response) throws IOException {
        out.write(response);
    }

    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }
}