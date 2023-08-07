package chave_composta.idclass;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = -4693653332463261459L;

	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
