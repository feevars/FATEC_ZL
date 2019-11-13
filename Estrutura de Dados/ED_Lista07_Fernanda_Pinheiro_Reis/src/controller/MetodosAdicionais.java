package controller;

import model.Aluno;
import model.Disciplina;
import model.Media;

public interface MetodosAdicionais {

	public static boolean verificaIdAluno(int id, ListaDupla<Aluno> listaAluno) {
		if(listaAluno.getQtdNo() == 0) return false;
		if (listaAluno.getContador() == null) {
			listaAluno.setContador(listaAluno.getPrimeiro());
			return false;
		} if (listaAluno.getContador().getConteudo().getId() == id){
			listaAluno.setContador(listaAluno.getPrimeiro());
			return true;
		}
		listaAluno.setContador(listaAluno.getContador().getProximo());
		return verificaIdAluno(id, listaAluno);
	}

	public static boolean verificaIdDisciplina(int id, ListaDupla<Disciplina> listaDisciplina) {
		if(listaDisciplina.getQtdNo() == 0) return false;
		if (listaDisciplina.getContador() == null) {
			listaDisciplina.setContador(listaDisciplina.getPrimeiro());
			return false;
		} if (listaDisciplina.getContador().getConteudo().getId() == id){
			listaDisciplina.setContador(listaDisciplina.getPrimeiro());
			return true;
		}
		listaDisciplina.setContador(listaDisciplina.getContador().getProximo());
		return verificaIdDisciplina(id, listaDisciplina);
	}

	public static boolean verificaMediaExistente(int idAluno, int idDisciplina, ListaDupla<Media> listaMedia) {
		if (listaMedia.getContador() == null) {
			listaMedia.setContador(listaMedia.getPrimeiro());
			return false;
		} else if (listaMedia.getContador().getConteudo().getIdAluno() == idAluno 
				&& listaMedia.getContador().getConteudo().getIdDisciplina() == idDisciplina) {
			listaMedia.setContador(listaMedia.getPrimeiro());
			return true;
		}
		listaMedia.setContador(listaMedia.getContador().getProximo());
		return verificaMediaExistente(idAluno, idDisciplina, listaMedia);
	}

	public static Media [] vetorMedias (ListaDupla<Media> listaMedia, Media [] vetorMedia) {

		if (listaMedia.getContador() == listaMedia.getUltimo()) {
			vetorMedia[listaMedia.getContadorInt()] = listaMedia.getUltimo().getConteudo();
			listaMedia.setContador(listaMedia.getPrimeiro());
			listaMedia.setContadorInt(0);
			return vetorMedia; 
		} else {
			vetorMedia[listaMedia.getContadorInt()] = listaMedia.getContador().getConteudo();
			listaMedia.setContador(listaMedia.getContador().getProximo());
			listaMedia.setContadorInt(listaMedia.getContadorInt()+1);
			return vetorMedias(listaMedia, vetorMedia);
		}
	}

	public static void mergeSortMedia(Media [] vetorMedia) {

		if(vetorMedia.length == 1) return;

		int metade = (vetorMedia.length/2);
		Media [] esquerda = new Media [metade];
		Media[] direita = new Media [vetorMedia.length - metade];

		for (int i = 0; i < vetorMedia.length; i++) {
			if (i < metade) esquerda[i] = vetorMedia[i];
			else direita[i-metade] = vetorMedia[i];
		}

		mergeSortMedia(esquerda);
		mergeSortMedia(direita);
		intercalarMedia(esquerda, direita, vetorMedia);

	}

	public static void intercalarMedia(Media[] esquerda, Media[] direita, Media[] resultado) {
		int indiceEsq = 0, indiceDir = 0;

		for (int k = 0; k < resultado.length; k++) {
			if (indiceEsq == esquerda.length) {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			} else if (indiceDir == direita.length) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else if (esquerda[indiceEsq].getMediaFinal() < direita[indiceDir].getMediaFinal()) {
				resultado[k] = esquerda[indiceEsq];
				indiceEsq++;
			} else {
				resultado[k] = direita[indiceDir];
				indiceDir++;
			}
		}

	}
	public static String nomeAlunoPorID(ListaDupla<Aluno> listaAluno, int id) {
		if (listaAluno.getContador() == null) {
			return "ID inexistente";
		} else if (listaAluno.getContador().getConteudo().getId() == id) {
			String nomeID = listaAluno.getContador().getConteudo().getNome();
			listaAluno.setContador(listaAluno.getPrimeiro());
			return nomeID;
		} 
		listaAluno.setContador(listaAluno.getContador().getProximo());
		return nomeAlunoPorID(listaAluno, id);	
	}

	public static String nomeDisciplinaPorID(ListaDupla<Disciplina> listaDisciplina, int id) {
		if (listaDisciplina.getContador() == null) {
			return "ID inexistente";
		} else if (listaDisciplina.getContador().getConteudo().getId() == id) {
			String nomeID = listaDisciplina.getContador().getConteudo().getNome();
			listaDisciplina.setContador(listaDisciplina.getPrimeiro());
			return nomeID;
		} 
		listaDisciplina.setContador(listaDisciplina.getContador().getProximo());
		return nomeDisciplinaPorID(listaDisciplina, id);	
	}

	public static String vetorMediaPrint(Media [] vetorMedia, ListaDupla<Aluno> listaAluno, ListaDupla<Disciplina> listaDisciplina) {
		String printVetor = "Vetor de médias: \n\n";
		for (int i = 0; i < vetorMedia.length; i++) {
			printVetor += "Aluno: " +nomeAlunoPorID(listaAluno, vetorMedia[i].getIdAluno())
			+"\tDisciplina: " +nomeDisciplinaPorID(listaDisciplina, vetorMedia[i].getIdDisciplina())				
			+"\tMédia: "+ vetorMedia[i].getMediaFinal() +"\n" ;
		}
		return printVetor;
	}

	public static String alunosReprovados (Media [] vetorMedia, ListaDupla<Aluno> listaAluno, ListaDupla<Disciplina> listaDisciplina) {
		String reprovados = "Alunos reprovados: \n\n";

		for (int i = 0; i < vetorMedia.length; i++) {
			if (vetorMedia[i].getMediaFinal() < 6) {
				reprovados += "Aluno: " +nomeAlunoPorID(listaAluno, vetorMedia[i].getIdAluno())
				+"\tDisciplina: " +nomeDisciplinaPorID(listaDisciplina, vetorMedia[i].getIdDisciplina())				
				+"\tMédia: "+ vetorMedia[i].getMediaFinal() +"\n" ;
			}
		} 	
		return reprovados;
	}
	
	public static String alunosAprovados (Media [] vetorMedia, ListaDupla<Aluno> listaAluno, ListaDupla<Disciplina> listaDisciplina) {
		String aprovados = "Alunos aprovados: \n\n";

		for (int i = 0; i < vetorMedia.length; i++) {
			if (vetorMedia[i].getMediaFinal() >= 6) {
				aprovados += "Aluno: " +nomeAlunoPorID(listaAluno, vetorMedia[i].getIdAluno())
				+"\tDisciplina: " +nomeDisciplinaPorID(listaDisciplina, vetorMedia[i].getIdDisciplina())				
				+"\tMédia: "+ vetorMedia[i].getMediaFinal() +"\n" ;
			}
		} 	
		return aprovados;
	}
}
