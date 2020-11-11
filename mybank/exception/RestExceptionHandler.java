package com.mybank.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = InsufficientFundException.class)
	public ResponseEntity<ErrorResponse> handleException(InsufficientFundException insufficientFundException) {
		ErrorResponse response = new ErrorResponse();
		response.setStatusCode("401");
		response.setStatusMessage(insufficientFundException.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(AccountNotFoundException accountNotFoundException) {
		ErrorResponse response = new ErrorResponse();
		response.setStatusCode("401");
		response.setStatusMessage(accountNotFoundException.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException argInvalidException,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatusCode("301");
		String allFieldErrors = argInvalidException.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getDefaultMessage()).collect(Collectors.joining(", "));
		response.setStatusMessage(allFieldErrors);
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
}
