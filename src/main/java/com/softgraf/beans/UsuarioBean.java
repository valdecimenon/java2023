package com.softgraf.beans;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class UsuarioBean implements Serializable {

	private String nome;
	//somente a partir do JSF 2.3
	@Inject
	private Flash flash;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String enviar() {
		return "pag2";
	}
	
	public String redirecionar() {
		return "pag2?faces-redirect=true";
	}
	
	public String redirecionarFlash() {
		// até JSF 2.2 é obrigatório instanciar o flash desta forma
		// Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		// salva  o parâmetro nome na variável do flash
		flash.put("nomeUsuario", nome);  
		return "pag2?faces-redirect=true";
	}
	
}
