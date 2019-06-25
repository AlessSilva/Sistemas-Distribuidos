package Q2.Calculadora;

import java.io.IOException;

public class Proxy {

    private TCPClient client;

    public Proxy() throws IOException {

        this.client = new TCPClient();

    }

    public double add( Double op1, Double op2 ) throws IOException {

        String mensagem = "+;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse();
        return Double.parseDouble(response);

    }

    public double sub( Double op1, Double op2 ) throws IOException {

        String mensagem = "-;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse();
        return Double.parseDouble(response);

    }

    public double mult( Double op1, Double op2 ) throws IOException {

        String mensagem = "*;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse();
        return Double.parseDouble(response);

    }

    public double div( Double op1, Double op2 ) throws IOException {

        String mensagem = "/;"+op1+";"+op2;
        this.client.sendRequest( mensagem );
        String response = client.getResponse();
        return Double.parseDouble(response);

    }

}
