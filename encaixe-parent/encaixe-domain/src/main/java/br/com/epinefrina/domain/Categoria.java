package br.com.epinefrina.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "categoria")
public class Categoria extends DomainEncaixeOnline<Long> {

	private String nome;
	private List<Tipo> tipos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
}