package jpql.named_query;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpql.modelo.Famoso;
import util.JpaUtil;

public class ConsultaNamedQuery {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		List<Famoso> todos = em.createNamedQuery(Famoso.LISTAR_TODOS, Famoso.class).getResultList();
		
		System.out.println("\n=== Todos os famosos");
		todos.forEach(f -> System.out.println(f.getNome()));
		
		
		List<Famoso> americanos = em.createNamedQuery(Famoso.LISTAR_AMERICANOS, Famoso.class).getResultList();
		
		System.out.println("\n=== Somente americanos");
		americanos.forEach(f -> System.out.println(f.getNome()));
		
		List<Famoso> cantores = em.createNamedQuery(Famoso.LISTAR_CANTORES, Famoso.class).getResultList();
		
		System.out.println("\n=== Somente cantores top");
		cantores.forEach(f -> System.out.println(f.getNome()));
		
		em.close();
		JpaUtil.close();
	}

}
