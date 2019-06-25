package Q1.Chat;

import java.io.IOException;
import java.util.Scanner;

public class User {

    public static void main (String args[]) throws IOException {

        TCPClient client = new TCPClient();
        Scanner scan = new Scanner(System.in);

        System.out.println("User Chat Q1");
        while (true){

            System.out.println("Digite a mensagem: ");
            String mensagem = scan.nextLine();

            if( mensagem.equals("sair") ){
                break;
            }

            client.sendRequest(mensagem);
            String resposta = client.getResponse();

            System.out.println("Servidor: " + resposta);

        }

        client.close();

    }

}
