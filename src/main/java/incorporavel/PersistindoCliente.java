package incorporavel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoCliente {

	public static void main(String[] args) {
		
		Endereco end = new Endereco();
		end.setRua("Rua XV de Novembro, 123");
		end.setCidade("Ponta Grossa");
		end.setUf("PR");
		
		Cliente cliente = new Cliente(); 
		cliente.setNome("Afonso Marais");
		cliente.setEndereco(end);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(cliente);
		
		tx.commit();
		JpaUtil.close();
	}

}
