package com.esanti.backendcash.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class PageDTO {
	


	private int page;
	
	private int size;

	private long total;
}
