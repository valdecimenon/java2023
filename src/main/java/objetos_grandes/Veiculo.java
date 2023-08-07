package objetos_grandes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

/*
 * - CLOB - Character Large Object - para arquivos em formato texto
 *   é um tipo do banco de dados usado para armazenar objetos grandes em formato texto.
 *   Para mapear um CLOB usamos a anotação @Lob que pode ser usada para
 *   os tipos: String, char[] e Character[]
 * 
 * - BLOB - Binary Large Object - para arquivos binários, imagens, músicas, etc.
 *   é um tipo do banco de dados para armazenar objetos grandes em formato binário.
 *   Para mapear um BLOB também usamos a anotação @Lob que pode ser usada para os
 *   tipos: byte[] ou Byte[] 
 * 
 */

@Entity
public class Veiculo {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 20)
	private String marca;
	
	@Column(length = 60)
	private String modelo;
	
	// permite armazenar mais de 255 caracteres
	// no mysql será criada uma coluna do tipo TEXT
	@Lob
	private String descricao;
	
	// permite armazenar dados binários
	// no mysql será criada uma coluna do tipo BLOB
	@Lob
	private byte[] foto;
	
	// este campo não será criado no banco
	@Transient
	private String naoSalvo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNaoSalvo() {
		return naoSalvo;
	}

	public void setNaoSalvo(String naoSalvo) {
		this.naoSalvo = naoSalvo;
	}
	
	
}
