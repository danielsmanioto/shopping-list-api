package com.dsmanioto.shoppinglist.shoppinglist.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		
		var erro = Error.builder()
				.dateTime(LocalDateTime.now())
				.status(status.value())
				.message("Um ou mais campo não informado.")
				.errorFields(getErrorFields(ex))
				.build();
		
		return super.handleExceptionInternal(ex, erro, headers, status, request);
	}
	
	private ArrayList<ErrorField> getErrorFields(MethodArgumentNotValidException ex) {
		var fields = new ArrayList<ErrorField>();
		
		ex.getBindingResult().getAllErrors().stream().forEach(error -> {
			var nameField =  ((FieldError) error).getField();
			var field = ErrorField.builder()
					.name(nameField)
					.message(error.getDefaultMessage())
					.build();
			
			fields.add(field);
		});
		return fields;
	}
	
}
