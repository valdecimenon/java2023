package chave_composta.idclass;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

//@Entity
@IdClass(MatriculaId.class)
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1249977616467130696L;

	@Id
	@Column(name = "id_aluno")
	private Integer idAluno;

	@Id
	@Column(name = "id_turma")
	private Integer idTurma;

	@Column(name = "data_matricula")
	private LocalDate dataMatricula;

	// ggas
	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	@Override
	public String toString() {
		String strData = DataUtil.formatarData(dataMatricula);
		return String.format("Aluno ID: %-7d Turma ID: %-7d Data: %s", idAluno, idTurma, strData);
	}

}
