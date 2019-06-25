package ServidorComTodosServicos;
import java.io.*;

public class Proxy {

    TCPClient client;

    public Proxy() throws IOException{ client = new TCPClient(); }

    public double Calc_add( Double op1, Double op2 ) throws IOException {

        String mensagem = "1;+;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse2();
        return Double.parseDouble(response);

    }

    public double Calc_sub( Double op1, Double op2 ) throws IOException {

        String mensagem = "1;-;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse2();
        return Double.parseDouble(response);

    }

    public double Calc_mult( Double op1, Double op2 ) throws IOException {

        String mensagem = "1;*;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse2();
        return Double.parseDouble(response);

    }

    public double Calc_div( Double op1, Double op2 ) throws IOException {

        String mensagem = "1;/;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse2();
        return Double.parseDouble(response);

    }

    public String Chart_enviar( String mensagem ) throws IOException {
        String m = "2;"+mensagem;
        this.client.sendRequest( m );
        String resposta =  this.client.getResponse2();
        return resposta;
    }

    public File MP3_musicaMP3( String musica ) throws IOException{
        String m = "3;"+musica;
        client.sendRequest( m );
        return toFile( client.getResponse1() );
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
