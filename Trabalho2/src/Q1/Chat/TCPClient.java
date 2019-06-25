package Q1.Chat;

import java.net.*;
import java.io.*;

public class TCPClient {
    Socket s;
    DataInputStream in;
    DataOutputStream out;

    public TCPClient() throws IOException {
        s = new Socket("localhost" ,6768);
        in = new DataInputStream( s.getInputStream());
        out =new DataOutputStream( s.getOutputStream());
    }

    public void sendRequest( String request ) throws IOException {
        out.writeUTF(request);
    }

    public String getResponse() throws IOException{
        String r = in.readUTF();
        return r;
    }

    public void close() throws IOException{
        s.close();
    }
}
