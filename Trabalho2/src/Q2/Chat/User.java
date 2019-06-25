package Q2.Chat;

import java.io.IOException;
import java.util.Scanner;

public class User {

    public static void main (String args[]) throws IOException {

        System.out.println("User Chat Q2");
        Proxy proxy = new Proxy();
        Scanner scan = new Scanner(System.in);

        while (true){

            System.out.println("Digite a mensagem: ");
            String mensagem = scan.nextLine();

            if( mensagem.equals("sair") ){
                break;
            }

            String resposta = proxy.enviar(mensagem);
            System.out.println("Servidor: " + resposta);

        }

        proxy.close();

    }

}