package Q1.MP3;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MP3Player extends Thread {
    private File mp3;
    private Player player;
    public void tocar(File mp3) {
        this.mp3 = mp3;
        this.start();
    }
    public void run() {
        try {
            FileInputStream fis = new FileInputStream(mp3);
            BufferedInputStream bis = new BufferedInputStream(fis);
            this.player = new Player(bis);
            System.out.println("Tocando Musica!");
            this.player.play();
            System.out.println("Terminado Musica!");
        } catch (FileNotFoundException | JavaLayerException e) {
            System.out.println("Problema ao tocar Musica" + mp3);
            e.printStackTrace();
        }
    }
}
