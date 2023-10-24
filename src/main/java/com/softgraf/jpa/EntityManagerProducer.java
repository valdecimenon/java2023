package com.softgraf.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

/*
 * EntityManager não é um bean CDI, por isso não é possível injetá-lo
 * automaticamente. Para solucionar isso usamos um método PRODUTOR do CDI,
 * que gera um objeto para ser injetado.
 */

// Este objeto existirá enquanto a aplicação estiver em execução
@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 2354896344817480547L;
	
	private EntityManagerFactory factory;
	
	// construtor padrão
	public EntityManagerProducer() {
		System.out.println("\n=== Criou EntityManagerFactory");
		this.factory = Persistence.createEntityManagerFactory("jpa_pu");
	}
	
	// cria um entitymanager
	// @Produces: método produto, gera um objeto que pode ser injetado
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		System.out.println("\n=== Criou EntityManager");
		return factory.createEntityManager();
	}
	
	// @Disposes: método finalizador: executado automamticamente quando
	// o escopo onde o objeto foi produzido termina
	// fecha o entitymanager
	public void closeEntityManager(@Disposes EntityManager em) {
		System.out.println("\n=== Fechou EntityManager");
		em.close();
	}
	
	
}
