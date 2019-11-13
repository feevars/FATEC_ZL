package controller;

public class ListaEncadeada <T> {
	private Noh primeiro;
	private Noh ultimo;
	private int qtdd_noh;
	
	public ListaEncadeada() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdd_noh = 0;
	}

	public Noh getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Noh primeiro) {
		this.primeiro = primeiro;
	}

	public Noh getUltimo() {
		return ultimo;
	}

	public void setUltimo(Noh ultimo) {
		this.ultimo = ultimo;
	}

	public int getQtdd_noh() {
		return qtdd_noh;
	}

	public void setQtdd_noh(int qtdd_noh) {
		this.qtdd_noh = qtdd_noh;
	}


	public boolean isEmpty () {
		return (this.primeiro == null);
	}
	
	public void inserirPrimeiro(T conteudo) {
		Noh novoNoh = new Noh (conteudo);
		if (this.isEmpty()) {
			this.ultimo = novoNoh;
		} 
		novoNoh.setProximo(this.primeiro);
		this.primeiro = novoNoh;
		this.qtdd_noh++;
	}
	
	public void inserirUltimo(T conteudo) {
		Noh novoNoh = new Noh(conteudo);
		if (this.isEmpty()) {
			this.primeiro = novoNoh;
		} else {
			this.ultimo.setProximo(novoNoh); 
		}
		this.ultimo = novoNoh;
		this.qtdd_noh++;
	}
	
	public boolean removerNoh (T conteudo) {
		Noh atual = this.primeiro;
		Noh anterior = null;
		if(this.isEmpty() || this.pesquisarNoh(conteudo) == "Caractere não encontrado.") {
			return false;
		} else {
			while((atual != null) && (!atual.getConteudo().toString().equals(conteudo.toString()))) {
				anterior = atual;
				atual = atual.getProximo();
			}	
		}
		if (atual == this.primeiro) {
			if (this.primeiro == this.ultimo) {
				this.ultimo = null;
			}
			this.primeiro = this.primeiro.getProximo();
		} else {
			if (atual == this.ultimo) {
				this.ultimo = anterior;
			}
			anterior.setProximo(atual.getProximo());
		}
		this.qtdd_noh--;
		return true;
	}
	public String pesquisarNoh (T conteudo) {
		String msg;
		Noh atual = this.primeiro;
		while ((atual != null) && (!atual.getConteudo().toString().equals(conteudo.toString()))) {
			atual = atual.getProximo();
		}
		if (atual != null) {
			return msg = "Conteúdo: " + atual.getConteudo().toString();		
		} else {
		return msg = "Caractere não encontrado.";
		}
	}
	
	public String printLista () {
		String msg = "";
		if (isEmpty()) {
			msg = "Lista vazia.";
		} else {
			Noh atual = this.primeiro;
			while(atual != null) {
				msg += "[" + atual.getConteudo().toString() + "] ";
				atual = atual.getProximo();
			}
		}
		return msg;
	}
}