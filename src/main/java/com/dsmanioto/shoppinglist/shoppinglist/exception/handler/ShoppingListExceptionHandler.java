package com.dsmanioto.shoppinglist.shoppinglist.exception.handler;

import com.dsmanioto.shoppinglist.shoppinglist.exception.ShoppingListNotFoundException;
import com.dsmanioto.shoppinglist.shoppinglist.exception.handler.dto.APIResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@Slf4j
@RestControllerAdvice
public class ShoppingListExceptionHandler {
	
	@ExceptionHandler(ShoppingListNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public APIResponseError handleNotFountException(ShoppingListNotFoundException exception) {
		log.error("do not found", exception);
		
		return APIResponseError.builder()
				.message("Item not found")
				.status(HttpStatus.NOT_FOUND.value())
				.dateTime(OffsetDateTime.now())
				.build();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public APIResponseError handleNotFountException(Exception exception) {
		log.error("unknown error", exception);
		
		return APIResponseError.builder()
				.message("unknown error")
				.status(HttpStatus.NOT_FOUND.value())
				.dateTime(OffsetDateTime.now())
				.build();
	}
	
}
