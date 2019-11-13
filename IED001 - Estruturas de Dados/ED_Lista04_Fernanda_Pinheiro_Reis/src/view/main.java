package view;

import javax.swing.JOptionPane;

import controller.*;

public class main {

	public static int menu() {
		String textoMenu = "Digite uma op��o"
				+ "\n-----------------"
				+ "\n1-) Adicionar caractere ao in�cio da lista."
				+ "\n2-) Adicionar caractere ao fim da lista."
				+ "\n3-) Remover caractere."
				+ "\n4-) Pesquisar caractere."
				+ "\n5-) Exibir Lista de caracteres."
				+ "\n6-) Exibir n�mero de n�s na lista."
				+ "\n9-) Sair.";

		return Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
	}

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();

		String caractere;
		int opc;

		do {
			opc = menu();
			switch (opc) {


			case 1: //Adicionar caractere ao in�cio da lista.
				caractere = JOptionPane.showInputDialog("Insira um caractere no in�cio da lista:");
				lista.inserirPrimeiro(caractere);
				break;


			case 2: //Adicionar caractere ao fim da lista."
				caractere = JOptionPane.showInputDialog("Insira um caractere ao final da lista:");
				lista.inserirUltimo(caractere);
				break;

			case 3: //Remover caractere.
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null,"A lista n�o possui caracteres.");
				}
				String remove = JOptionPane.showInputDialog("Digite o caractere que deseja remover:");
				if (lista.removerNoh(remove)) {
					JOptionPane.showMessageDialog(null,"Caractere removido.");	
				} else {
					JOptionPane.showMessageDialog(null,"O caractere " + remove + " n�o p�de ser removido pois n�o est� na lista.");		
				}
				break;


			case 4: //Pesquisar caractere.
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null,"A lista est� vazia.");
				} else {
					String search = JOptionPane.showInputDialog("Digite o caractere que est� buscando:");
					JOptionPane.showMessageDialog(null, lista.pesquisarNoh(search));
				}
				break;

			case 5: //Exibir Lista de caracteres.
				JOptionPane.showMessageDialog(null, lista.printLista());
				break;


			case 6: //Exibir n�mero de n�s na lista.
				JOptionPane.showMessageDialog(null, "A lista cont�m " + lista.getQtdd_noh() + "caracteres.");
				break;


			case 9: //Sair.

				break;
			default:
				JOptionPane.showMessageDialog(null, "Op��o inv�lida.");
				break;
			}
		} while (opc != 9);
	}

}
