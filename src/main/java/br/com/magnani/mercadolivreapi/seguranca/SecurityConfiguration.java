package br.com.magnani.mercadolivreapi.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	//configura autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	//configura autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().permitAll();
		
	}
	
	//configura recursos estaticos (js,css,imagens,etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
	
}
