package ServidorComTodosServicos;

import java.io.IOException;

public class Despachante {

    EsqueletoCalc esqueletoCalc;
    EsqueletoChat esqueletoChat;
    EsqueletoMP3 esqueletoMP3;

    public Despachante(){
        this.esqueletoCalc = new EsqueletoCalc();
        this.esqueletoChat = new EsqueletoChat();
        this.esqueletoMP3 = new EsqueletoMP3();
    }

    public Object invoque( String mensagem ) throws IOException {
        switch ( mensagem.split(";")[0] ){
            case "1":

                    String operacao =  mensagem.substring(2).split(";")[0];
                    if( operacao.equals("+") ){
                        return this.esqueletoCalc.add(mensagem.substring(4));
                    }else if( operacao.equals("-") ){
                        return this.esqueletoCalc.sub(mensagem.substring(4));
                    }else if( operacao.equals("*") ){
                        return this.esqueletoCalc.mult(mensagem.substring(4));
                    }else if( operacao.equals("/") ){
                        return this.esqueletoCalc.div(mensagem.substring(4));
                    }
                    return "ERRO";

            case "2":

                    return esqueletoChat.enviar( mensagem.substring(2) );

            default:

                    return new Bytes(esqueletoMP3.musicaMP3(mensagem.substring(2)));

        }
    }

}
