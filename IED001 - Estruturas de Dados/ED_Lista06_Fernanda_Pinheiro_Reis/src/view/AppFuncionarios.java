package view;

import javax.swing.JOptionPane;

import controller.ListaDupla;
import model.Funcionario;

public class AppFuncionarios<T> {

	public static void main(String[] args) {
		
		ListaDupla<Double> lista = new ListaDupla<Double>();
		Funcionario func = new Funcionario(null);
		int opcaoMenu;
		
		do {
			opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("Lista de Funcionários\n----------------------\n"
					+ "Digite a opção do menu:\n"
					+ "1 - Inserir na primeira posição.\n"
					+ "2 - Inserir na última posição.\n"
					+ "3 - Inserir em qualquer posição.\n"
					+ "4 - Imprimir lista de funcionários.\n"
					+ "5 - Tamanho da lista.\n"
					+ "0 - Sair.\n")); //precisa fazer a busca e a ordenação
			switch (opcaoMenu) {
			case 1:
				lista.adicionaPrimeiro(Double.parseDouble(JOptionPane.showInputDialog(":")));
				break;
			case 2:
				lista.adicionaUltimo(Double.parseDouble(JOptionPane.showInputDialog("Inserir na Ãºltima posiÃ§Ã£o:")));
				break;
			case 3:
				int posicao = 0;
				do {
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posiÃ§Ã£o que vocÃª deseja inserir o item: "));
				} while (posicao < 1);
				double conteudo = Double.parseDouble(JOptionPane.showInputDialog("ConteÃºdo: "));
				lista.adicionaPosicao(conteudo, posicao);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, lista.imprimirLista());
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Quantidade de itens na lista:\n" 
			+ lista.getQtdNo());
				break;
			case 0:
				//FIM
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		} while (opcaoMenu != 0);
		
	}
}
