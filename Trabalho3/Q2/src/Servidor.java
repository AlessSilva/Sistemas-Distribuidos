import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	
	public static void main( String args[] ) {
		
		System.setSecurityManager( new SecurityManager() );
		
		try {
			
			System.out.println("Servidor tentando inicializar");
			ManipulaVetor servente = new Servente();
			ManipulaVetor stub = (ManipulaVetor) UnicastRemoteObject.exportObject(servente, 0);
			//java.rmi.registry.LocateRegistry.createRegistry(8099);
			//Naming.rebind("rmi://localhost:8099/manipulacaoVetores", servente);
			Naming.rebind("manipulacaoVetores", servente);
			System.out.print("Servidor em execução");
			
		}catch (Exception e) {
			System.out.println("Erro no servidor. " + e.getMessage());
		}
		
	}

}
