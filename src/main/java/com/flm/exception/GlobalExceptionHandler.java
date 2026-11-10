package com.flm.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException itemNotFoundException)
	{
		return new ResponseEntity<String>(itemNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsufficientQuantityException.class)
	public ResponseEntity<String> handleInsufficientQuantityException(InsufficientQuantityException insufficientQuantityException)
	{
		return new ResponseEntity<String>(insufficientQuantityException.getMessage(),HttpStatus.UNPROCESSABLE_CONTENT);
	}
	
	@ExceptionHandler(InvalidRatingException.class)
	public ResponseEntity<String> handleInavlidRatingException(InvalidRatingException invalidRatingException)
	{
		return new ResponseEntity<String>(invalidRatingException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException orderNotFoundException)
	{
		return new ResponseEntity<String>(orderNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	

}
