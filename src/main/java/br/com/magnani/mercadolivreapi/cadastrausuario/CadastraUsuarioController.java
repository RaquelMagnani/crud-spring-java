package br.com.magnani.mercadolivreapi.cadastrausuario;


import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraUsuarioController {

	@PostMapping(value="/usuarios")
	public void cria(@RequestBody @Valid NovoUsuarioRequest request) {
		
	}
}
