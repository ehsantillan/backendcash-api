package com.esanti.backendcash.service;

import java.util.Map;

import com.esanti.backendcash.exception.LoanException;

public interface LoanService {
	
	
	/**
	 * Get all Loans
	 * 
	 * @param page
	 * @param size
	 * @param userId
	 * @return
	 */
	Map<String, Object> getAllLoans(int page,int size,int userId) throws LoanException;
	


}
