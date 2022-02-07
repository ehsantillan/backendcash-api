package com.esanti.backendcash.exception;

public abstract class BusinessException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a BusinessException with message and cause.
     *
     * @param message       the error message
     * @param cause         the error cause
     */
    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a BusinessException with message and cause.
     *
     * @param message       the error message
     */
    public BusinessException(final String message) {
        super(message);
    }

}
