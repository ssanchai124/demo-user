package com.example.user_api.exception;

public class AppException extends Exception {

	public AppException() {
		super();
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(String message, Throwable ex) {
		super(message, ex);
	}
}