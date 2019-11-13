package teste.view;

import javax.swing.JOptionPane;

import controller.Fila;
import controller.Livro;
import controller.Pilha;

public class MainLivros {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {



		// int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de elementos que deseja adicionar: "));
		int tamanho = 3;
		
		Pilha<Livro> pilha = new Pilha <Livro>(tamanho);
		Fila<Livro> fila = new Fila <Livro>(tamanho);
		Livro [] vetorlivro = new Livro[tamanho];

		//adiciona na fila
//		for (int i = 0; i < tamanho; i++) {
//			vetorlivro[i] = new Livro();
//
//			vetorlivro[i].setTitulo(JOptionPane.showInputDialog("Digite o título do livro " + (i+1) + ": "));
//			vetorlivro[i].setIsbn(JOptionPane.showInputDialog("Digite o Isbn do livro " + (i+1) + ": "));
//			vetorlivro[i].setExemplares(JOptionPane.showInputDialog("Digite o número de exemplares do livro " + (i+1) + ": "));
//			fila.enqueue(vetorlivro[i]);
//		}

		
		//popula automático vetor com 3
			vetorlivro[0] = new Livro();
			vetorlivro[0].setTitulo("Burbúrias de amor");
			vetorlivro[0].setIsbn(24532);
			vetorlivro[0].setExemplares(3);
			fila.enqueue(vetorlivro[0]);
			
			vetorlivro[1] = new Livro();
			vetorlivro[1].setTitulo("Labaxúrias");
			vetorlivro[1].setIsbn(2452);
			vetorlivro[1].setExemplares(10);
			fila.enqueue(vetorlivro[1]);
			
			vetorlivro[2] = new Livro();
			vetorlivro[2].setTitulo("Bloomberg");
			vetorlivro[2].setIsbn(24456);
			vetorlivro[2].setExemplares(1);
			fila.enqueue(vetorlivro[2]);
		
		JOptionPane.showMessageDialog(null, fila);
			
		for (int i = 0; i < tamanho; i++) {
			pilha.push(fila.dequeue());
		}
		for (int i = 0; i < tamanho; i++) {
			fila.enqueue(pilha.pop());
		}
		
		JOptionPane.showMessageDialog(null, fila);

	}

}
