package heranca.propriedades;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/*
 * Herança de propriedades da superclasse: isso não é uma estratégia de herança
 * Anotação usada para compartilhar propriedades através de uma superclasse,
 * mas sem considerá-la como entidade mapeada
 */
@MappedSuperclass
abstract public class Produto implements Serializable {

	private static final long serialVersionUID = -1884575384719513881L;
	private Long id;
	private String descricao;
	private Unidade unidade;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 100)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated(EnumType.STRING)
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}
