package io.github.lutrapp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus
public class UnsuportedOperationException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public UnsuportedOperationException(String exception) {
		super(exception);
	}

}
