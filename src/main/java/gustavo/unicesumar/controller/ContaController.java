package gustavo.unicesumar.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gustavo.unicesumar.entidades.Conta;
import gustavo.unicesumar.repositorios.ContaRepository;

@RestController
@RequestMapping("/api/conta")
public class ContaController extends BaseController<Conta, ContaRepository> {
		
	@Autowired
    private ContaRepository contaRepository;

	@PutMapping("/transferir/{idPagador}/{idRecebedor}/{valor}")
	public void put(@PathVariable String idPagador, @PathVariable String idRecebedor, @PathVariable BigDecimal valor) {
		if(idPagador.equals(idRecebedor)) {
			throw new ImpossivelTransferirParaMesmaContaException("Não é possivel transferir, conta do pagador e a conta do recebedor são iguais");
		}
		Optional<Conta> contaPagador = contaRepository.findById(idPagador);
		Optional<Conta> contaRecebedor = contaRepository.findById(idRecebedor);
		
		if(!contaPagador.isPresent() || !contaRecebedor.isPresent()) {
			throw new RegistroDuplicadoException("Entidade não encontrada");
		}
		contaPagador.get().transferir(contaRecebedor.get(), valor);
	}
	
	
	@GetMapping("/media-saldo-por-banco/{codigoBanco}")
	public BigDecimal getMediaSaldoPorBanco(@PathVariable String codigoBanco) {
		List<BigDecimal> saldosBanco = contaRepository.obterSaldoContasPorBanco(codigoBanco);
		
		BigDecimal saldoTotal = new BigDecimal(0.00);
		for (BigDecimal saldo : saldosBanco) {
			saldoTotal = saldoTotal.add(saldo);
		}
		BigDecimal mediaSaldoPorBanco = saldoTotal.divide(new BigDecimal(saldosBanco.size()), RoundingMode.HALF_UP).setScale(2); 
		return mediaSaldoPorBanco;
	}

}
