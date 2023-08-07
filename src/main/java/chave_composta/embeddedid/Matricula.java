package chave_composta.embeddedid;

import java.time.LocalDate;

import chave_composta.idclass.DataUtil;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Matricula  {

	// id embutido ou incorporado dentro da entidade
	@EmbeddedId
	private MatriculaId id;

	@Column(name = "data_matricula")
	private LocalDate dataMatricula;

	public MatriculaId getId() {
		return id;
	}
	
	public void setId(MatriculaId id) {
		this.id = id;
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
		return String.format("Aluno ID: %-7d Turma ID: %-7d Data: %s", id.getIdAluno(), id.getIdTurma(), strData);
	}

}
