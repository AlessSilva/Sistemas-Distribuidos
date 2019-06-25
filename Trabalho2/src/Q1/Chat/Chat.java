package Q1.Chat;

import java.util.Scanner;

public class Chat {

    Scanner scanner;

    Chat(){
        scanner = new Scanner(System.in);
    }

    public void verMensagem( String mensagem ){
        System.out.println( "Cliente: " + mensagem);
    }

    public String enviarResposta(){
        System.out.println("Digite uma mensagem: ");
        String m = scanner.nextLine();
        return m;
    }

}
