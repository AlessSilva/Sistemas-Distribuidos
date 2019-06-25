package Q1.MP3;

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

    public byte[] getResponse() throws IOException{
        return toByteArray(in);
    }

    public void close() throws IOException{
        s.close();
    }

    private static byte[] toByteArray(InputStream is) throws IOException {
        byte[] buffer = new byte[1024];
        is.read(buffer);
        return buffer;
    }
}