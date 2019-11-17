package controller;

public interface HeapSort {

	public static void sortMinimum(int vetor[]) {

		int tamanho = vetor.length;

		// Constrói o heap rearranjando o vetor
		for (int i = tamanho / 2 - 1; i >= 0; i--) {
			heapMinimum(vetor, tamanho, i);
		}

		// Um a um, extrai elementos do heap
		for (int i = tamanho - 1; i >= 0; i--) {

			// Move a atual raiz para o final - troca com o último último do heap 
			int aux = vetor[0];
			vetor[0] = vetor[i];
			vetor[i] = aux;

			// chamada recursiva para reordenar o heap
			heapMinimum(vetor, i, 0);
		}
	}

	public static void sortMaximum(int vetor[]) {

		int tamanho = vetor.length;

		// Constrói o heap rearranjando o vetor
		for (int i = tamanho / 2 - 1; i >= 0; i--) {
			heapMaximum(vetor, tamanho, i);
		}

		// Um a um, extrai elementos do heap
		for (int i = tamanho - 1; i >= 0; i--) {

			// troca o primeiro com o último do heap 
			int aux = vetor[0];
			vetor[0] = vetor[i];
			vetor[i] = aux;

			// chamada recursiva para reordenar o heap
			heapMaximum(vetor, i, 0);
		}
	}

	public static void heapMaximum(int[] vetor, int tamanho, int i) {

		int menor = i; // Inicia o menor como raiz
		int esquerda = 2 * i + 1;
		int direita = 2 * i + 2;

		// Se o filho da esquerda é menor que a raiz...
		if (esquerda < tamanho && vetor[esquerda] < vetor[menor])
			menor = esquerda;

		// Se o filho da direita é menor que o menor...
		if (direita < tamanho && vetor[direita] < vetor[menor])
			menor = direita;

		// Se o maior não é a raiz
		if (menor != i) {
			int troca = vetor[i];
			vetor[i] = vetor[menor];
			vetor[menor] = troca;

			// Chamada recursiva para os próximos níveis da árvore
			heapMaximum(vetor, tamanho, menor);
		}
	}

	public static void heapMinimum(int[] vetor, int tamanho, int i) {

		int maior = i; // Inicia o maior como raiz
		int esquerda = 2 * i + 1;
		int direita = 2 * i + 2;

		// Se o filho da esquerda é maior que a raiz...
		if (esquerda < tamanho && vetor[esquerda] > vetor[maior])
			maior = esquerda;

		// Se o filho da direita é maior que o maior...
		if (direita < tamanho && vetor[direita] > vetor[maior])
			maior = direita;

		// Se o maior não é a raiz
		if (maior != i) {
			int troca = vetor[i];
			vetor[i] = vetor[maior];
			vetor[maior] = troca;

			// Chamada recursiva para os próximos níveis da árvore
			heapMinimum(vetor, tamanho, maior);
		}
	}

	public static String printaVetor(int vetor[]) {

		String vetorTexto = "[";

		for (int i = 0; i < vetor.length; i++) {
			vetorTexto += vetor[i];
			if (i < (vetor.length - 1)) {
				vetorTexto += ", ";
			} else {
				vetorTexto += "]";
			}
		}

		return vetorTexto;
	}
}
