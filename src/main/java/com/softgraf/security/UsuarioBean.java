package com.softgraf.security;

import java.io.Serializable;
import java.security.Principal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("usuario")
@ApplicationScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -2129355863065170496L;
	
	// nome do usuário e role via JSF
	@Inject
	private ExternalContext externalContext;
	
	// nome do usuário via CDI. Retorna "ANONYMOUS" se não logado
	// @Inject Principal principal;
	// principal.getName() 
	
	// nome do usuário via Servlet. Retorna null se não logado
	// @Inject HttpServletRequest request;
	// HttpServletRequest.getUserPrincipal()
    // In role: request.isUserInRole()
	
	public String getNome() {
		Principal principal = externalContext.getUserPrincipal();
		return principal == null ? "" : principal.getName();
	}

	public boolean isAdmin() {
		return externalContext.isUserInRole("admin");
	}

	public boolean isLogado() {
		return !getNome().isEmpty();
	}
}
