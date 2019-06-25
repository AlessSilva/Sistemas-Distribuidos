package Q2.Chat;

import java.util.Scanner;

public class Chat {

    Scanner scanner;

    Chat(){
        scanner = new Scanner(System.in);
    }

    public String enviar( String mensagem ){
        System.out.println( "Cliente: " + mensagem);
        System.out.println("Digite uma mensagem: ");
        String m = scanner.nextLine();
        return m;
    }

}