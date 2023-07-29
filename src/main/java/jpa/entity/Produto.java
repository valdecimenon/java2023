package jpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = -3423457319940960291L;
	private Integer id;
	private String nome;
	private BigDecimal preco;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

	// getters e setters
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank(message = "faltou nome do produto")
	@Size(min=4, max=45)
	@Column(length = 45, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "faltou preço do produto")
	@DecimalMin(value = "0.00", message = "Produto abaixo do preço mínimo")
	@DecimalMax(value = "99999", message = "Produto acima do preço máximo")
	// 12345.12
	@Column(nullable = false, precision=5, scale=2)
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat(".##");
		String strPreco = df.format(preco);
		return String.format("Produto id: %-5d nome: %-15s preço: R$ %s", id, nome, strPreco);
	}
	

}
