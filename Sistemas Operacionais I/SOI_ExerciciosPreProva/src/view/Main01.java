//	Considerando o esquema de escalonamento n�o preemptivo chamado FCFS, fa�a uma 
// simula��o de execu��o de processos, em Java com Threads e Sem�foros, considerando 
// que 20 processos foram carregados na mem�ria, cada um deles pode durar de 4 a 120 
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
