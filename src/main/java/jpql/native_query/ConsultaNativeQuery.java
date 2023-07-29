package jpql.native_query;

import java.util.List;

import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class ConsultaNativeQuery {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		// criando uma string de consulta (não pode usar "from Funcionario", por ser consulta nativa
		List<?> todos = em.createNativeQuery("select * from tbl_funcionarios", Funcionario.class).getResultList();
		todos.forEach(System.out::println);
		
		// para evitar o uso de string, usamos NamedNativeQueries
		System.out.println("-----------------------------------");
		em.createNamedQuery(Funcionario.ORDENAR_POR_NOME, Funcionario.class)
				.getResultList().forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		em.createNamedQuery(Funcionario.ORDENAR_POR_SALARIO, Funcionario.class)
		.getResultList().forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		em.createNamedQuery(Funcionario.LISTAR_CIDADES)
		.getResultList().forEach(System.out::println);
		
		
		// retorna a média salarial
		Object total = em.createNativeQuery("select avg(salario) from tbl_funcionarios").getSingleResult();
		
		System.out.println("\n===== Média salarial R$ " + total);
		
		
		em.close();
		JpaUtil.close();
	}

}
