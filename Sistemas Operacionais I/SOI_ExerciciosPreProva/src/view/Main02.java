//	Considerando o esquema de escalonamento n�o preemptivo chamado SJF (shortest job first), 
// fa�a uma simula��o de execu��o de processos, em Java com Threads e Sem�foros, considerando 
// que 20 processos foram carregados na mem�ria, cada um deles pode durar de 4 a 120 
// segundos para rodar.

package view;

import java.util.concurrent.Semaphore;

import controller.Thread02Controller;

public class Main02 {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		int recursos = (int) (Math.random()*10000);
		int [] fila = new int [5];
		
		
		for (int i = 1; i <= 5; i++) {
			Thread02Controller t = new Thread02Controller(i, semaforo, recursos);
			t.start();
		}

	}

}
