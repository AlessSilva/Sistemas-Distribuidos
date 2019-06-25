package Q2.MP3;

import java.io.*;

public class Esqueleto {

    private MP3 mp3;

    Esqueleto(){
        mp3 = new MP3();
    }

    public byte[] musicaMP3( String musica ) throws IOException {
        return serialize( mp3.musicaMP3(musica) );
    }

    private byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

}
