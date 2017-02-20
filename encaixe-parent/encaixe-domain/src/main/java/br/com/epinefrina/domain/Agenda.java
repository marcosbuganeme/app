package br.com.epinefrina.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "agenda")
public class Agenda extends DomainEncaixeOnline<Long> {

	@Column(length = 50, nullable = false)
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo", nullable = false)
	private Tipo tipo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_agenda_criada_por_empresa"), name = "id_empresa", nullable = false)
	private Empresa empresa;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agenda")
	private List<Oferta> ofertas;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
}