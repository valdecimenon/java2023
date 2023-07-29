package incorporavel;

import java.util.List;

import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class ListandoCliente {

	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		// consulta específica
		List<Cliente> clientes = em.createQuery("from Cliente", Cliente.class).getResultList();
		
		clientes.forEach(c -> {
			System.out.println(c.getId());
			System.out.println(c.getNome());
			
			Endereco e = c.getEndereco();
			System.out.println(e.getRua());
			System.out.println(e.getCidade());
			System.out.println(e.getUf());
		});

	}

}
