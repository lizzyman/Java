package com.ktds.lizzy.exception;

public class MismatchValueException extends RuntimeException {
	
	private static final long serialVersionUID = -30715847255981948L;

	public MismatchValueException() {
		super();
		
	}

	public MismatchValueException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public MismatchValueException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MismatchValueException(String message) {
		super(message);
		
	}

	public MismatchValueException(Throwable cause) {
		super(cause);
		
	}

	
	
}
