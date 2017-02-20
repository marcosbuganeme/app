package br.com.epinefrina.arquitetura.domain;

/**
 * Interface pai de todos os domínio
 * 
 * @author marcos.buganeme
 *
 * @param <T>
 *            - domínio que será passado pela classe concreta
 */

public interface DomainEncaixe<T> {

	/**
	 * Verifica se um registro foi ou não cadastrado através do identificador do
	 * domínio
	 * 
	 * @return <i>True, o registro é novo</i>
	 */
	boolean isNovo();

	/**
	 * @return <i>identificador do registro</i>
	 */
	T getIdentificador();
}
