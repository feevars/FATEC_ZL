package controller;


public class No<T> {
	


	private T conteudo;
	private No<T> anterior;
	private No<T> proximo;
	
	
	public No (T conteudo){
		this.conteudo = conteudo;
		this.anterior = null;
		this.proximo = null;
	}


	public T getConteudo() {
		return conteudo;
	}


	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}


	public No<T> getAnterior() {
		return anterior;
	}


	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}


	public No<T> getProximo() {
		return proximo;
	}


	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		return conteudo + "\n";
	}
	
}
