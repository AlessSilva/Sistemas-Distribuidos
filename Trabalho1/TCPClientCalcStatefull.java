import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClientCalcStatefull {

    public static void main (String args[])
    {

        Socket s = null;

        try
        {
            int serverPort = 9776;
            int localport = 9899;
            s = new Socket("localhost" ,serverPort, InetAddress.getByName("localhost"), localport);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out =new DataOutputStream( s.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            String expressao;

            while ( true )
            {
                System.out.println("Digite a expressão (formato: x;op;y ou op;x)");
                expressao = scanner.next();

                out.writeUTF(expressao);

                String data = in.readUTF();
                System.out.println("Resultado: "+ data) ;

            }

        }
        catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }
        catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }
        catch (IOException e){System.out.println("readline:"+e.getMessage());
        }
        finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
    }
}
