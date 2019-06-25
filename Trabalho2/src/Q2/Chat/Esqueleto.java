package Q2.Chat;

public class Esqueleto {

    private Chat chart;

    public Esqueleto() {
        chart = new Chat();
    }

    public String enviar( String mensagem ){
        String resposta = chart.enviar( mensagem );
        return resposta;
    }

}
