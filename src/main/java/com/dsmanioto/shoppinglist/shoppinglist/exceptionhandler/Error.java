package com.dsmanioto.shoppinglist.shoppinglist.exceptionhandler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Error {

	private Integer status;
	private LocalDateTime dateTime;
	private String message;
	private List<ErrorField> errorFields;
	
}
