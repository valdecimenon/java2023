package jpql.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoFamoso {

	public static void main(String[] args) {
		Famoso ellon = new Famoso("Ellon Musk","Estados Unidos", "Empresário");
		Famoso bill = new Famoso("Bill Gates","Estados Unidos", "Empresário");
		Famoso gomes = new Famoso("Manoel","Brasil", "Cantor");
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		em.persist(ellon);
		em.persist(bill);
		em.persist(gomes);
		
		tx.commit();
		JpaUtil.close();

	}

}
