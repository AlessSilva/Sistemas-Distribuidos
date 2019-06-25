package Q2.Calculadora;

import java.io.IOException;
import java.util.Scanner;

public class User {

    public static void main (String args[]) throws IOException {

        Proxy proxy = new Proxy();
        Scanner scan = new Scanner(System.in);
        System.out.println("User Calculadora Q2");
        while (true){
            Double op1, op2;
            System.out.println("Escolha uma operação: ");
            System.out.println("1 Adição");
            System.out.println("2 Subtração");
            System.out.println("3 Multiplicação");
            System.out.println("4 Divisão");
            switch ( scan.nextInt() ){
                case 1:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    System.out.println( proxy.add(op1,op2) );
                    break;
                case 2:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    System.out.println( proxy.sub(op1,op2) );
                    break;
                case 3:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    System.out.println( proxy.mult(op1,op2) );
                    break;
                case 4:
                    System.out.println("Informe o primeiro operando:");
                    op1 = scan.nextDouble();
                    System.out.println("Informe o segundo operando:");
                    op2 = scan.nextDouble();
                    System.out.println( proxy.div(op1,op2) );
                    break;
            }
        }

    }

}
