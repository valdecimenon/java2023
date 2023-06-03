package com.softgraf.agenda.model;

// java bean
public class Contato {

	private int id;      // 4 bytes
	private String nome; // máximo de 20 caracters = 40 bytes
	private String fone; // máximo de 10 caractere = 20 bytes

	// construtor padrão
	public Contato() {
		// chama o construtor de baixo
		this(1, "", "");
	}
	
	public Contato(int id, String nome, String fone) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
	}
	
	// construtor com 3 parâmetros
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %-5d Nome: %-20s Fone: %s", id, nome, fone);
	}

}
