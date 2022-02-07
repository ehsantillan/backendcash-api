package com.esanti.backendcash.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="tb_user")
@Getter 
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;	
	
	private String email ;
	
	@Column(name="first_name")
	private String firstName;	
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "userId", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    final private Set<Loan> loan = new HashSet<Loan>();

}
