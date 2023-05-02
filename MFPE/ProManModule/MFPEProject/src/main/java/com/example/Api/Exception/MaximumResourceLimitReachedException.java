package com.example.Api.Exception;


public class MaximumResourceLimitReachedException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaximumResourceLimitReachedException(String message) {
		super(message);
	}

}
