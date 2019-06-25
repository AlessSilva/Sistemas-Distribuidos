package ServidorComTodosServicos;
import java.util.Scanner;
import java.io.*;
import Q2.MP3.MP3Player;


public class User {

    public static void main( String args[] ) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Proxy proxy = new Proxy();

        while (true){

            System.out.println("Escolha o serviço:");
            System.out.println("1 Calculadora");
            System.out.println("2 Chat");
            System.out.println("3 MP3");

            switch (scanner.nextInt()){

                case 1: //Calculadora

                        Double op1, op2;
                        System.out.println("Escolha uma operação: ");
                        System.out.println("1 Adição");
                        System.out.println("2 Subtração");
                        System.out.println("3 Multiplicação");
                        System.out.println("4 Divisão");
                        switch ( scanner.nextInt() ){
                            case 1:
                                System.out.println("Informe o primeiro operando:");
                                op1 = scanner.nextDouble();
                                System.out.println("Informe o segundo operando:");
                                op2 = scanner.nextDouble();
                                System.out.println( proxy.Calc_add(op1,op2) );
                                break;
                            case 2:
                                System.out.println("Informe o primeiro operando:");
                                op1 = scanner.nextDouble();
                                System.out.println("Informe o segundo operando:");
                                op2 = scanner.nextDouble();
                                System.out.println( proxy.Calc_sub(op1,op2) );
                                break;
                            case 3:
                                System.out.println("Informe o primeiro operando:");
                                op1 = scanner.nextDouble();
                                System.out.println("Informe o segundo operando:");
                                op2 = scanner.nextDouble();
                                System.out.println( proxy.Calc_mult(op1,op2) );
                                break;
                            case 4:
                                System.out.println("Informe o primeiro operando:");
                                op1 = scanner.nextDouble();
                                System.out.println("Informe o segundo operando:");
                                op2 = scanner.nextDouble();
                                System.out.println( proxy.Calc_div(op1,op2) );
                                break;
                        }
                    break;

                case 2: //Chat

                        scanner.nextLine();
                        while (true){

                            System.out.println("Digite a mensagem: ");
                            String mensagem = scanner.nextLine();

                            if( mensagem.equals("sair") ){
                                break;
                            }

                            String resposta = proxy.Chart_enviar(mensagem);
                            System.out.println("Servidor: " + resposta);

                        }

                    break;

                case 3: //MP3

                        MP3Player mp3Player = new MP3Player();
                        String musica = "/home/alessandro/Downloads/musica.mp3";
                        File mp3File = proxy.MP3_musicaMP3( musica );
                        mp3Player.tocar(mp3File);

                    break;
                default:

                        System.out.println("Opção Inválida");

                    break;
            }

        }

    }

}
