package com.esanti.backendcash.dto;

import java.io.Serializable;
import java.util.Set;

import com.esanti.backendcash.model.Loan;

import lombok.Data;


@Data
public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id ;
	
	private String email ;
	
	private String firstName;	
	
	private String lastName;
	
	private Set<Loan> loan;

}
