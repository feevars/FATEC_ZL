// Carregar um vetor[100] de inteiros positivos ou negativos. Classificar esse vetor
// em ordem crescente e apresentar os resultados.

import java.util.Arrays;

public class Lista01_Ex03 {

	public static void main(String[] args) {
		int [] vetor = new int[100];
		
		for (int i = 0; i < 100; i++) {
			vetor[i] = ((int)(Math.random() * 500) - 250);
		}
		
		
		Arrays.sort (vetor);
		
		for (int i = 0; i < 100; i++) {
			System.out.println(vetor[i]);
		}
	}
	
	
}
