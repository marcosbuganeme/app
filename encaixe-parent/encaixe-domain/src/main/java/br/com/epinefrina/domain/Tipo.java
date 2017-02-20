package br.com.epinefrina.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "tipo")
public class Tipo extends DomainEncaixeOnline<Long> {

	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_tipo_pertence_categoria"), name = "id_categoria", nullable = false)
	private Categoria categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}