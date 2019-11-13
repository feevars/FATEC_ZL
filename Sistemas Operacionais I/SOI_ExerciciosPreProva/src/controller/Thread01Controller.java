//	Considerando o esquema de escalonamento não preemptivo chamado FCFS, faça uma 
// simulação de execução de processos, em Java com Threads e Semáforos, considerando 
// que 20 processos foram carregados na memória, cada um deles pode durar de 4 a 120 
// segundos para rodar.

package controller;

import java.util.concurrent.Semaphore;

public class Thread01Controller extends Thread {
	private int idProcessos;
	private Semaphore semaforo;
	private int dormir = (int)(Math.random() * 10000)/1000;
	
	
	public Thread01Controller (int idProcessos, Semaphore semaforo) {
		this.idProcessos = idProcessos;
		this.semaforo = semaforo;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			iniciaProcesso();
			conta();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizaProcesso();
			semaforo.release();
		}
	}
	
	private void iniciaProcesso() {
		System.out.println("O processo " + idProcessos + " vai dormir por " +dormir +" segundos." );
	}

	private void conta() {

		for(int i = dormir; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void finalizaProcesso() {
		System.out.println("O processo " + idProcessos + " parou.");
	}
}
