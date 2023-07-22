package login;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoLogin {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		// inicia transação
		tx.begin();
		
		// objetos não gerenciados: estado NEW
		Login rafael = new Login("Rafael", "123");
		Login gabriel = new Login("Gabriel", "456");
		Login ariel = new Login("Ariel", "789");
		
		// estado GERENCIADO
		em.persist(rafael);
		em.persist(gabriel);
		em.persist(ariel);
		
		// termina transação
		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
