package gustavo.unicesumar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gustavo.unicesumar.entidades.Agencia;
import gustavo.unicesumar.repositorios.AgenciaRepository;


@RestController
@RequestMapping("/api/agencia")
public class AgenciaController extends BaseController<Agencia, AgenciaRepository>{
	

}
