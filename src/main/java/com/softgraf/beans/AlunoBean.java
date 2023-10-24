package com.softgraf.beans;

import java.io.Serializable;
import java.util.List;

import com.softgraf.entity.Aluno;
import com.softgraf.repository.AlunoRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

// Aluno Managed Bean CDI
@Named("alunoBean")
@RequestScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = -4127314806462434129L;
	
	@Inject
	private AlunoRepository repository;
	
	@PostConstruct
	public void init() {
		System.out.println("\nInicializou AlunoBean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("\nDestruiu AlunoBean");
	}
	
	public List<Aluno> getTodos(){
		return repository.todos();
	}

	public Aluno getPorId(Integer id) {
		return repository.buscaPorId(id);
	}
	


}
