package com.dsmanioto.shoppinglist.shoppinglist.exception.handler;

import com.dsmanioto.shoppinglist.shoppinglist.exception.handler.dto.APIResponseError;
import com.dsmanioto.shoppinglist.shoppinglist.exception.handler.dto.APIResponseErrorField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		
		var erro = APIResponseError.builder()
				.dateTime(OffsetDateTime.now())
				.status(status.value())
				.message("Um ou mais campo não informado.")
				.errorFields(getErrorFields(ex))
				.build();
		
		return super.handleExceptionInternal(ex, erro, headers, status, request);
	}
	
	
	private ArrayList<APIResponseErrorField> getErrorFields(MethodArgumentNotValidException ex) {
		var fields = new ArrayList<APIResponseErrorField>();
		
		ex.getBindingResult().getAllErrors().stream().forEach(error -> {
			var nameField =  ((FieldError) error).getField();
			var message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			var field = APIResponseErrorField.builder()
					.name(nameField)
					.message(message)
					.build();
			
			fields.add(field);
		});
		
		return fields;
	}
	
}
