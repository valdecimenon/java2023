package com.softgraf.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioRepository {

	private EntityManager em;

	public UsuarioRepository(EntityManager em) {
		this.em = em;
	}
	
	public boolean autenticar(String nome, String senha) {
		String jpql = "select count(u) = 1 from Usuario u where u.nome = ?1 and u.senha = ?2";
		TypedQuery<Boolean> query = em.createQuery(jpql, Boolean.class);
		query.setParameter(1, nome);
		query.setParameter(2, senha);
		return query.getSingleResult();
	}
	
	
}
