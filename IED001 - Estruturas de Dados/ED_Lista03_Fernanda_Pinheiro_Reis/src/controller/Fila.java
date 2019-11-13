package controller;
// 1) Uma fila � um tipo especial de lista com pol�tica que restringe a manipula��o dos elementos. 
// A pol�tica da fila � First In First Out (FIFO), o primeiro elemento adicionado ser� removido primeiro. 
// Implemente uma classe denominada Fila com esta pol�tica. 


public class Fila<T> extends EstruturaEstatica<T>{

	public Fila() {
		
	}
	public Fila(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
	}

	public void enqueue(T elemento) {
		super.adiciona(elemento);

	}

	public T dequeue() {
		if (tamanho > 0) {
			T primeiro = this.elementos[0];
			for (int i = 0; i < tamanho-1; i++) {
				this.elementos[i] = this.elementos[i+1];
			}
			this.tamanho--;
			return primeiro;
		} else {
			System.out.println("A fila est� vazia.");
			return null;
		}
	}
	
	


}
