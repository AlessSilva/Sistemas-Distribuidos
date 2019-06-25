import java.net.*;
import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TCPServerCalcStatefull
{

    public static void main (String args[])
    {
        try
        {
            int serverPort = 9776;
            ServerSocket sSocket = new ServerSocket(serverPort);
            while(true)
            {
                Socket clientSocket = sSocket.accept();
                Connection1 c = new Connection1(clientSocket);
            }
        }
        catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }

}

class Connection1 extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    static Map<String,Double> lastResult = new ConcurrentHashMap<>();


    public Connection1 (Socket aClientSocket)
    {
        try
        {
            this.clientSocket = aClientSocket;
            this.in = new DataInputStream( clientSocket.getInputStream());
            this.out =new DataOutputStream( clientSocket.getOutputStream());

            this.start();
        }
        catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
    }

    public void run()
    {
        try
        {
            while (true)
            {
                String[] expr = in.readUTF().split(";");
                char first = expr[0].charAt(0);
                String result;
                if( Character.isDigit(first) )
                {
                    result = calcular(expr[0], expr[1], expr[2]);

                }else
                {
                    result = calcular(expr[0] ,expr[1]);
                }
                out.writeUTF(result);
            }
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        } catch(IOException e) {System.out.println("readline:"+e.getMessage());
        } finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
    }

    public String calcular( String x, String op, String y )
    {
        double x1 = Double.parseDouble(x);
        double y1 = Double.parseDouble(y);
        String result  = "";
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
            if( y1 == 0)
            {
                return  "Erro por divisão por zero";
            }
            else
            {
                result = String.valueOf(x1/y1);
            }
        }
        lastResult.put(clientSocket.toString(), Double.parseDouble(result) );
        return result;
    }

    public String calcular( String op, String y ){

        if( !lastResult.containsKey(clientSocket.toString()) )
        {
            return "Erro. Não existe valor salvo";
        }
        double x1 = lastResult.get(clientSocket.toString());
        double y1 = Double.parseDouble(y);
        String result  = "";
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
            if( y1 == 0)
            {
                return  "Erro por divisão por zero";
            }
            else
            {
                result = String.valueOf(x1/y1);
            }
        }
        lastResult.put(clientSocket.toString(), Double.parseDouble(result) );
        return result;
    }

}
