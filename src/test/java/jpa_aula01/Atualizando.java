package jpa_aula01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.entity.Cliente;
import jpa.entity.Endereco;
import util.JpaUtil;

public class Atualizando {

	public static void main(String[] args) {
		// salvar();
		atualizar();
	}
	
	private static void salvar() {
		Endereco rua = new Endereco("Av. Vicente Machado, 001", "Curitiba", "PR");
		Cliente luiz = new Cliente("Luiz Carlos");
		luiz.setEndereco(rua);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(luiz);
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}
	
	private static void atualizar() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// recupera o cliente Luiz pelo id
		Integer id = 9;
		Cliente cliente = em.find(Cliente.class, id);
		
		// atualiza o nome
		cliente.setNome("Luiz Carlos de Oliveiroa");
				
		// atualiza o endereço
		cliente.getEndereco().setRua("Rua Balduino Taques, 77");
		cliente.getEndereco().setCidade("Ponta Grossa");
		
		// finalmente sincroniza com o banco de dados
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
