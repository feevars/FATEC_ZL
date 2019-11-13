/*
 Fazer uma aplicação que insira números aleatórios em uma matriz 3x5 e 
 tenha 3 Threads, onde cada Thread calcula a soma dos valores de cada 
 linha, imprimindo a identificação da linha e o resultado da soma.
 */

package view;
import controller.MatrizThread;

/*
 * @author Fernanda
 */
public class MainMatriz {
	public static void main(String[] args) {
		int n = 0;
		for (int seq = 0; seq<3; seq++) {
			n = ((int)((Math.random()*3)));
			MatrizThread matriz = new MatrizThread(n);
			matriz.start();
		}
	}

}
