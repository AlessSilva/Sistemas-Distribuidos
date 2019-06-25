package Q2.MP3;

import java.io.IOException;

public class Despachante {

    private Esqueleto esqueleto;

    public Despachante(){
        esqueleto = new Esqueleto();
    }

    public byte[] invoque( String mensagem ) throws IOException {

        return esqueleto.musicaMP3(mensagem);

    }

}
