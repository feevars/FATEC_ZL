package view;

import java.io.IOException;

import controller.ContArquivos;
import controller.IContArquivos;

public class Principal {

	public static void main(String[] args) {
		IContArquivos contArquivos = new ContArquivos(); // vai chamar a interface que j� est� implementada nessa classe
		String pathWin = "c:";
		try {
			contArquivos.leDir(pathWin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

