package controller;

public class Noh <T> {
	private T conteudo;
	private Noh proximo;
	
	public Noh(T conteudo) {
		this.conteudo = conteudo;
		this.proximo = null;
	}

	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public Noh getProximo() {
		return proximo;
	}

	public void setProximo(Noh proximo) {
		this.proximo = proximo;
	}
	
	
	
}
