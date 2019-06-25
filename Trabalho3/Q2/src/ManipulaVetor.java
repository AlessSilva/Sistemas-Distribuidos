import java.rmi.*;

public interface ManipulaVetor extends Remote {

	double[] OrdCrescente( double[] vetor )	  throws RemoteException;
	double[] OrdDecrescente( double[] vetor ) throws RemoteException;
	double   Media( double[] vetor )          throws RemoteException;
	double   Mediana( double[] vetor )        throws RemoteException;
	double   Moda( double[] vetor )           throws RemoteException;
	
}
