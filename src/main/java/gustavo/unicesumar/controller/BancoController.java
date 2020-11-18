package gustavo.unicesumar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gustavo.unicesumar.entidades.Banco;
import gustavo.unicesumar.repositorios.BancoRepository;


@RestController
@RequestMapping("/api/banco")
public class BancoController extends BaseController<Banco, BancoRepository>{

}
