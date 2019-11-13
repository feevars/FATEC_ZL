//	Considerando o esquema de escalonamento não preemptivo chamado FCFS, faça uma 
// simulação de execução de processos, em Java com Threads e Semáforos, considerando 
// que 20 processos foram carregados na memória, cada um deles pode durar de 4 a 120 
// segundos para rodar.

package view;

import java.util.concurrent.Semaphore;

import controller.Thread01Controller;

public class Main01 {

	public static void main(String[] args) {
		int permissao = 1;
        Semaphore semaforo = new Semaphore(permissao);
        
        
		for (int i = 0; i<20; i++) {
			Thread01Controller thread = new Thread01Controller(i, semaforo);
			thread.start();
		}

	}

}
