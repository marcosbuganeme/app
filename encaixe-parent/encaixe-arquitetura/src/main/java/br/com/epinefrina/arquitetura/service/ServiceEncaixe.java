package br.com.epinefrina.arquitetura.service;

import java.util.List;
import java.util.Optional;

import br.com.epinefrina.arquitetura.domain.DomainEncaixe;

/**
 * Responsável por prover métodos estáticos de consulta e persistências
 * transacionais
 * 
 * @author marcos.buganeme
 *
 * @param <T>
 *            - domínio que será implementado
 * @param <PK>
 *            - tipo do identificador do domínio
 */

public abstract class ServiceEncaixe<T extends DomainEncaixe<PK>, PK> {

	/**
	 * Salva um registro de acordo com a classe concreta
	 * 
	 * @param dominio
	 * @return <i>registro salvo</i>
	 */
	public T salva(T dominio) {
		return null;
	}

	/**
	 * Remove um registro do domínio através de seu identificador
	 * 
	 * @param identificador
	 */
	public void deleta(PK identificador) {

	}

	/**
	 * Obtêm um registro pelo seu domínio
	 * 
	 * @param identificador
	 * @return <i>domínio consultado, caso não exista, um objeto nulo</i>
	 */
	public Optional<T> obtem(PK identificador) {
		return null;
	}

	/**
	 * Lista todos os registros do domínio
	 * 
	 * @return
	 */
	public List<T> lista() {
		return null;
	}
}