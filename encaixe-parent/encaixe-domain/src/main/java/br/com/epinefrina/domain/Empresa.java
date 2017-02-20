package br.com.epinefrina.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "empresa")
public class Empresa extends DomainEncaixeOnline<Long> {

	@Column(length = 14, nullable = false, unique = true, updatable = false)
	private String cnpj;

	@Column(length = 50, name = "razao_social", nullable = false)
	private String razaoSocial;

	@Column(length = 50, nullable = false)
	private String responsavel;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_empresa_possui_usuario"), name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "empresa")
	private List<Agenda> agendas;

	@PrePersist
	private void vincularPerfil() {
		usuario.setPerfil(Perfil.EMPRESA);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		Validate.notBlank(cnpj, "Informe o número documento de cadastro de pessoa jurídica");
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		Validate.notBlank(razaoSocial, "Informe a razão social da empresa");
		this.razaoSocial = razaoSocial;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		Validate.notBlank(responsavel, "Informe o nome do responsável pela empresa");
		this.responsavel = responsavel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
}