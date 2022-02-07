package com.esanti.backendcash.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.esanti.backendcash.exception.BaseException;
import com.esanti.backendcash.response.ErrorResponse;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> businessException(final BaseException ex) {
        return new ResponseEntity<>(ex.toErrorResponse(), ex.getStatus());
    }

}
