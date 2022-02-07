package com.esanti.backendcash.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esanti.backendcash.exception.LoanException;
import com.esanti.backendcash.service.LoanService;


@RestController 
@RequestMapping(value ="/loans")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getAllLoans(@RequestParam int page,
	        @RequestParam int size ,@RequestParam(value = "user_id",required = false,defaultValue = "0") int userId) throws LoanException {		
		Map<String, Object> response =  loanService.getAllLoans(page, size,userId);
		return new ResponseEntity<>(response, HttpStatus.OK);				
	}	

}