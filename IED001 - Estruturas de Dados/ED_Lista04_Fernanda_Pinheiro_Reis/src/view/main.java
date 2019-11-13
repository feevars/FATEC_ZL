package view;

import javax.swing.JOptionPane;

import controller.*;

public class main {

	public static int menu() {
		String textoMenu = "Digite uma opção"
				+ "\n-----------------"
				+ "\n1-) Adicionar caractere ao início da lista."
				+ "\n2-) Adicionar caractere ao fim da lista."
				+ "\n3-) Remover caractere."
				+ "\n4-) Pesquisar caractere."
				+ "\n5-) Exibir Lista de caracteres."
				+ "\n6-) Exibir número de nós na lista."
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


			case 1: //Adicionar caractere ao início da lista.
				caractere = JOptionPane.showInputDialog("Insira um caractere no início da lista:");
				lista.inserirPrimeiro(caractere);
				break;


			case 2: //Adicionar caractere ao fim da lista."
				caractere = JOptionPane.showInputDialog("Insira um caractere ao final da lista:");
				lista.inserirUltimo(caractere);
				break;

			case 3: //Remover caractere.
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null,"A lista não possui caracteres.");
				}
				String remove = JOptionPane.showInputDialog("Digite o caractere que deseja remover:");
				if (lista.removerNoh(remove)) {
					JOptionPane.showMessageDialog(null,"Caractere removido.");	
				} else {
					JOptionPane.showMessageDialog(null,"O caractere " + remove + " não pôde ser removido pois não está na lista.");		
				}
				break;


			case 4: //Pesquisar caractere.
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null,"A lista está vazia.");
				} else {
					String search = JOptionPane.showInputDialog("Digite o caractere que está buscando:");
					JOptionPane.showMessageDialog(null, lista.pesquisarNoh(search));
				}
				break;

			case 5: //Exibir Lista de caracteres.
				JOptionPane.showMessageDialog(null, lista.printLista());
				break;


			case 6: //Exibir número de nós na lista.
				JOptionPane.showMessageDialog(null, "A lista contém " + lista.getQtdd_noh() + "caracteres.");
				break;


			case 9: //Sair.

				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				break;
			}
		} while (opc != 9);
	}

}
