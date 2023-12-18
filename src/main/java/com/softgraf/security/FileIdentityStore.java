package com.softgraf.security;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped   // CDI contexto de aplicação
public class FileIdentityStore implements IdentityStore {

	private Properties props;
	
	@PostConstruct
	public void init() {
		props = new Properties();
		
		try {
			props.load(getClass().getResourceAsStream("/com/softgraf/security/usuarios.properties"));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private boolean isUsuarioValido(String nomeUsuario, String senha) {
		String senhaProp = props.getProperty("senha_" + nomeUsuario);
		return senha.equals(senhaProp);
	}
	
	private Set<String> grupos(String nomeUsuario){
		String grupos = props.getProperty("roles_" + nomeUsuario);
		
		if (grupos == null) {
			return null;
		}
		
		// "admin,user" -> ["admin" "user"]
		return Stream.of(grupos.split(",")).collect(Collectors.toSet());
	}
	
	@Override
	public CredentialValidationResult validate(Credential credential) {
		UsernamePasswordCredential user = (UsernamePasswordCredential) credential; 
		
		String nomeUsuario = user.getCaller();
		String senha = user.getPasswordAsString();
		
		if (!isUsuarioValido(nomeUsuario, senha)) {
			return CredentialValidationResult.INVALID_RESULT;
		}
		
		Set<String> grupos = grupos(nomeUsuario);
		return new CredentialValidationResult(nomeUsuario, grupos);
	}
	
}
