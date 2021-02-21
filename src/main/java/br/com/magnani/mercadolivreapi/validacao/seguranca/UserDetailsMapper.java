package br.com.magnani.mercadolivreapi.validacao.seguranca;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsMapper {

	UserDetails map(Object shouldBeASystemUser);
}
