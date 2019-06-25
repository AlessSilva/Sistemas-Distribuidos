import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPClientCalc
{

    public static void main(String args[])
    {

        DatagramSocket aSocket = null;

        try
        {

            int serverPort = 6789;
            aSocket = new DatagramSocket();
            DatagramPacket request;
            DatagramPacket reply;

            Scanner scanner = new Scanner(System.in);
            InetAddress aHost = InetAddress.getByName("localhost");

            System.out.println("Digite a expressão (formato: x;op;y)");
            String expr = scanner.next();

            byte [] message = expr.getBytes();

            request = new DatagramPacket(message, expr.length(), aHost, serverPort);

            aSocket.send(request);

            byte[] buffer = new byte[1000];

            reply = new DatagramPacket(buffer, buffer.length);

            aSocket.receive(reply);

            System.out.println("Resposta: " + new String(reply.getData()).substring(0,reply.getLength()));
        }
        catch (SocketException e){System.out.println("Socket: " + e.getMessage());
        }
        catch (IOException e){System.out.println("IO: " + e.getMessage());
        }
        finally {if(aSocket != null) aSocket.close();}
    }
}
