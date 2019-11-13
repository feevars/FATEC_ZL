import java.util.Arrays;

public class QuickSort {

	public static int[] oArray;
	private static int tamanhoArray;


	public static void main(String[] args) {
		QuickSort sort = new QuickSort(10);

		sort.gerarArrayRandomico();

		System.out.println(Arrays.toString(QuickSort.oArray));

		sort.quickSort(0, 9);

		System.out.println(Arrays.toString(QuickSort.oArray));
	}

	QuickSort(int novoTamanhoArray) {
		tamanhoArray = novoTamanhoArray;
		oArray = new int[tamanhoArray];
		gerarArrayRandomico();
	}

	private void gerarArrayRandomico() {
		for (int i = 0; i < tamanhoArray; i++) {
			oArray[i] = (int) (Math.random() * 50) + 10;
		}

	}

	public void quickSort(int esquerda, int direita) {

		if (direita - esquerda <= 0)
			return; //tudo está organizado. condição de parada

		else {

			int pivo = oArray[direita];
			System.out.println("O valor " + oArray[direita]
					+ " será o pivô.\n");
			System.out.println("| esquerda = " + esquerda + "| direita = " + direita
					+ " pivô = " + pivo + " será particionado...");

			int localizacaoPivo = particaoArray(direita, esquerda, pivo);

			System.out.println("O valor da esquerda " + oArray[esquerda]
					+ " é o pivô.");

			quickSort(esquerda, localizacaoPivo - 1); // sort left side
			quickSort(localizacaoPivo + 1, direita); // sort right side
		}

	}

	private int particaoArray(int direita, int esquerda, int pivo) {

		int ponteiroEsquerda = esquerda - 1; 
		int ponteiroDireita = direita;

		while (true) {
			while(oArray[++ponteiroEsquerda] < pivo)
				;
			imprimeArray(ponteiroEsquerda, ponteiroDireita);

			System.out.println(oArray[ponteiroEsquerda] + " no index " + ponteiroEsquerda 
					+ " é maior que o pivô " +pivo);

			while (ponteiroDireita > 0 && oArray[--ponteiroDireita] > pivo)
				;
			imprimeArray(ponteiroEsquerda, ponteiroDireita);

			System.out.println(oArray[ponteiroDireita] + " no index " + ponteiroDireita
					+ " é menor que o pivô " +pivo);
			imprimeArray(ponteiroEsquerda, ponteiroDireita);

			if (ponteiroEsquerda >= ponteiroDireita) {
				System.out.println("o da esquerda é maior que o da direita então "
						+ "começaremos de novo...");
				break;
			} else {
				mudarValores(ponteiroEsquerda, ponteiroDireita);
				System.out.println(oArray[ponteiroEsquerda] + " mudou para " 
						+oArray[ponteiroDireita]);
			}
		}
		mudarValores(ponteiroEsquerda, direita);
		return ponteiroEsquerda;
	}

	private void mudarValores(int indexUm, int indexDois) {
		  int temp = oArray[indexUm];
		          oArray[indexUm] = oArray[indexDois];
		          oArray[indexDois] = temp;
	}

	private void imprimeArray(int i, int j) {
		for (int n = 0; n < 61; n++)
			System.out.print("-");
		System.out.println();

		for (int n = 0; n < tamanhoArray; n++) {
			System.out.format("| %2s " + " ", n);
		}
		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");
		System.out.println();

		for (int n = 0; n < tamanhoArray; n++) {
			System.out.print(String.format("| %2s " + " ", oArray[n]));
		}
		System.out.println("|");
		for (int n = 0; n < 61; n++)
			System.out.print("-");
		System.out.println();

		if (i != -1) {
			// Number of spaces to put before the F
			int spacesBeforeFront = 5 * i + 1;
			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");
			System.out.print("L" + i);
			// Number of spaces to put before the R
			int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");
			System.out.print("R" + j);
			System.out.println("\n");
		}
	}
}
