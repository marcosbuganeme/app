package br.com.epinefrina.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "permissao")
public class Permissao extends DomainEncaixeOnline<Long> {

	@Column(length = 15, nullable = false, unique = true, updatable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Validate.notBlank(nome, "Dê um nome á permissão");
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		Validate.notBlank(descricao, "Permissão deve conter uma descrição");
		this.descricao = descricao;
	}
}
