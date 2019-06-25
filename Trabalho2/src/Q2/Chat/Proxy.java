package Q2.Chat;

import java.io.IOException;

public class Proxy {

    private TCPClient client;

    public Proxy() throws IOException { this.client = new TCPClient(); }

    public String enviar( String mensagem ) throws IOException {
        this.client.sendRequest( mensagem );
        String resposta =  this.client.getResponse();
        return resposta;
    }

    public void close() throws IOException { client.close(); }

}
