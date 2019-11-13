package controller;

import model.Aluno;

public class ListaDupla<T> {

	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;
	// Conta id;
	private int contaId;
	// contador auxiliar da recursão
	private No<T> contador;
	private String listaTexto = "";
	// contador auxiliar de inteiros para o vetor;
	private int contadorInt;

	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
		this.contaId = 0;
		this.contador = this.primeiro;
		this.contadorInt = 0;
	}

	// verifica se a lista está vazia
	public boolean estaVazia() {
		return (this.qtdNo == 0);
	}

	// adiciona na primeira posição
	public void adicionaPrimeira(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia())
			this.ultimo = novoNo;
		else
			this.primeiro.setAnterior(novoNo);
		novoNo.setProximo(this.primeiro);
		this.primeiro = novoNo;
		this.contador = this.primeiro;
		this.qtdNo++;
		this.contaId++;
	}

	// adiciona na última posição
	public void adicionaUltima(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia())
			this.primeiro = novoNo;
		else
			this.ultimo.setProximo(novoNo);
		novoNo.setAnterior(this.ultimo);
		this.ultimo = novoNo;
		this.contador = this.primeiro;
		this.qtdNo++;
		this.contaId++;
	}

	public No<T> adicionaPosicao(T conteudo, int posicao) {
		if (posicao == 2) { // até 1 antes da posição...
			No<T> novoNo = new No<T>(conteudo);
			novoNo.setAnterior(this.contador);
			novoNo.setProximo(this.contador.getProximo());
			this.contador.getProximo().setAnterior(novoNo);
			this.contador.setProximo(novoNo);
			this.qtdNo++;
			this.contaId++;
			this.contador = this.primeiro;
			return novoNo;
		} else {
			this.contador = this.contador.getProximo();
			return adicionaPosicao(conteudo, posicao - 1);
		}
	}

	public void removePrimeiro() {
		if (qtdNo == 1) {
			this.primeiro = null;
			this.ultimo = null;
			this.contador = this.primeiro;
		} else {
			this.contador = this.primeiro;
			this.primeiro = this.primeiro.getProximo();
			this.primeiro.setAnterior(null);
		}
		this.qtdNo--;
	}

	public void removeUltimo() {
		if (qtdNo == 1) {
			this.primeiro = null;
			this.ultimo = null;
			this.contador = this.primeiro;
		} else {
			this.contador = this.ultimo;
			this.ultimo = this.ultimo.getAnterior();
			this.ultimo.setProximo(null);
			this.contador = this.primeiro;
		}
		this.qtdNo--;
	}

	public void removePosicao(int posicao) {
		if (posicao == 1) {
			this.contador.getAnterior().setProximo(this.contador.getProximo());
			this.contador.getProximo().setAnterior(this.contador.getAnterior());
			this.contador = this.primeiro;
			this.qtdNo--;
		} else {
			this.contador = this.contador.getProximo();
			removePosicao(posicao - 1);
		}
	}


	public No<T> getPrimeiro() {
		return primeiro;
	}

	public No<T> getUltimo() {
		return ultimo;
	}

	public No<T> getContador() {
		return contador;
	}

	public void setContador(No<T> contador) {
		this.contador = contador;
	}
	public int getQtdNo() {
		return qtdNo;
	}

	public int getContaId() {
		return contaId;
	}

	public int getContadorInt() {
		return contadorInt;
	}

	public void setContadorInt(int contadorInt) {
		this.contadorInt = contadorInt;
	}
	
	
	// método de impressão de string recursivo

	public String listaString() {
		if (this.estaVazia())
			return "A lista está vazia.";
		if (this.contador == this.ultimo) {
			this.listaTexto += this.ultimo.toString();
			String listaImpressa = listaTexto;
			this.listaTexto = "";
			this.contador = this.primeiro;
			return listaImpressa;
		} else {
			this.listaTexto += this.contador.toString();
			this.contador = this.contador.getProximo();
			return listaString();
		}
	}
}