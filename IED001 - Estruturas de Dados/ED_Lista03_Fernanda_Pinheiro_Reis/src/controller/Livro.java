package controller;

public class Livro<T> {
	private T titulo;
	private T isbn;
	private T exemplares;

	public Livro() {
		super();
	}
	public Livro(T titulo, T isbn, T exemplares) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.exemplares = exemplares;
		
	}


	public T getTitulo() {
		return titulo;
	}
	public void setTitulo(T titulo) {
		this.titulo = titulo;
	}
	public T getIsbn() {
		return isbn;
	}
	public void setIsbn(T isbn) {
		this.isbn = isbn;
	}
	public T getExemplares() {
		return exemplares;
	}
	public void setExemplares(T exemplares) {
		this.exemplares = exemplares;
	}
	
	
	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", isbn=" + isbn + "]\n";
	}



}