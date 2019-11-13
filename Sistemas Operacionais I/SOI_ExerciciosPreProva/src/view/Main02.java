//	Considerando o esquema de escalonamento não preemptivo chamado SJF (shortest job first), 
// faça uma simulação de execução de processos, em Java com Threads e Semáforos, considerando 
// que 20 processos foram carregados na memória, cada um deles pode durar de 4 a 120 
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
