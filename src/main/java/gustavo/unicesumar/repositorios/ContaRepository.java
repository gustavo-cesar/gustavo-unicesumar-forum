package gustavo.unicesumar.repositorios;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gustavo.unicesumar.entidades.Conta;

public interface ContaRepository extends JpaRepository<Conta, String>{
	
	@Query(value = "SELECT CT.SALDO_CONTA FROM CONTA AS CT " + 
			"JOIN AGENCIA AS AG ON AG.ID = CT.AGENCIA_ID " + 
			"JOIN BANCO AS BC ON BC.ID = AG.BANCO_ID " + 
			"WHERE BC.CODIGO = :codigoBanco ", nativeQuery = true)
    List<BigDecimal> obterSaldoContasPorBanco(@Param(value = "codigoBanco") String codigoBanco);
	
}	
