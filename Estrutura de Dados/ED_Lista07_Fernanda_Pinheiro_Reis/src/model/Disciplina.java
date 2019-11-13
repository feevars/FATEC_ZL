package model;

public class Disciplina {
	private int id;
	private String nome;
	
	
	public Disciplina(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "[ID: " + id + " | Disciplina: " + nome + "]\n";
	}
	
}
