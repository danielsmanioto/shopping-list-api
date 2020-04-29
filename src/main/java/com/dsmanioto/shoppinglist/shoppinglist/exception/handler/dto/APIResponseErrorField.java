package com.dsmanioto.shoppinglist.shoppinglist.exception.handler.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIResponseErrorField {
	
	private String name;
	private String message;
	
}
