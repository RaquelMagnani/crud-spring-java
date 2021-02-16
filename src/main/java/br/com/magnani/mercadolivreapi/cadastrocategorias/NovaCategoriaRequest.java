package br.com.magnani.mercadolivreapi.cadastrocategorias;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import br.com.magnani.mercadolivreapi.validacao.ExistsId;
import br.com.magnani.mercadolivreapi.validacao.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(domainClass=Categoria.class,fieldName="nome")
	private String nome;
	
	@Positive
	@ExistsId(domainClass = Categoria.class,fieldName="id")
	private Long idCategoriaMae;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdCategoriaMae(Long idCategoriaMae) {
		this.idCategoriaMae = idCategoriaMae;
	}
	
	@Override
	public String toString() {
		return "NovaCategoriaRequest [nome = " + nome + "idCategoriaMae =" +
	idCategoriaMae + " ]";
	}
	public Categoria toModel(EntityManager manager) {
		Categoria categoria = new Categoria(nome);
		if(idCategoriaMae != null) {
			Categoria categoriaMae = manager.find(Categoria.class,idCategoriaMae);
			Assert.notNull(categoriaMae,"id da categoria mae precisa ser valido");
			
			categoria.setMae(categoriaMae);
		}
		return categoria;
	}
	
}
