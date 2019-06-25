package Q2.Chat;

public class Despachante {

    private Esqueleto esqueleto;

    public Despachante(){
        esqueleto = new Esqueleto();
    }

    public String invoque( String mensagem ){ return esqueleto.enviar( mensagem ); }

}