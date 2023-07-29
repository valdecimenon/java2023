package jpa_aula01;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.entity.Cliente;
import jpa.entity.Endereco;
import jpa.entity.Item;
import jpa.entity.Pedido;
import jpa.entity.Produto;
import util.JpaUtil;

public class Teste {

	public static void main(String[] args) {
		
		Endereco end = new Endereco("XV de Novembro, 123", "Ponta Grossa", "PR");
		Cliente jose = new Cliente("José Seixas");
		jose.setEndereco(end);
		
		Produto bolacha = new Produto("Bolacha Maria", new BigDecimal("3.99"));
		Produto balas = new Produto("Balas Zazá", new BigDecimal("1.99"));
		
		Pedido p1 = new Pedido(jose);
		Item item1 = new Item(p1, bolacha, 10);
		Item item2 = new Item(p1, balas, 20);
		p1.setItens(List.of(item1, item2));
		
		Pedido p2 = new Pedido(jose);
		p2.setItens(List.of(item2));
		
		jose.getPedidos().add(p1);
		jose.getPedidos().add(p2);
		
						
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();    // inicia a transação
		
		em.persist(jose);
		
		
		tx.commit();   // finaliza a transação
		em.close();
		JpaUtil.close();
	}
}
