import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServerChatBloq {

    public static void main(String args[]) {
        try {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection2 c = new Connection2(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }
}

class Connection2 extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;

    public Connection2(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        try {
            Scanner s = new Scanner(System.in);
            while (true) {
                String data = in.readUTF();
                System.out.println("recebeu:" + data);
                System.out.print("envie: ");
                data = s.nextLine();
                out.writeUTF(data);
            }
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {/*close failed*/
            }
        }

    }
}
