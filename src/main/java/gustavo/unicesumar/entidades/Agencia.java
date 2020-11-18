package gustavo.unicesumar.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Agencia extends BaseEntity{
	
	@NotNull
	@ManyToOne
	private Banco banco;
	@NotNull
	private String numeroAgencia;
	private String descricao;

	
	public Agencia() {}
	public Agencia(Banco banco, String numeroAgencia, String descricao) {
		this.banco = banco;
		this.numeroAgencia = numeroAgencia;
		this.descricao = descricao;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
