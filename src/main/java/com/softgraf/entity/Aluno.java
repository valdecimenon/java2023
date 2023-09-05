package com.softgraf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = -3757430150393789994L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 60)
	private String nome;
	
	@Column(length = 60)
	private String email;
	
	// construtor padrão
	public Aluno() {
	
	}

	// construtor com parâmetros
	public Aluno(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// alt shift s generate toString
	@Override
	public String toString() {
		return String.format("Aluno [id=%s, nome=%s, email=%s]", id, nome, email);
	}	
}
