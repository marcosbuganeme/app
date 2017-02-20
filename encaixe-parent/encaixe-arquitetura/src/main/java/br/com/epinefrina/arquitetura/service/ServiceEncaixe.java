package br.com.epinefrina.arquitetura.service;

import java.util.List;
import java.util.Optional;

import br.com.epinefrina.arquitetura.domain.DomainEncaixe;

/**
 * Respons�vel por prover m�todos est�ticos de consulta e persist�ncias
 * transacionais
 * 
 * @author marcos.buganeme
 *
 * @param <T>
 *            - dom�nio que ser� implementado
 * @param <PK>
 *            - tipo do identificador do dom�nio
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
	 * Remove um registro do dom�nio atrav�s de seu identificador
	 * 
	 * @param identificador
	 */
	public void deleta(PK identificador) {

	}

	/**
	 * Obt�m um registro pelo seu dom�nio
	 * 
	 * @param identificador
	 * @return <i>dom�nio consultado, caso n�o exista, um objeto nulo</i>
	 */
	public Optional<T> obtem(PK identificador) {
		return null;
	}

	/**
	 * Lista todos os registros do dom�nio
	 * 
	 * @return
	 */
	public List<T> lista() {
		return null;
	}
}