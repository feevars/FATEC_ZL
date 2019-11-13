import javax.swing.JOptionPane;

public class PrincipalMergeSort {

	public static void main(String[] args) {
		final int tamanho = 5;
		int [] vetor = {10, 8, 5, 7, 2};
		int [] auxiliar = new int[tamanho];
		String textoinicial = "Vetor aleatório de 5 posições: \n";
		String textofinal = "\n Vetor ordenado: \n";
		
		//for (int i = 0; i < vetor.length; i++) {
			//vetor[i] = (int) (Math.random()*99) + 1;
			//textoinicial += "  [" + vetor[i] + "]  ";
		//}
		
		
		mergeSort(vetor, auxiliar, 0, vetor.length-1);
		
		for (int i = 0; i < vetor.length; i++) {
			textofinal += "  [" + vetor[i] + "]  ";
		}
		
		
		JOptionPane.showMessageDialog(null, textoinicial + textofinal);

	}
	
	private static void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim) {
		if (inicio < fim) { // if (0 < 4) if (0 < 2)
			int meio = (inicio + fim) / 2; // meio = 2
			mergeSort(vetor, auxiliar, inicio, meio); // mergeSort(v, aux, 0, 2) | mergeSort(v, aux, 0, 1)
			mergeSort(vetor, auxiliar, meio + 1, fim); // mergeSort(v, aux, 3, 4)
			intercala(vetor, auxiliar, inicio, meio, fim); // intercala(v, aux, 0, 2, 4)
		}
		
	}

	private static void intercala(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {
		for (int k = inicio; k <= fim; k++) 
			auxiliar[k] = vetor[k];

		
		int prim_metade = inicio;
		int seg_metade = meio + 1;
		
		for (int k = inicio; k <= fim; k++) {
			if (prim_metade > meio) vetor[k] = auxiliar[seg_metade++];
			else if (seg_metade > fim) vetor[k] = auxiliar[prim_metade++];
			else if (auxiliar[prim_metade] < auxiliar[seg_metade]) vetor[k] = auxiliar[prim_metade++];
			else vetor[k] = auxiliar[seg_metade++];	
		}
	}
}
