package br.com.magnani.mercadolivreapi.cadastrausuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	@NotBlank
	private String email ;
	
	@NotBlank
	@Length(min=6)
	private String senha;
	
	@Deprecated
	public Usuario() {}

	public Usuario(@Email @NotBlank String email, 
			@Valid @NotNull SenhaLimpa senhaLimpa) {
		//usando o assert para garantir as restricoes do seu construtor
		Assert.isTrue(StringUtils.hasLength(email), "Email nao deve ser branco");
		Assert.notNull(senhaLimpa , "o objeto senha limpa nao pode ser nulo");

		this.email = email;
		this.senha = senhaLimpa.hash();
		
	}
	
	@Override
	public String toString() {
		return "Usuario [id= " +id + ", email = "+ email+ ", senha = " + senha + " ]";
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	
}
