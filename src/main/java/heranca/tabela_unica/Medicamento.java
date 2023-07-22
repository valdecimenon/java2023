package heranca.tabela_unica;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@DiscriminatorValue("M")
public class Medicamento extends Produto {

	private Integer quantidade;
	private Tarja tarja;
	private Date vencimento;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Enumerated(EnumType.STRING)
	public Tarja getTarja() {
		return tarja;
	}

	public void setTarja(Tarja tarja) {
		this.tarja = tarja;
	}

	@Temporal(TemporalType.DATE)
	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

}
