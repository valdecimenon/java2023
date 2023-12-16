package com.softgraf.service;

import java.util.List;

import com.softgraf.entity.Editora;
import com.softgraf.entity.Livro;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class LivrariaService {

	@PersistenceContext
	private EntityManager em;
	
	public void persist(Object entidade) {
		em.persist(entidade);
	}
	
	public void update(Object entidade) {
		em.merge(entidade);
	}
	
	public Livro findLivroById(Long id) {
		return em.find(Livro.class, id);
	}
	
	public Editora findEditoraById(Long id) {
		return em.find(Editora.class, id);
	}
	
	public List<Editora> todasEditoras(){
		return em.createQuery("select e from Editora e", Editora.class).getResultList();
	}
	
	public List<Livro> todosLivros(){
		return em.createQuery("select l from Livro l", Livro.class).getResultList();
	}
	
	public void removeLivroById(Long id) {
		Livro livro = em.find(Livro.class, id);
		Editora editora = livro.getEditora();
		if (editora != null) {
			editora.getLivros().remove(livro);
		}
		livro.setEditora(null);
		em.remove(livro);
	}
	
	public void removeEditoraById(Long id) {
		Editora editora = em.find(Editora.class, id);
		editora.getLivros().forEach(livro -> livro.setEditora(null));
		editora.setLivros(null);
		em.remove(editora);
	}
	
}
