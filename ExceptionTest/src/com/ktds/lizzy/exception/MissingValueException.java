package com.ktds.lizzy.exception;

public class MissingValueException extends Exception {

	private static final long serialVersionUID = -692760834305213202L;

	public MissingValueException() {
		super();
		
	}

	public MissingValueException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public MissingValueException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MissingValueException(String message) {
		super(message);
		
	}

	public MissingValueException(Throwable cause) {
		super(cause);
		
	}

}
