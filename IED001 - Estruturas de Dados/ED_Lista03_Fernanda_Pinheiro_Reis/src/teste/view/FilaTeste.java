package teste.view;

import controller.Fila;


public class FilaTeste<T> {

	public static void main(String[] args) {
		
		Fila<Integer> fila = new Fila<Integer>(5);
		
		System.out.println("Adicionar valor: 20.");
		
		fila.enqueue(20);
		System.out.println(fila);
		
		System.out.println("Adicionar valor: 10.");
		fila.enqueue(10);
		System.out.println(fila);
		
		System.out.println("Adicionar valores: 40, 5, 25, 30.");
		fila.enqueue(40);
		fila.enqueue(5);
		fila.enqueue(25);
		fila.enqueue(30);
		
		System.out.println(fila);
		
		System.out.println("Remove 1.");
		fila.dequeue();
		
		System.out.println(fila);
		
	
	}

}
