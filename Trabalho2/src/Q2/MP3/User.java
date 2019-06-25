package Q2.MP3;

import java.io.IOException;
import java.io.*;

public class User {

    public static void main (String args[]) throws IOException {

        MP3Player mp3Player = new MP3Player();

        Proxy proxy = new Proxy();

        String musica = "/home/alessandro/Downloads/musica.mp3";

        File mp3File = proxy.musicaMP3( musica );

        mp3Player.tocar(mp3File);

        proxy.close();

    }

}
