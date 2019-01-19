package com.n26.transactions.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * The Class MethodArgumentNotValidExceptionHandler.
 * @author sayedhamed
 */
@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

	/**
	 * Handle message not exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMessageNotException(MethodArgumentNotValidException ex, WebRequest request) {
		
		return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

	}

}