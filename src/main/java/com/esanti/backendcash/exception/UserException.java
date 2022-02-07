package com.esanti.backendcash.exception;


import org.springframework.http.HttpStatus;

import com.esanti.backendcash.response.ErrorResponse;

import lombok.Getter;

@Getter
public class UserException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	private final String error;	
    private final String message;    
    private final HttpStatus status;
    
    /**
     * Private constructor. Creates a UserException with error, message and status.
     *
     * @param error         the error code
     * @param message       the error message
     * @param status        the error status
     */
    private UserException(final String error, final String message, final HttpStatus status) {
        super(message);
        this.error = error;
        this.message = message;
        this.status = status;
    }
    
    /**
     * Private constructor. Creates a UserException with error, message, status and cause.
     *
     * @param error         the error code
     * @param message       the error message
     * @param status        the error status
     * @param cause         the error cause
     */
    private UserException(final String error, final String message, final HttpStatus status, final Throwable cause) {
        super(message, cause);
        this.error = error;
        this.message = message;
        this.status = status;
    }

    
    /**
     * Creates a UserException.
     *
     * @return a new {@link UserException} with error, message and status.
     */
    public static UserException ofNotFoundUser() {
        return new UserException("user_not_found", "Invalid or not found user", HttpStatus.NOT_FOUND);
    }
    
    /**
     * Creates a UserException.
     *
     * @return a new {@link UserException} with error, message and status.
     */
    public static UserException ofBadRequest() {
        return new UserException("user_bad_request", "Invalid request", HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Creates a UserException with error, message, status and cause.
     *
     * @param error         the error code
     * @param message       the error message
     * @param status        the error status
     * @param cause         the error cause
     * @return a new {@link UserException} with error, message, status and cause.
     */
    public static UserException of(final String error, final String message, final HttpStatus status, final Throwable cause) {
        return new UserException(error, message, status, cause);        
    }
    
    @Override
    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(message, error);
    }
    
 



}
