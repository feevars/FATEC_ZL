package view;

import controller.HeapSort;

public class Lista08 {
	static String enunciado = "5) Realize a implementa��o completa do Algor�tmo Heap Sort considerando os Exerc�cios 1 e 2, "
			+ "\ntanto para o Heap M�ximo quanto para o Heap M�nimo.\n\n ";

	public static void main(String[] args) {

		int [] vetor = {87, 6, 3, 5, 1, 9, 42, 43, 57, 71, 23, 21, 98};

		System.out.println(enunciado);

		System.out.println("Vetor desordenado: " + HeapSort.printaVetor(vetor));


		HeapSort.sortMinimum(vetor);
		System.out.println("\nHeapSort m�nimo (posi��o [0] � o menor): " + HeapSort.printaVetor(vetor));

		HeapSort.sortMaximum(vetor);
		System.out.println("\nHeapSort m�ximo (posi��o [0] � o maior): " + HeapSort.printaVetor(vetor));

	}
}

