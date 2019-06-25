package Q2.MP3;

import java.io.*;

public class Proxy {

    private TCPClient client;

    Proxy() throws IOException{
        client = new TCPClient();
    }

    public File musicaMP3( String musica ) throws IOException{
        client.sendRequest( musica );
        return toFile( client.getResponse() );
    }

    public void close() throws IOException{
        client.close();
    }

    private File toFile(byte[] stream) {
        File file = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(stream);
            ObjectInputStream ois = new ObjectInputStream(bais);
            file = (File) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

}
