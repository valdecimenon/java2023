package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;
		
	static {
		System.out.println("\nCriando EntityManagerFactory...");
		emf = Persistence.createEntityManagerFactory("softgraf_pu");
	}
	
	public static EntityManager getEntityManager() {
		if (em == null) {
			System.out.println("\nCriando EntityManager...");
			em = emf.createEntityManager();
		}
		
		return em;
	}
	
	public static void close() {
		if (em != null) {
			System.out.println("\nFechando EntityManager...");
			em.close();
			em = null;
		}
		
		System.out.println("\nFechando EntityManagerFactory....");
		emf.close();
	}
}
