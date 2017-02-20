package br.com.epinefrina.domain.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncaixeOnlineException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Logger LOG = LoggerFactory.getLogger(EncaixeOnlineException.class);

	private String detalhe;

	public EncaixeOnlineException() {
	}

	public EncaixeOnlineException(String mensagem) {
		super(mensagem);
		LOG.error(mensagem);
	}

	public EncaixeOnlineException(String mensagem, String detalhe) {
		super(mensagem);
		LOG.error(mensagem);
		this.detalhe = detalhe;
	}

	public EncaixeOnlineException(Throwable causa) {
		super(causa);
	}

	public EncaixeOnlineException(String mensagem, Throwable causa) {
		super(mensagem, causa);
		LOG.error(mensagem);
		this.detalhe = causa.getMessage();
	}

	public Map<String, String> getErrorMap() {
		Map<String, String> map = new HashMap<>();
		map.put("erro", getMessage());
		map.put("detalhe", detalhe);
		return map;
	}

	public String getDetalhe() {
		return detalhe;
	}
}