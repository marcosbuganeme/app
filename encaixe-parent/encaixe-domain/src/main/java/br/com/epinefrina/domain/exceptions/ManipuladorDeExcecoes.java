package br.com.epinefrina.domain.exceptions;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ManipuladorDeExcecoes {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public Map<String, String> exception(IllegalArgumentException excecao) {
		return Collections.singletonMap("erro", excecao.getMessage());
	}

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public Map<String, String> exception(NullPointerException excecao) {
		return Collections.singletonMap("erro", "Erro interno de nullPointerException");
	}

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = EncaixeOnlineException.class)
	public Map<String, String> exception(EncaixeOnlineException excecao) {
		return excecao.getErrorMap();
	}
}