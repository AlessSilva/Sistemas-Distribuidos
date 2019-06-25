package ServidorComTodosServicos;

import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main (String args[])
    {
        try
        {
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
    Despachante despachante;

    public Connection(Socket aClientSocket) {
        try {
            this.clientSocket = aClientSocket;
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.despachante = new Despachante();
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        try {
            String request;
            while (true){
                request = getRequest();
                sendResponse( despachante.invoque(request) );
            }

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

    public void sendResponse( Object response ) throws IOException {
        if( response instanceof String ){
            out.writeUTF( (String)response );
        }else{
            Bytes bytes = (Bytes)response;
            out.write(bytes.b);
        }
    }

}