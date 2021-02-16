package br.com.magnani.mercadolivreapi.cadastrausuario;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraUsuarioController {
	
	@PersistenceContext //usado especificamente quando precisamos injetar um EntityManager
	private EntityManager manager;//para gravar os dados no banco de dados

	@PostMapping(value="/usuarios")
	@Transactional //gera transacao no banco de dados
	public String cria(@RequestBody @Valid NovoUsuarioRequest request) {//converte o que recebeu no Json em usuario
		Usuario novoUsuario = request.toUsuario();
		manager.persist(novoUsuario);//insere no banco de dados
		return novoUsuario.toString();
	}
}
