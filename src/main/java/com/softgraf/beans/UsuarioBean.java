package com.softgraf.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 8238094047827582509L;

	private String nome;
	private LocalDateTime dataLogin;

	public boolean isLogado() {
		return nome != null;
	}
	
	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataLogin() {
		return dataLogin;
	}

	public void setDataLogin(LocalDateTime dataLogin) {
		this.dataLogin = dataLogin;
	}

}
