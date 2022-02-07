package com.esanti.backendcash.exception;

import org.springframework.http.HttpStatus;

import com.esanti.backendcash.response.ErrorResponse;

import lombok.Getter;

@Getter
public class LoanException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String error;	
    private final String message;    
    private final HttpStatus status;

    /**
     * Private constructor. Creates a LoanException with error, message and status.
     *
     * @param error         the error code
     * @param message       the error message
     * @param status        the error status
     */
    private LoanException(final String error, final String message, final HttpStatus status) {
        super(message);
        this.error = error;
        this.message = message;
        this.status = status;
    }
    
    /**
     * Private constructor. Creates a LoanException with error, message, status and cause.
     *
     * @param error         the error code
     * @param message       the error message
     * @param status        the error status
     * @param cause         the error cause
     */
    private LoanException(final String error, final String message, final HttpStatus status, final Throwable cause) {
        super(message, cause);
        this.error = error;
        this.message = message;
        this.status = status;
    }

    
    /**
     * Creates a LoanException.
     *
     * @return a new {@link LoanException} with error, message and status.
     */
    public static LoanException ofNotFoundLoan() {
        return new LoanException("loan_not_found", "Invalid or not found loan", HttpStatus.NOT_FOUND);
    }
    
    /**
     * Creates a LoanException.
     *
     * @return a new {@link LoanException} with error, message and status.
     */
    public static LoanException ofBadRequest() {
        return new LoanException("loan_bad_request", "Invalid request", HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Creates a LoanException with error, message, status and cause.
     *
     * @param error         the error code
     * @param message       the error message
     * @param status        the error status
     * @param cause         the error cause
     * @return a new {@link LoanException} with error, message, status and cause.
     */
    public static LoanException of(final String error, final String message, final HttpStatus status, final Throwable cause) {
        return new LoanException(error, message, status, cause);        
    }
    
    @Override
    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(message, error);
    }
    
 

}
