package com.softgraf.model;

import java.util.Objects;

public class Modelo implements Comparable<Modelo>{

	private String nome;
	private Marca marca;

	public Modelo(String nome, Marca marca) {
		this.nome = nome;
		this.marca = marca;
	}
	
	@Override
	public int compareTo(Modelo modelo) {
		return this.nome.compareTo(modelo.nome);
	}
	
	// getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome);
	}

}
