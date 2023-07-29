package heranca.tabela_por_classe_concreta;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Alimento extends Produto {

	private static final long serialVersionUID = -6344523503619505935L;
	private BigDecimal peso;
	private Date vencimento;

	// 123456789.12
	@Column(precision = 10, scale = 2)
	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	@Temporal(TemporalType.DATE)
	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

}
