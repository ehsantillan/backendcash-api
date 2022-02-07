package com.esanti.backendcash.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "tb_loan")
public class Loan {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id ;
	
	private BigDecimal  total;		
	
    @JoinColumn(name = "user_id")
    private int userId;
	
	
}
