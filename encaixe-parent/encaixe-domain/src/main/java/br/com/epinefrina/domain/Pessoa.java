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
@Table(name = "pessoa")
public class Pessoa extends DomainEncaixeOnline<Long> {

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(length = 50, nullable = false)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_pessoa_possui_usuario"), name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "pessoa")
	private List<Agendamento> agendamentos;

	@PrePersist
	private void vincularPerfil() {
		usuario.setPerfil(Perfil.PESSOA);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		Validate.notBlank(cpf, "Informe o número de cadastro de pessoa física");
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Validate.notBlank(nome, "Informe seu nome completo");
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
}