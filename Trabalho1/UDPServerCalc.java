import java.net.*;
import java.io.*;

public class UDPServerCalc
{

    public static void main(String args[])
    {

        DatagramSocket sSocket = null;

        try
        {
            int port = 6789;
            sSocket = new DatagramSocket(port);

            byte[] bufferServer = new byte[1000];

            DatagramPacket request;
            DatagramPacket reply;

            while(true)
            {

                request = new DatagramPacket(bufferServer, bufferServer.length);
                sSocket.receive(request);
                String message = new String( request.getData() );
                String datas[] = message.split(";");
                String calc = calculadora( datas[0], datas[1], datas[2] );
                reply = new DatagramPacket( calc.getBytes() , calc.getBytes().length, request.getAddress(), request.getPort() );
                sSocket.send(reply);

            }
        }catch (SocketException e){System.out.println("Socket: " + e.getMessage());
        }catch (IOException e) {System.out.println("IO: " + e.getMessage());
        }finally {if(sSocket != null) sSocket.close();}
    }

    public static String calculadora( String x, String op, String y ){

        double x1 = Double.parseDouble(x);
        double y1 = Double.parseDouble(y);

        String result = "";

        if( op.equals("+") )
        {
            result = String.valueOf(x1 + y1);
        }
        else if( op.equals("-") )
        {
            result = String.valueOf(x1 - y1);
        }
        else if ( op.equals("*") )
        {
            result = String.valueOf(x1 * y1);
        }
        else if ( op.equals("/") )
        {
            if( y1 == 0 )
            {
                result = "Erro de divisão por zero";
            }
            else
            {
                result = String.valueOf(x1/y1);
            }
        }
        else
        {
            result = "Operação Inválida";
        }

        return result;
    }
}
