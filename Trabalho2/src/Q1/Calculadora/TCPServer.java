package Q1.Calculadora;

import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main (String args[])
    {
        try
        {
            int serverPort = 6767; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Servidor Calc Q1");
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
    Calc calc;

    public Connection(Socket aClientSocket) {
        try {
            this.clientSocket = aClientSocket;
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            calc = new Calc();
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
                String args[] = request.split(";");
                String resultado;
                if( args[0].equals("+") ){

                    resultado = String.valueOf( calc.add( Double.parseDouble(args[1]),Double.parseDouble(args[2]) ) );

                }else if( args[0].equals("-") ){

                    resultado = String.valueOf( calc.sub( Double.parseDouble(args[1]),Double.parseDouble(args[2]) ) );

                }else if( args[0].equals("*") ){

                    resultado = String.valueOf( calc.mult( Double.parseDouble(args[1]),Double.parseDouble(args[2]) ) );

                }else if( args[0].equals("/") ){

                    resultado = String.valueOf( calc.div( Double.parseDouble(args[1]),Double.parseDouble(args[2]) ) );

                }else{

                    resultado = "ERRO";

                }
                sendResponse( resultado );
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

    public void sendResponse( String response ) throws IOException {
        out.writeUTF(response);
    }

}