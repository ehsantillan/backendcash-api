package com.esanti.backendcash.service;

import com.esanti.backendcash.dto.UserDTO;
import com.esanti.backendcash.exception.UserException;

public interface UserService {
	
	/**
	 * Get User by id.
	 * @param id
	 * @return
	 * @throws UserException
	 */
	 UserDTO getUserById(int id) throws UserException;
	
	 /**
	  * Create User
	  * 
	  * @param userDto
	  * @return
	  * @throws UserException
	  */
	 UserDTO createUser(UserDTO userDto) throws UserException;
	 
	/**
	 * Delete User
	 * 
	 * @param id
	 */
	 void deleteUserById(int id) ;

}
