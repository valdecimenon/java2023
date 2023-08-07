package chave_composta.idclass;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class Persistindo {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Aluno aluno = new Aluno();
		aluno.setNome("Aristides Nogueira");
		
		Turma turma = new Turma();
		turma.setDescricao("Turma de Java");
		
		// persiste primeiro aluno e turma para determinar o id
		em.persist(aluno);
		em.persist(turma);
		
		Matricula matricula = new Matricula();
		matricula.setIdAluno(aluno.getId());
		matricula.setIdTurma(turma.getId());
		matricula.setDataMatricula(LocalDate.of(2023, 8, 5));
		
		em.persist(matricula);
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
