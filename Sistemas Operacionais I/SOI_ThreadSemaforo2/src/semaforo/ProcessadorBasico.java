package semaforo;

import java.util.concurrent.Semaphore;

public class ProcessadorBasico {
	
	private static Semaphore semaforo;
	
	private static void processar (int idThread) {
		try {
			System.out.println("Thread #" + idThread + " processando");
			int tempoDormir = (int)(Math.random() * 10000);
			Thread.sleep(tempoDormir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void entrarRegiaoNaoCritica (int idThread) {
		System.out.println("Thread #" + idThread + " em região não critica");
		processar(idThread);
	}
	
	private static void entrarRegiaoCritica (int idThread) {
		System.out.println("Thread #" + idThread
				+ " entrando em região critica");
		processar(idThread);
		System.out.println("Thread #" + idThread + " saindo da região critica");
	}
	
	public static void processamento (int idThread) {
		entrarRegiaoNaoCritica(idThread);
		try {
			semaforo.acquire();
			entrarRegiaoCritica(idThread);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	static Thread t1 = new Thread () {
		public void run() {
			processamento(1);
		}
	};
	
	static Thread t2 = new Thread() {
		public void run() {
			processamento(2);
		}
	};
	
	static Thread t3 = new Thread() {
		public void run() {
			processamento(3);
		}
	};
	
	static Thread t4 = new Thread() {
		public void run() {
			processamento(4);
		}
	};
	
	public static void main (String[] args ) {
		int numeroDePermissoes - 1;
		semaforo = new Semaphore(numeroDePermissoes);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
