package jpql.subconsulta;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpql.modelo.Famoso;
import util.JpaUtil;

public class Subconsulta {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		// busca americanos com nome iniciando por B
		String jpql = "select p from Famoso p where p.nome like 'B%' and exists (select f from Famoso f where f.pais = 'Estados Unidos')";
		
		List<Famoso> lista = em.createQuery(jpql, Famoso.class).getResultList();
		
		if (lista.isEmpty())
			System.out.println("Ninguem encontrado");
		else
			System.out.println(lista.get(0).getNome());
		
		em.close();
		JpaUtil.close();

	}

}
