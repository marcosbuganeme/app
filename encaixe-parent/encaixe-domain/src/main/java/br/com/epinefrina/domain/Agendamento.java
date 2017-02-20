package br.com.epinefrina.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "agendamento")
public class Agendamento extends DomainEncaixeOnline<Long> {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date criado;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_agendamento_pertence_pessoa"), name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_agendamento_pertence_oferta"), name = "id_oferta", nullable = false)
	private Oferta oferta;

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
}