package ServidorComTodosServicos;

public class EsqueletoChat {

    Chat chart;

    EsqueletoChat(){ chart = new Chat(); }

    public String enviar( String mensagem ){
        String resposta = chart.enviar( mensagem );
        return resposta;
    }

}
