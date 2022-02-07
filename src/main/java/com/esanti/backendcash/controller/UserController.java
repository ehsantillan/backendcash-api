package com.esanti.backendcash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esanti.backendcash.dto.UserDTO;
import com.esanti.backendcash.exception.UserException;
import com.esanti.backendcash.service.UserService;

@RestController 
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUser(@PathVariable int id)throws UserException {		
		UserDTO userDto = userService.getUserById(id);
		return ResponseEntity.ok(userDto);			
	}
	
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) throws UserException{		
		UserDTO createUser = userService.createUser(userDTO);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);		
	}
	
	@DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUserById(@PathVariable int id)  {		
		userService.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
