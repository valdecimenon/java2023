package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf;
		
	// inicializador estático da classe
	static {
		// carrega persistence.xml
		emf = Persistence.createEntityManagerFactory("jpa_pu");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
}
