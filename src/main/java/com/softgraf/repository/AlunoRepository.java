package com.softgraf.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.softgraf.entity.Aluno;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;


/*
 * Um repositório representa uma coleção de objetos de um tipo específico.
 * É um mediador entre a camada de negócios e o acesso a dados.
 * Deve fornecer métodos para adicionar, remover, atualizar, buscar.
 */
@Named // é bean CDI
public class AlunoRepository implements Serializable {

	private static final long serialVersionUID = -1899748236864993140L;
	private EntityManager em;
	
	// bean CDI precisa de um construtor padrão
	public AlunoRepository() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	public AlunoRepository(EntityManager em) {
		this.em = em;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("\nInicializou bean AlunoRepository...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("\nDestruiu bean AlunoRepository....");
	}
	
	public void adicionar(Aluno aluno) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(aluno);
		tx.commit();
	}
	
	public List<Aluno> todos(){
		TypedQuery<Aluno> query = em.createQuery("select a from Aluno a", Aluno.class);
		return query.getResultList();
	}

	public void removePorId(int id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Aluno aluno = em.find(Aluno.class, id);
		em.remove(aluno);
		tx.commit();
	}
	
	public Aluno buscaPorId(Integer id) {
		return em.find(Aluno.class, id);
	}

	
	
}
