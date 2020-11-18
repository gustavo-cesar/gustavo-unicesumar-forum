package gustavo.unicesumar.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Conta extends BaseEntity{
	
	@NotNull
	@ManyToOne
	private Agencia agencia;
	@NotNull
	private String numeroConta;
	@NotNull
	private String digitoConta;
	@NotNull
	private BigDecimal saldoConta = new BigDecimal(0.00);
	private String descricao;
	
	public Conta() {}
	public Conta(Agencia agencia, String numeroConta, String digitoConta, String descricao) {
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.digitoConta = digitoConta;
		this.descricao = descricao;
	}
	
	
	public void receber(BigDecimal valor) {
		this.saldoConta = saldoConta.add(valor);
	}
	
	public void transferir(Conta conta, BigDecimal valor){
		if(valor.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("Valor não pode ser negativo");
		}
		conta.receber(valor);
		this.saldoConta.subtract(valor);
	}
	
	public BigDecimal getSaldoConta() {
		return saldoConta;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getDigitoConta() {
		return digitoConta;
	}
	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	

}
