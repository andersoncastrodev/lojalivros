package br.com.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.domian.Categoria;

public class CategoriaDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Campo nome é obrigatorio")
	@Length(min = 3 , max = 100, message = "O campo nome tem que ter 3 a 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo descricao é obrigatorio")
	@Length(min = 3 , max = 200, message = "O campo descricao tem que ter 3 a 200 caracteres")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
