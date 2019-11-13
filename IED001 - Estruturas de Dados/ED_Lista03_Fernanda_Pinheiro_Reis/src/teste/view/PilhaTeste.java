package teste.view;

import controller.Pilha;


public class PilhaTeste <T> {

	public static void main(String[] args) {
		
		Pilha<Integer> pilha = new Pilha<Integer>(5);
		
		System.out.println("Adicionar valor: 20.");
		
		pilha.push(20);
		System.out.println(pilha);
		
		System.out.println("\n---Adicionar valor: 10.");
		pilha.push(10);
		System.out.println(pilha);
		
		System.out.println("\n---Adicionar valores: 40, 5, 25, 30.");
		pilha.push(40);
		pilha.push(5);
		pilha.push(25);
		pilha.push(30);
		
		System.out.println(pilha);
		
		System.out.println("\n---Remove o último.");
		pilha.pop();
		System.out.println(pilha);
		
		System.out.println("\n---Adicionar valor: 30.");
		pilha.push(30);
		System.out.println(pilha);
		
		System.out.println("\n---Adicionar valor: 60.");
		pilha.push(60);
		System.out.println(pilha);
		
		System.out.println("\n---Remove o último.");
		pilha.pop();
		System.out.println(pilha);
	}

}
