package com.n26.transactions.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.n26.transactions.exception.UnProcessableTransactionException;

/**
 * The Class UnProcessableTransactionExceptionHandler.
 * @author sayedhamed
 */
@RestControllerAdvice
public class UnProcessableTransactionExceptionHandler {

		/**
		 * Handle un processable transaction exception.
		 *
		 * @param ex the ex
		 * @param request the request
		 * @return the response entity
		 */
		@ExceptionHandler({JsonParseException.class, InvalidFormatException.class, UnProcessableTransactionException.class})
		public final ResponseEntity<Object> handleUnProcessableTransactionException(Exception ex, WebRequest request) {

			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
}