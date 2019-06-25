import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClientChatBloq {

    public static void main(String args[]) {

        Socket socket = null;
        int serverPort = 7896;
        Scanner scan = new Scanner(System.in);

        try {

            socket = new Socket("localhost", serverPort, InetAddress.getLocalHost(), 9321);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.print("Envie: ");
                String msg = scan.nextLine();
                out.writeUTF(msg);
                System.out.println(in.readUTF());
            }

        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
            }
        }
    }

}
