package colecoes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Suco implements Serializable {

	private static final long serialVersionUID = 462583944597765420L;

	private Integer id;
	private String marca;
	private List<String> sabores;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 45)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@ElementCollection
	@Column(length = 20)
	public List<String> getSabores() {
		return sabores;
	}

	public void setSabores(List<String> sabores) {
		this.sabores = sabores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suco other = (Suco) obj;
		return Objects.equals(id, other.id) && Objects.equals(marca, other.marca);
	}
}
