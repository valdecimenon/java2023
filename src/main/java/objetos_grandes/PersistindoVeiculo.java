package objetos_grandes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class PersistindoVeiculo {

	public static void main(String[] args) throws IOException {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Veiculo v = new Veiculo();
		v.setMarca("VW");
		v.setModelo("Polo");

		v.setDescricao(
				"""
			Mussum Ipsum, cacilds vidis litro abertis.  A ordem dos tratores não altera o pão duris. Per aumento de cachacis, eu reclamis. Detraxit consequat et quo num tendi nada. Casamentiss faiz malandris se pirulitá.

			Detraxit consequat et quo num tendi nada. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per. Manduma pindureta quium dia nois paga. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis.
			
			Suco de cevadiss deixa as pessoas mais interessantis. Sapien in monti palavris qui num significa nadis i pareci latim. Interessantiss quisso pudia ce receita de bolis, mais bolis eu num gostis. Pra lá, depois divoltis porris, paradis.
			
			Quem num gosta di mim que vai caçá sua turmis! Si num tem leite então bota uma pinga aí cumpadi! Suco de cevadiss deixa as pessoas mais interessantis. Diuretics paradis num copo é motivis de denguis.
			
			Manduma pindureta quium dia nois paga. Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. Viva Forevis aptent taciti sociosqu ad litora torquent. Cevadis im ampola pa arma uma pindureta.
			
			Paisis, filhis, espiritis santis. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis. Quem num gosta di mé, boa gentis num é. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis.
			 	""");
		
		// pacote: java.nio.file.Path; 
		Path path = FileSystems.getDefault().getPath("d:/veiculo.png");
		byte[] foto = Files.readAllBytes(path);
		v.setFoto(foto);
		
		System.out.println("\nSalvando veiculo");
		em.persist(v);

		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
