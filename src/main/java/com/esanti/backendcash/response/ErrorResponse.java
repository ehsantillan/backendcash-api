package com.esanti.backendcash.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
	
	private final String message;	
    private final String code;    
    

}
