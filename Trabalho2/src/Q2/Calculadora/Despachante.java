package Q2.Calculadora;

public class Despachante {

    private Esqueleto esqueleto;

    public Despachante(){
        esqueleto = new Esqueleto();
    }

    public String invoque( String mensagem ){
        String operacao =  mensagem.split(";")[0];
        if( operacao.equals("+") ){
            return this.esqueleto.add(mensagem.substring(2));
        }else if( operacao.equals("-") ){
            return this.esqueleto.sub(mensagem.substring(2));
        }else if( operacao.equals("*") ){
            return this.esqueleto.mult(mensagem.substring(2));
        }else if( operacao.equals("/") ){
            return this.esqueleto.div(mensagem.substring(2));
        }
        return "ERRO";
    }

}
