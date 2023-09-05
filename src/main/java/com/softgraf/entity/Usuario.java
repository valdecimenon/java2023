package com.softgraf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * create database escola;
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = -9041292040930622683L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 60)
	private String nome;
	
	@Column(length = 255)
	private String senha;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
