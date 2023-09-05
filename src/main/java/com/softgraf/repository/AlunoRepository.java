package com.softgraf.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.softgraf.entity.Aluno;

public class AlunoRepository {
	
	private EntityManager em;

	public AlunoRepository(EntityManager em) {
		this.em = em;
	}
	
	public void persistir(Aluno aluno) {
		// é necessário uma transação para alterar dados no banco
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(aluno);
		tx.commit();
	}
	
	public Aluno buscarPorNome(String nome) {
		nome = "%" + nome + "%";
		String jpql = "select a from Aluno a where a.nome like ?1";
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		List<Aluno> lista = query.setParameter(1, nome).getResultList();
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	
	

}
