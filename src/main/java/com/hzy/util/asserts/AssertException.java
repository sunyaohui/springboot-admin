package com.hzy.util.asserts;


public class AssertException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2063282112481856096L;

	public AssertException() {
	}

	public AssertException(String message) {
		super(message);
	}

	public AssertException(Throwable e) {
		super(e);
	}

	public AssertException(String message, Throwable e) {
		super(message, e);
	}
}
