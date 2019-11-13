// Carregar um vetor[100] real de valores de saldos. Calcular e exibir:
//			média de saldos positivos entre 100 e 1000.
//			média geral dos saldos.
//			soma dos saldos negativos.

public class Lista01_Ex01 {

	public static void main(String[] args) {
			
		float [] valores = new float [100];
		float media = 0; 
		float soma_total = 0;
		float negativos = 0;
		int cont = 0;
		
		
		for (int i = 0; i < 100; i++) {
			valores[i] = ( (float)(Math.random() * 3000) - 1500) ;
			
			
			soma_total += valores[i];
			
			
			if (valores[i] > 100 || valores[i] < 1000) {
			 media += valores[i] ;
			 cont += 1;
			} else if (valores[i] < 0) {
				negativos += valores[i];
			}
		}
		media /= cont;
		
		
		System.out.println("Total: " + soma_total + "   Média: " + soma_total/100 
				+ "\nMédia dos saldos positivos entre 100 e 1000: " + media
				+ "\nSoma dos números negativos: " + negativos);
	}

}
