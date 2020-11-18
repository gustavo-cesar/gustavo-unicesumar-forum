package gustavo.unicesumar.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import gustavo.unicesumar.entidades.Banco;

public interface BancoRepository extends JpaRepository<Banco, String>{

}
