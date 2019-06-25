package Q2.MP3;

import java.net.*;
import java.io.*;

public class TCPClient {

    Socket s;
    DataInputStream in;
    DataOutputStream out;

    public TCPClient() throws IOException {
        this.s = new Socket("localhost" ,6768);
        this.in = new DataInputStream( s.getInputStream());
        this.out =new DataOutputStream( s.getOutputStream());
    }

    public void sendRequest( String request ) throws IOException {
        this.out.writeUTF(request);
    }

    public byte[] getResponse() throws IOException{
        return toByteArray(this.in);
    }

    public void close() throws IOException{
        this.s.close();
    }

    private byte[] toByteArray(InputStream is) throws IOException {
        byte[] buffer = new byte[1024];
        is.read(buffer);
        return buffer;
    }
}
