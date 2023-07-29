package jpa_aula01;

import jakarta.persistence.EntityManager;
import jpa.entity.Cliente;
import util.JpaUtil;

public class BuscandoPorId {

	public static void main(String[] args) {
	
		EntityManager em = JpaUtil.getEntityManager();
		
		Integer id = 1;
		Cliente cliente = em.find(Cliente.class, id);
		
		System.out.println(cliente);
		
		em.close();
		JpaUtil.close();
		

	}

}
