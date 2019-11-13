package controller;

import javax.swing.JOptionPane;

import model.Funcionario;

public class ListaDupla<T> {


	private No<T> primeiro;
	private No<T> ultimo;
	private int qtdNo;


	public int getQtdNo() {
		return qtdNo;
	}

	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNo = 0;
	}

	public boolean estaVazia() {
		return qtdNo == 0;
	}

	public void adicionaPrimeiro(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.ultimo = novoNo;
		} else {
			this.primeiro.setAnterior(novoNo);
		}
		novoNo.setProximo(this.primeiro);
		this.primeiro = novoNo;
		this.qtdNo++;
	}

	public void adicionaUltimo(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if (this.estaVazia()) {
			this.primeiro = novoNo;
		} else {
			this.ultimo.setProximo(novoNo);
		}
		novoNo.setAnterior(this.ultimo);
		this.ultimo = novoNo;
		this.qtdNo++;
	}

	public void adicionaPosicao (T conteudo, int posicao) {
		No<T> novoNo;
		No<T> auxNo;

		if (posicao > this.qtdNo) {
			JOptionPane.showMessageDialog(null, "A posi��o desejada � maior que o tamanho da lista. Inserindo no final...");
			this.adicionaUltimo(conteudo);
			return;
		} else if (posicao < this.qtdNo / 2) {
			novoNo = new No<T>(conteudo);
			auxNo = this.primeiro;
			for (int i = 1; i < (posicao - 1); i++) {
				auxNo = auxNo.getProximo();
			}
			novoNo.setAnterior(auxNo);
			novoNo.setProximo(auxNo.getProximo());
			auxNo.setProximo(novoNo);
			auxNo = novoNo.getProximo();
			auxNo.setAnterior(novoNo);
			qtdNo++;
		} else {
			novoNo = new No<T>(conteudo);
			auxNo = this.ultimo;
			for (int i = this.qtdNo; i > posicao; i--) {
				auxNo = auxNo.getAnterior();
			}
			novoNo.setProximo(auxNo);
			novoNo.setAnterior(auxNo.getAnterior());
			auxNo.setAnterior(novoNo);
			auxNo = novoNo.getAnterior();
			auxNo.setProximo(novoNo);
			qtdNo++;
		}
	}
		public String imprimirLista() {

			String listaImpressa = "Lista de Funcion�rios:\n\n";

			if (this.estaVazia()) {
				listaImpressa += "A lista est� vazia.";
				return listaImpressa;
			}
			No<T> atual = this.primeiro;

			while(atual != null) {
				listaImpressa += atual.getConteudo().toString() + "\n";
				atual = atual.getProximo();
			}

			return listaImpressa;
		}
		
	}