package jpql.paginacao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpql.native_query.Funcionario;
import util.JpaUtil;

public class ConsultaComPaginacao {
	
	public static void main(String[] args) {
		int inicio = 0;
		final int TAMANHO_PAGINA = 5;
		
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<Funcionario> query = em.createQuery("from tbl_funcionarios", Funcionario.class);
		// posição do primeiro registro
		query.setFirstResult(inicio);  
		// número máximo de registro para retornar
		query.setMaxResults(TAMANHO_PAGINA);
		
		// mostra primeira página
		// retorna apenas o 5 primeiros funcionários
		System.out.println("===== PÁGINA 1 =====");
		query.getResultList().forEach(System.out::println);
		
		// segunda página
		// retorna os próximos 5 registros
		inicio += TAMANHO_PAGINA;
		query.setFirstResult(inicio);
		query.setMaxResults(TAMANHO_PAGINA);
		System.out.println("===== PÁGINA 2 =====");
		query.getResultList().forEach(System.out::println);
			
		em.close();
		JpaUtil.close();
	}

}
