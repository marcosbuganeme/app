package br.com.epinefrina.arquitetura.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Responsável por prover funções estáticas e atributos comuns entre os domínios
 * 
 * @author marcos.buganeme
 *
 * @param <T>
 *            - domínio que será parametrizado pela classe concreta
 */

@MappedSuperclass
public abstract class DomainEncaixeOnline<T extends Serializable> implements DomainEncaixe<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private T id;

	@Override
	public boolean isNovo() {
		return id == null;
	}

	@Override
	public T getIdentificador() {
		return id;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DomainEncaixeOnline)) {
			return false;
		}

		@SuppressWarnings("rawtypes")
		DomainEncaixeOnline other = (DomainEncaixeOnline) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}