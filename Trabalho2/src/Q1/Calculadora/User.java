package Q1.Calculadora;

import java.io.IOException;
import java.util.Scanner;

public class User {

    public static void main(String args[]) throws IOException {

        Scanner scan = new Scanner(System.in);

        TCPClient client = new TCPClient();

        System.out.println("User Calc Q1");

        while (true){
            double op1, op2;
            int opcao;
            System.out.println("Escolha uma operação: ");
            System.out.println("1 Adição");
            System.out.println("2 Subtração");
            System.out.println("3 Multiplicação");
            System.out.println("4 Divisão");
            opcao = scan.nextInt();
            if( opcao == 0 ) {
                break;
            }
            switch ( opcao ){
                case 1:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    client.sendRequest("+;"+op1+";"+op2);
                    System.out.println( client.getResponse() );
                    break;
                case 2:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    client.sendRequest("-;"+op1+";"+op2);
                    System.out.println( client.getResponse() );
                    break;
                case 3:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    client.sendRequest("*;"+op1+";"+op2);
                    System.out.println( client.getResponse() );
                    break;
                case 4:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    client.sendRequest("/;"+op1+";"+op2);
                    System.out.println( client.getResponse() );
                    break;
            }
        }
        client.close();

    }

}
