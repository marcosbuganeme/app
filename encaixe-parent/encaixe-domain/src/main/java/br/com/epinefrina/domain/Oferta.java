package br.com.epinefrina.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "oferta")
public class Oferta extends DomainEncaixeOnline<Long> {

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date criado;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_oferta_criada_por_agenda"), name = "id_agenda", nullable = false)
	private Agenda agenda;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private Controle controle;

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}
}