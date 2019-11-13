package controller;

public class MatrizThread extends Thread {
	private int n;

	public MatrizThread(int n) {
		this.n = n;
	}

	public void run() { 
		print();
		super.run(); 
	}

	
	}
	public void print() {
		//
		//matriz(n, j)
		System.out.println("\n" + n);
	}
}