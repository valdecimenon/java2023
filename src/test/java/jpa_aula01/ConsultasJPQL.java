package jpa_aula01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.entity.Cliente;
import jpa.entity.Endereco;
import util.JpaUtil;

public class ConsultasJPQL {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		System.out.println("\n--- Todos os clientes ");
		em.createQuery("from Cliente", Cliente.class).getResultList().forEach(System.out::println);
		
		System.out.println("\nBusca cliente por nome");
		TypedQuery<Cliente> queryPorNome = em.createQuery("from Cliente c where c.nome like '%jos%'", Cliente.class);
		queryPorNome.getResultList().forEach(System.out::println);
		
		// listando todos os endereços dos clientes
		TypedQuery<Endereco> queryEnderecos = em.createQuery("select c.endereco from Cliente c where c.endereco != null", Endereco.class);
		queryEnderecos.getResultList().forEach(System.out::println);
		
		// buscando nome da cidade do cliente José
		TypedQuery<String> queryCidadeJose = em.createQuery("select c.endereco.cidade from Cliente c where c.nome like '%jos%'", String.class);
		queryCidadeJose.getResultList().forEach(System.out::println);
		
		
		em.close();
		JpaUtil.close();
	}

}
