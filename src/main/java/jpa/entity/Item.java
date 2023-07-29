package jpa.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 7303574306867570344L;
	private Integer id;
	private Pedido pedido;
	private Produto produto;
	private Integer quantidade;
	
	public Item() {
	
	}

	// ctrl 3 + gcuf
	public Item(Pedido pedido, Produto produto, Integer quantidade) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	// ctrl 3 + ggas
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
	

	
}
