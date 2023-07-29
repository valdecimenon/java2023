package jpa_aula01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.entity.Pedido;
import util.JpaUtil;

public class RemovendoPedido1 {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Integer id = 3;
		Pedido pedido = em.find(Pedido.class, id);
		
		try {
			em.remove(pedido);
			System.out.println("\nPedido Removido");
						
		} catch (Exception e) {
			System.out.println("\nPedido não pode ser removido por estar referenciado no cliente");
			e.printStackTrace();
			
			/*
			 * soluções para remover dependências
			 * - remover o cliente - melhor não!
			 * - usar CascadeType.REMOVE em Pedido.getCliente() - melhor não! 
			 * - remove a dependência cliente no pedido - OK
			 */
		}
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
