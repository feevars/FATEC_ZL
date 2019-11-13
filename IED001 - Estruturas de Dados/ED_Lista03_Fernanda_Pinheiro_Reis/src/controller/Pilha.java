package controller;

public class Pilha<T> extends EstruturaEstatica<T> {
	
	public Pilha() {
		super();
	}
	public Pilha(int capacidade) {
		super(capacidade);
	}
	
	
	public void push(T elemento) {
		super.adiciona(elemento);
	}

	public T topo() { 
		if (this.estaVazia()) {
			return null;
		} 		
		return this.elementos[tamanho-1];	
	}
	
	public boolean estaVazia() {
		return this.tamanho == 0;
	}
	
//	public boolean verificaDuplicados(T elemento) {
//		super.percorre(elemento);
//		return true;
//	}

	public T pop() {
		if (this.estaVazia()) {
			return null;
		}

		return this.elementos[--tamanho];
	}

}