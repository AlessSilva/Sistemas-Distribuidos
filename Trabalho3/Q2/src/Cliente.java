import java.rmi.*;
import java.util.*;

public class Cliente {

	public static void main(String[] args) {
		
		if( System.getSecurityManager() == null ) {
			System.setSecurityManager( new SecurityManager() ); 
		}
		
		ManipulaVetor mvetor = null;
		
		try {
			
			System.out.println("Cliente tentando inicializar");
			//mvetor = (ManipulaVetor) Naming.lookup( "rmi://localhost:8099/manipulacaoVetores" );
			mvetor = (ManipulaVetor) Naming.lookup( "manipulacaoVetores" );
			System.out.println("Servidor encontrado");
			boolean sair = false;
			int op;
			
			while(!sair) {
				
				Scanner scan = new Scanner(System.in);
				double[] vetor;
				
				System.out.println("--------------Escolha uma opção-----------------");
				System.out.println("| 1 | Calcular média");
				System.out.println("| 2 | Calcular mediana");
				System.out.println("| 3 | Calcular moda");
				System.out.println("| 4 | Ordenação Não-Decrescente");
				System.out.println("| 5 | Ordenação Não-Crescente");
				System.out.println("| 6 | Sair");
				System.out.println("-------------------------------------------------");
				
				op = scan.nextInt();
				
				switch ( op ) {
					case 1:
						
						System.out.print("Informe o tamanho do vetor: ");
						vetor = new double[scan.nextInt()];
						
						System.out.print("Informe os elementos do  vetor: ");
						
						for( int i = 0; i < vetor.length; i++ ) {
							
							vetor[i] = scan.nextDouble();
							
						}
						
						double media = mvetor.Media(vetor);
						
						System.out.println("Média: " + media);
						System.out.print("Digite qualquer coisa para continuar ");
						scan.next();
											
						vetor = null;
						
						break;
		
					case 2:
						
						System.out.print("Informe o tamanho do vetor: ");
						vetor = new double[scan.nextInt()];
						
						System.out.print("Informe os elementos do  vetor: ");
						
						for( int i = 0; i < vetor.length; i++ ) {
							
							vetor[i] = scan.nextDouble();
							
						}
						
						double mediana = mvetor.Mediana(vetor);
						
						System.out.println("Mediana: " + mediana);
						System.out.print("Digite qualquer coisa para continuar ");
						scan.next();
						
						vetor = null;
						
						break;
					
					case 3:
						
						System.out.print("Informe o tamanho do vetor: ");
						vetor = new double[scan.nextInt()];
						
						System.out.print("Informe os elementos do  vetor: ");
						
						for( int i = 0; i < vetor.length; i++ ) {
							
							vetor[i] = scan.nextDouble();
							
						}
						
						double moda = mvetor.Moda(vetor);
						
						System.out.println("Moda: " + moda);
						System.out.print("Digite qualquer coisa para continuar ");
						scan.next();
						
						vetor = null;
						
						break;
						
					case 4:
						
						System.out.print("Informe o tamanho do vetor: ");
						vetor = new double[scan.nextInt()];
						
						System.out.print("Informe os elementos do  vetor: ");
						
						for( int i = 0; i < vetor.length; i++ ) {
							
							vetor[i] = scan.nextDouble();
							
						}
						
						vetor = mvetor.OrdCrescente(vetor);
						
						System.out.print("Resultado : ");
						for( int i = 0; i < vetor.length; i++ ) {
							
							System.out.print( vetor[i] + " " );
							
						}
						System.out.println();
						System.out.print("Digite qualquer coisa para continuar ");
						scan.next();
						
						vetor = null;
						
						break;
					
					case 5:
						
						System.out.print("Informe o tamanho do vetor: ");
						vetor = new double[scan.nextInt()];
						
						System.out.print("Informe os elementos do  vetor: ");
						
						for( int i = 0; i < vetor.length; i++ ) {
							
							vetor[i] = scan.nextDouble();
							
						}
						
						vetor = mvetor.OrdDecrescente(vetor);
						
						System.out.print("Resultado : ");
						for( int i = 0; i < vetor.length; i++ ) {
							
							System.out.print( vetor[i] + " " );
							
						}
						System.out.println();
						System.out.print("Digite qualquer coisa para continuar ");
						scan.next();
						
						vetor = null;
						
						break;	
						
					case 6:
						
						System.out.println("Bye");
						sair = true;
						break;
						
					default:
						
						System.out.println("Opção Inválida");
						System.out.print("Digite qualquer coisa para continuar");
						scan.next();
						
						break;
					}
			}	
			
			
		}catch (Exception e) {
			
			System.out.print("Erro no Cliente. " + e.getMessage());
			
		}
		
	}

}
