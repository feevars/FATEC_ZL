package view;

import controller.HeapSort;

public class Lista08 {
	static String enunciado = "5) Realize a implementação completa do Algorítmo Heap Sort considerando os Exercícios 1 e 2, "
			+ "\ntanto para o Heap Máximo quanto para o Heap Mínimo.\n\n ";

	public static void main(String[] args) {

		int [] vetor = {87, 6, 3, 5, 1, 9, 42, 43, 57, 71, 23, 21, 98};

		System.out.println(enunciado);

		System.out.println("Vetor desordenado: " + HeapSort.printaVetor(vetor));


		HeapSort.sortMinimum(vetor);
		System.out.println("\nHeapSort mínimo (posição [0] é o menor): " + HeapSort.printaVetor(vetor));

		HeapSort.sortMaximum(vetor);
		System.out.println("\nHeapSort máximo (posição [0] é o maior): " + HeapSort.printaVetor(vetor));

	}
}

