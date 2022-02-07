package com.esanti.backendcash.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import com.esanti.backendcash.dto.UserDTO;
import com.esanti.backendcash.exception.UserException;
import com.esanti.backendcash.model.User;
import com.esanti.backendcash.repository.UserRepository;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	private static final Integer USER_ID = (int) 1L;

	@Mock
	private UserRepository userRepository;

	private UserService userService;

	@Spy
	private ModelMapper mapper;

	@BeforeEach
	public void init() {
		userService = new UserServiceImpl(userRepository, mapper);
	}

	@Test
	public void testGetUserByIdThenReturnUser() throws UserException {
		when(userRepository.findById(USER_ID)).thenReturn(Optional.of(getUser()));
		final UserDTO userDto = userService.getUserById(USER_ID);
		assertNotNull(userDto);
		
		verify(userRepository, times(1)).findById(USER_ID);
	}

	@Test
	public void testGetUserByIdThenReturnException() throws UserException{
		when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());
		final UserException exception = assertThrows(UserException.class, () -> userService.getUserById(USER_ID));
		assertEquals("user_not_found", exception.getError());
		assertEquals("Invalid or not found user", exception.getMessage());
		assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());

		verify(userRepository, times(1)).findById(USER_ID);
	}

	@Test
	public void testDeleteUserByIdThenReturnSuccess() {
		userService.deleteUserById(USER_ID);	
		
		verify(userRepository, times(1)).deleteById(USER_ID);
	}

	
	@Test
	public void testSaveUserThenReturnUser() throws UserException {
		UserDTO userDto = getEntityIntoDTO(getUser());
		userDto.setId(0);
		when(userRepository.save(any())).thenReturn(getUser());		
		UserDTO newUser = userService.createUser(userDto);
		assertNotNull(newUser);	
		assertEquals(userDto.getFirstName(), newUser.getFirstName());

	}
	
	@Test
	public void testSaveUserThenReturnException() throws UserException {		
		final UserDTO newUserDto = mock(UserDTO.class);	
		final UserException exception = assertThrows(UserException.class, () -> userService.createUser(newUserDto));
		assertEquals("user_bad_request", exception.getError());
		assertEquals("Invalid request", exception.getMessage());
		assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());

	}

	private User getUser() {
		User user = new User();
		user.setId(USER_ID);
		user.setFirstName("Juan");
		user.setLastName("Alvarez");
		user.setEmail("jalvarez@test.com");
		return user;
	}
	
	private UserDTO getEntityIntoDTO(User source) {
		return mapper.map(source, UserDTO.class);	
		
	}

}
