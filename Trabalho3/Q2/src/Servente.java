import java.rmi.*;
import java.util.HashMap;
import java.util.Map;

public class Servente implements ManipulaVetor {	

	public Servente() throws RemoteException {
	}

	public double[] OrdCrescente( double vetor[] ) throws RemoteException {
		
		double menor;
		
		for( int i = 0; i < vetor.length; i++ ) {
			
			menor = vetor[i];
			
			for( int j = i; j < vetor.length; j++ ) {
				
				if( vetor[j] < menor ) {
					menor = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = menor;
				}
				
			}
			
		}
		
		return vetor;
		
	}
	
	public double[] OrdDecrescente( double vetor[] ) throws RemoteException {
		
		double maior;
		
		for( int i = 0; i < vetor.length; i++ ) {
			
			maior = vetor[i];
			
			for( int j = i; j < vetor.length; j++ ) {
				
				if( vetor[j] > maior ) {
					maior = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = maior;
				}
				
			}
			
		}
		
		return vetor;
		
	}
	
	public double Media( double vetor[] ) throws RemoteException {
		
		double media = 0;
		
		for( int i = 0; i < vetor.length; i++ ) {
			
			media += vetor[i];
			
		}
		
		media = media/vetor.length;
		
		return media;
		
	}

	public double Moda( double vetor[] ) throws RemoteException {
		
		Map<Double,Integer> mapa = new HashMap<Double,Integer>();
		int aux, quantidade = 0;
		double elem = 0.0;
		
		for( int i = 0; i < vetor.length; i++ ) {		
			if( mapa.containsKey(vetor[i]) ) {
				aux = mapa.get(vetor[i]);
				mapa.put(vetor[i], aux+1);
			}else {
				mapa.put(vetor[i], 1);
				elem = vetor[i];
				quantidade = 1;
			}
		}
		
		for( int i = 0; i < vetor.length; i++ ) {	
			aux = mapa.get(vetor[i]);
			if( quantidade < aux ) {
				quantidade = aux;
				elem = vetor[i];
			}
		}
		
		return elem;
	}
	
	public double Mediana( double vetor[] ) throws RemoteException {
		
		double mediana;
		int indice;
		
		vetor = OrdCrescente(vetor);
		
		if( vetor.length%2 == 1 ) {
			indice = ((vetor.length-1)/2) + 1;
			mediana = vetor[indice];
		}else {
			indice = (vetor.length/2);
			mediana = (vetor[indice] + vetor[indice-1])/2;
		}
		
		return mediana;
		
	}
	
}
