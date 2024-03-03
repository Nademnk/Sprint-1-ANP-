package com.BlueChem.sbtp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class GlobalExceptionhandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CustomerIDNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerException(
			CustomerIDNotFoundException ex, WebRequest request){
		ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
		
	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorMessage> handleproductException(
			ProductException ex, WebRequest request){
		ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
		
	}

}
