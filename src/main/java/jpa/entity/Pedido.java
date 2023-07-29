package jpa.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 2028528975301111582L;
	private Integer id;
	private Date data;
	private Cliente cliente;
	private List<Item> itens;
	
	public Pedido() {

	}


	// ctrl 3 gcuf
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.data = new Date();
		this.itens = new ArrayList<>();
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="pedido")
	public List<Item> getItens() {
		return itens;
	}
	
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cliente, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id);
	}
	

	@Override
	public String toString() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String strData = formatador.format(data);
		return String.format("Pedido id: %-5d data: %s\n", id, strData);	
	}
	
	
	
	
	

}
