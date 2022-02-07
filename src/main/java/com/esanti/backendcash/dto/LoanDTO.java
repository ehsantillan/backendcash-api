package com.esanti.backendcash.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;


@Data
public class LoanDTO implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id ;	
	
	
	private BigDecimal total;	

	private int userId; 

}
