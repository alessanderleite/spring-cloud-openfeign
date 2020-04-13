package br.com.alessanderleite.app.advice;

import static java.time.Instant.now;
import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

import javax.validation.ConstraintDefinitionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alessanderleite.app.enumerator.CustomMessage;
import br.com.alessanderleite.app.exception.NotFoundException;
import br.com.alessanderleite.app.vo.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(final Exception e) {
		return status(INTERNAL_SERVER_ERROR)
				.body(this.constructorErrorResponse(INTERNAL_SERVER_ERROR, CustomMessage.SERVER_ERROR.getMessage()));
	}
	
	@ExceptionHandler(ConstraintDefinitionException.class)
	public ResponseEntity<ErrorResponse> handleConstraintDefinitionException(final ConstraintDefinitionException e) {
		return status(NOT_ACCEPTABLE)
				.body(this.constructorErrorResponse(NOT_ACCEPTABLE, CustomMessage.NOT_ACCEPTABLE.getMessage()));
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUpdateException(final NotFoundException e) {
		return status(NOT_FOUND)
				.body(this.constructorErrorResponse(NOT_FOUND, CustomMessage.NOT_FOUND.getMessage()));
	}
	
	private ErrorResponse constructorErrorResponse(final HttpStatus httpStatus, final String... messages) {
		return new ErrorResponse(now(), httpStatus.value(), httpStatus.getReasonPhrase(), asList(messages));
	}
}
