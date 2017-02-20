package br.com.epinefrina.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.Validate;
import org.springframework.util.StringUtils;

import br.com.epinefrina.arquitetura.domain.DomainEncaixeOnline;

@Entity
@Table(name = "usuario")
public class Usuario extends DomainEncaixeOnline<Long> {

	@Column(length = 20, nullable = false, updatable = false, unique = true)
	private String login;

	@Column(length = 64, nullable = false)
	private String senha;

	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false, unique = true)
	private Perfil perfil;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastrado;

	@Transient
	private String contraSenha;

	@PrePersist
	private void vinculaHorarioDeCadastro() {
		cadastrado = new Date();
	}

	public void comparaSenha(String senha, String contraSenha) {
		if (StringUtils.pathEquals(senha, contraSenha)) {
			throw new IllegalArgumentException("Senhas não correspondem");
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		Validate.notBlank(login, "Informe o login de usuário");
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		Validate.notBlank(senha, "Informe uma senha");
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Validate.notBlank(email, "Informe um e-mail para contato");
		this.email = email;
	}

	public String getContraSenha() {
		return contraSenha;
	}

	public void setContraSenha(String contraSenha) {
		Validate.notBlank(contraSenha, "Confirme a senha");
		this.contraSenha = contraSenha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	protected void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Date getCadastrado() {
		return cadastrado;
	}
}