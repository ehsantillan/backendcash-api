package com.esanti.backendcash;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esanti.backendcash.util.UtilMapper;

@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
	
	@Bean
	public UtilMapper utilMapper() {
		UtilMapper utilMapper = new UtilMapper();
		return utilMapper;
	}

}
