package com.softgraf.agenda.beans;



public class Contato {

	private Long id;      
	private String nome; 
	private String fone; 


	public Contato() {	}

	public Contato(String nome, String fone) {
		this(null, nome, fone);
	}
	
	public Contato(Long id, String nome, String fone) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
