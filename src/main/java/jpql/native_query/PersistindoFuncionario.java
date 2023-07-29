package jpql.native_query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoFuncionario {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Gilberto Amaral", 9300.0, "Ponta Grossa");
		Funcionario f2 = new Funcionario("Felizberto Alberto", 4500.0, "Castro");
		Funcionario f3 = new Funcionario("Anamaria Mariana", 2700.0, "Carambei");
		Funcionario f4 = new Funcionario("Ana Luiza", 3500.0, "Curitiba");
		Funcionario f5 = new Funcionario("Luiz Cezar", 3200.0, "Palmeira");
		Funcionario f6 = new Funcionario("Rafael Silva", 3900.0, "Imbituva");
		Funcionario f7 = new Funcionario("Janiel Souza", 1500.0, "Ipiranga");
		Funcionario f8 = new Funcionario("Carlos Amaral", 2800.0, "Londrina");
		Funcionario f9 = new Funcionario("Beatriz Siqueira", 6500.0, "Irati");
		Funcionario f10 = new Funcionario("Aparecida Xavier", 7900.0, "Maringá");
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(f1);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);
		em.persist(f5);
		em.persist(f6);
		em.persist(f7);
		em.persist(f8);
		em.persist(f9);
		em.persist(f10);
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
