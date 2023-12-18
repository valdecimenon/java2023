package com.softgraf.security;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("nav")
@ApplicationScoped
public class NavegacaoBean implements Serializable {

	private static final long serialVersionUID = -5065536996806329483L;
	
	private String path;
	private String pathAdmin;
	private String pathUser;
		
	@PostConstruct
	private void init() {
		path = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
		pathAdmin = path + "/admin";
		pathUser = path + "/user";
	}	
	
	public String getHome() {
		return path + "/index.xhtml"; 
	}
	
	public String getCadastraEditora() {
		return pathAdmin + "/cadastraEditora.xhtml"; 
	}

	public String getCadastraLivro() {
		return pathAdmin + "/cadastraLivro.xhtml"; 
	}
	
	public String getConsultaEditoras() {
		return pathUser + "/consultaEditoras.xhtml"; 
	}
	
	public String getConsultaLivros() {
		return pathUser + "/consultaLivros.xhtml"; 
	}
		
	public String getVendas() {
		return pathUser + "/vendas.xhtml"; 
	}
	
	// chama servlet
	public String getLogout() {
		return path + "/logout"; 
	}	
}
