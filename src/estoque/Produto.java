package estoque;

import java.util.Objects;

// java bean
public class Produto  {

	private String nome;
	private float valor;

	public Produto() {
	
	}
	
	// ctrl 3 + gcuf
	public Produto(String nome, float valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	
	// ctrl 3 ggas
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s R$ %.2f", nome, valor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, valor);
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
		return Objects.equals(nome, other.nome) && Float.floatToIntBits(valor) == Float.floatToIntBits(other.valor);
	}
}
