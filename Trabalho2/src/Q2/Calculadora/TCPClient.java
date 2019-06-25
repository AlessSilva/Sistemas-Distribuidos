package Q2.Calculadora;
import java.net.*;
import java.io.*;

public class TCPClient {

    Socket s;
    DataInputStream in;
    DataOutputStream out;

    public TCPClient() throws IOException {
        this.s = new Socket("localhost" ,6767);
        this.in = new DataInputStream( s.getInputStream());
        this.out =new DataOutputStream( s.getOutputStream());
    }

    public void sendRequest( String request ) throws IOException { this.out.writeUTF(request); }

    public String getResponse() throws IOException{
        String r = this.in.readUTF();
        return r;
    }
}
