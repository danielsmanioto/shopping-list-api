package com.dsmanioto.shoppinglist.shoppinglist.exception.handler.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class APIResponseError {
	
	private Integer status;
	
	private OffsetDateTime dateTime;
	
	private String message;
	
	private List<APIResponseErrorField> errorFields;
	
}
