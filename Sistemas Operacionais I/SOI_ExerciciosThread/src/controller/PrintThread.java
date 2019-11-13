package controller;

public class PrintThread extends Thread {
	private int n;

	public PrintThread(int n) {
		this.n = n;
	}

	public void run() { 
		print();
		super.run(); 
	}

	public void print() {
		System.out.println("Thread " + n);
	}
}