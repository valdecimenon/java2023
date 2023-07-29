package jpa_aula01;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.entity.Pedido;
import util.JpaUtil;

public class ListandoClientes {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		// JPQL = Java Persistence Query Language
		em.createQuery("from Pedido", Pedido.class).getResultList().forEach(System.out::println);

		 
		em.close();
		JpaUtil.close();

	}

}
