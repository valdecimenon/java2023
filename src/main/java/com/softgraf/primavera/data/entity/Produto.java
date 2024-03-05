package com.softgraf.primavera.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.ToString;

// Anotações LOMBOK

@EqualsAndHashCode(of = { "id", "descricao" })
@ToString
// @Data: junção das anotações: @Getter, @Setter, @EqualsAndHashCode e @ToString

// Anotações JPA
@Table(name = "produtos")
@Entity(name = "Produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 2809172229470021949L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Descrição do produto é obrigatório") // bean validation
	@Column(length = 60, nullable = false)
	private String descricao;

	@DecimalMin(value = "0.0", inclusive = false, message = "Preço abaixo do mínimo")
	@DecimalMax(value = "9999.0", message = "Preço acima do máximo")
	@Column(nullable = false)
	private Double preco;

	@NotNull(message = "Quantidade é obrigatória")
	@Min(1)
	@Max(9999)
	@Column(nullable = false)
	private Integer quantidade;

	@Column(length = 255)
	private String url;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String descricao, Double preco, Integer quantidade) {
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Produto(Long id, String descricao, Double preco, Integer quantidade) {
		this(descricao, preco, quantidade);
		this.id = id;
	}

	public Produto(String descricao, Double preco, Integer quantidade, String url) {
		this(descricao, preco, quantidade);
		this.url = url;
	}

}
