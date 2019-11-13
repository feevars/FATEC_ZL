package teste.view;

import controller.Fila;
import controller.Pilha;

public class FilaPilha<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fila fila = new Fila(5);
		Pilha pilha = new Pilha(5);
		
		
		fila.enqueue(5);
		fila.enqueue(15);
		fila.enqueue(25);
		fila.enqueue(35);
		
		pilha.push(10);
		pilha.push(20);
		pilha.push(30);
		pilha.push(40);
		
		System.out.println("Fila: \n" +fila);
		System.out.println("Pilha: \n" +pilha);
		
		System.out.println("\nRemove 1 da fila. Este será inserido na pilha.");
		pilha.push(fila.dequeue());
		
		System.out.println("Fila: \n" +fila);
		System.out.println("Pilha: \n" +pilha);
		
		System.out.println("\nRemove 1 da pilha. Este será inserido na fila.");
		fila.enqueue(pilha.pop());
		
		System.out.println("Fila: \n" +fila);
		System.out.println("Pilha: \n" +pilha);
		
		System.out.println("\nRemove 2 da pilha. Este será inserido na fila.");
		fila.enqueue(pilha.pop());
		fila.enqueue(pilha.pop());
	
		System.out.println("Fila: \n" +fila);
		System.out.println("Pilha: \n" +pilha);
		
	}
}
