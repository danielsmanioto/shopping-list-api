package com.dsmanioto.shoppinglist.shoppinglist.exceptionhandler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorField {
	
	private String name;
	private String message;
	
}
