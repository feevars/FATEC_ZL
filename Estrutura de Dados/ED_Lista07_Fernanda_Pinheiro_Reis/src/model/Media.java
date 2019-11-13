package model;

public class Media {
	private int idAluno, idDisciplina;
	private double mediaFinal;
	
	public Media(int idAluno, int idDisciplina, double mediaFinal) {
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
		this.mediaFinal = mediaFinal;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	@Override
	public String toString() {
		return "Média\n[ID do Aluno: " + idAluno + " | ID da Disciplina: " + idDisciplina + " | Média final: " + mediaFinal + "]";
	}
	
}
