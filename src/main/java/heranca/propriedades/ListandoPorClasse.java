package heranca.propriedades;

import java.util.List;

import jakarta.persistence.EntityManager;
import util.JpaUtil;

public class ListandoPorClasse {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		// consulta específica
		List<Alimento> medicamentos = em.createQuery("from Alimento", Alimento.class).getResultList();
		medicamentos.forEach(m -> System.out.printf("ID: %-5d Descrição: %-20s\n",
													m.getId(), m.getDescricao()));
		
		// consulta polimórfica
		List<Produto> produtos = em.createQuery("from Produto", Produto.class).getResultList();
		produtos.forEach(p -> System.out.printf("ID: %-5d Descrição: %-20s\n", 
												 p.getId(), p.getDescricao()));
		
		em.close();
		JpaUtil.close();
	}
}