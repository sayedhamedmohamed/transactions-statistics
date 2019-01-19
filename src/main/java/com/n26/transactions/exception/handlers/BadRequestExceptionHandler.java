package com.n26.transactions.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.n26.transactions.exception.BadRequestException;

/**
 * The Class BadRequestExceptionHandler.
 * @author sayedhamed
 */
@RestControllerAdvice
public class BadRequestExceptionHandler {

	/**
	 * Handle bad request exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
