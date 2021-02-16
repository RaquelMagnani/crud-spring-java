package br.com.magnani.mercadolivreapi.cadastrausuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoValidator implements Validator{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return NovoUsuarioRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if (errors.hasErrors()) {
			return;
		}

		NovoUsuarioRequest request = (NovoUsuarioRequest) target;

		Optional<Usuario> possivelUsuario = usuarioRepository.findByEmail(request.getEmail());
		
		
		if(possivelUsuario.isPresent()) {
			errors.rejectValue("email",null, "ja existe este email no sistema");
		}
	}

}
