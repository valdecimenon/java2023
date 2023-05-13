package padrao;

// java bean
public class Produto  {

	private String nome;
	private float valor;

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
	
}
