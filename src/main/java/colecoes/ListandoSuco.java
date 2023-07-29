package colecoes;

import java.util.List;

import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class ListandoSuco {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		List<Suco> sucos = em.createQuery("from Suco", Suco.class).getResultList();
		
		sucos.forEach(s -> {
			System.out.println("\n=== Marca: " + s.getMarca());
			s.getSabores().forEach(System.out::println);
		});

	}

}
