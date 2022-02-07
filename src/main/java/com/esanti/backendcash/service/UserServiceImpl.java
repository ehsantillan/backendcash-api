package com.esanti.backendcash.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.esanti.backendcash.dto.UserDTO;
import com.esanti.backendcash.exception.UserException;
import com.esanti.backendcash.model.User;
import com.esanti.backendcash.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private ModelMapper mapper;

	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	/**
	 * Creates a UserServiceImpl.
	 * 
	 * @param userRepository
	 * @param modelMapper
	 */
	public UserServiceImpl(@Autowired final UserRepository userRepository, @Autowired final ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.mapper = modelMapper;

	}

	public UserDTO getUserById(int id) throws UserException {
		UserDTO userDto;
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userDto = mapper.map(user.get(), UserDTO.class);
		} else {
			LOGGER.log(Level.INFO,"Error find user By id "+ id);
			throw UserException.ofNotFoundUser();
		}

		return userDto;
	}

	public UserDTO createUser(UserDTO userDto) throws UserException {
		if (userDto == null || !StringUtils.hasLength(userDto.getFirstName())
				|| !StringUtils.hasLength(userDto.getLastName())) {
			
			LOGGER.log(Level.INFO,"Error invalid parameters received");
			throw UserException.ofBadRequest();
		}
		User user = mapper.map(userDto, User.class);
		User newUser = this.userRepository.save(user);
		UserDTO newUserDto = mapper.map(newUser, UserDTO.class);
		return newUserDto;

	}

	public void deleteUserById(int id) {
		this.userRepository.deleteById(id);
	}

}
