package controller;

import java.io.File;
import java.io.IOException;

public class ContArquivos implements IContArquivos {

	@Override
	public void leDir(String path) throws IOException {
		File diretorio = new File(path); // só fez o open arquivo, não fez o read
		if (diretorio.exists() && diretorio.isDirectory()) { // se existir e for um diretorio
			File[] arquivos = diretorio.listFiles(); // vou ler e mostrar
					for (File arquivo : arquivos) {
						String nome = "";
						if (arquivo.isDirectory()) {
							nome = nome + "<DIR> ";
							
						}
						nome = nome + arquivo.getName();
						System.out.println(nome);
					
					}
			
		} else {
			throw new IOException ("Diretorio inválido");
			
		}
		
		
	}

	@Override
	public void leArquivo(String path, String nome) throws IOException {
		
		
	}

	@Override
	public void criaArq(String path, String nome) throws IOException {
	
		
	}
	
	

}
