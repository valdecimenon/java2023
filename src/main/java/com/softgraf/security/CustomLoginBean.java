package com.softgraf.security;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Named("loginBean")
@RequestScoped
public class CustomLoginBean implements Serializable {

	private static final long serialVersionUID = -8711262786348578715L;
	private String nomeUsuario;
	private String senha;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private ExternalContext externalContext;
	
	public String login() {
		UsernamePasswordCredential credencial = new UsernamePasswordCredential(nomeUsuario, senha);
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
		AuthenticationParameters authParams = AuthenticationParameters.withParams().credential(credencial);
		AuthenticationStatus status = securityContext.authenticate(request, response, authParams);
		
		if (status == AuthenticationStatus.SUCCESS) {
			return "index?faces-redirect=true";
		}
		
		return null;
	}
	
	// getters e setters
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}
}
