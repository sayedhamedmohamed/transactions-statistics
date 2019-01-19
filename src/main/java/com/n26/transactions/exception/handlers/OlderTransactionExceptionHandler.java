package com.n26.transactions.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.n26.transactions.exception.OlderTransactionException;

/**
 * The Class OlderTransactionExceptionHandler.
 * @author sayedhamed
 */
@RestControllerAdvice
public class OlderTransactionExceptionHandler {

	/**
	 * Handle older transaction exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(OlderTransactionException.class)
	public final ResponseEntity<Object> handleOlderTransactionException(OlderTransactionException ex, WebRequest request) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
