package Q1.MP3;

import java.io.IOException;
import java.io.*;

public class User {

    private static File toFile(byte[] stream) {
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

    public static void main (String args[]) throws IOException {

        System.out.println("User MP3 Q1");

        MP3Player mp3Player = new MP3Player();

        TCPClient client = new TCPClient();

        String musica = "/home/alessandro/Downloads/musica.mp3";

        client.sendRequest(musica);

        File mp3File = toFile( client.getResponse() );

        mp3Player.tocar(mp3File);

        client.close();

    }

}
