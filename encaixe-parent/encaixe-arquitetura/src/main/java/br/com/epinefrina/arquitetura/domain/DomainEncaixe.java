package br.com.epinefrina.arquitetura.domain;

/**
 * Interface pai de todos os dom�nio
 * 
 * @author marcos.buganeme
 *
 * @param <T>
 *            - dom�nio que ser� passado pela classe concreta
 */

public interface DomainEncaixe<T> {

	/**
	 * Verifica se um registro foi ou n�o cadastrado atrav�s do identificador do
	 * dom�nio
	 * 
	 * @return <i>True, o registro � novo</i>
	 */
	boolean isNovo();

	/**
	 * @return <i>identificador do registro</i>
	 */
	T getIdentificador();
}
